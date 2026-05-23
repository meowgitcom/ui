import hashlib
import os
import sys
import xml.etree.ElementTree as ET


def existing_dirs(paths):
    seen = set()
    for path in paths:
        if not path:
            continue
        path = os.path.abspath(os.path.expanduser(path))
        if path in seen or not os.path.isdir(path):
            continue
        seen.add(path)
        yield path


def sdk_roots():
    home = os.path.expanduser("~")
    kotlin_cache = os.path.join(home, ".cache", "JetBrains", "Kotlin")
    candidates = [
        os.environ.get("ANDROID_HOME"),
        os.environ.get("ANDROID_SDK_ROOT"),
        "/opt/android-sdk-linux",
        os.path.join(home, "Android", "Sdk"),
    ]
    if os.path.isdir(kotlin_cache):
        for root, dirs, _ in os.walk(kotlin_cache):
            name = os.path.basename(root).lower()
            if name == "android-sdk" or (
                "android" in name and ("cmdline-tools" in dirs or "platforms" in dirs or "licenses" in dirs)
            ):
                candidates.append(root)
    return list(existing_dirs(candidates))


def license_hashes(roots):
    hashes = {}
    for sdk in roots:
        for root, _, files in os.walk(sdk):
            if "package.xml" not in files:
                continue
            path = os.path.join(root, "package.xml")
            try:
                tree = ET.parse(path)
            except Exception as exc:
                sys.stderr.write("skip {}: {}\n".format(path, exc))
                continue

            for el in tree.iter():
                tag = el.tag.split("}")[-1] if "}" in el.tag else el.tag
                if tag != "license" or not el.get("id"):
                    continue
                text = (el.text or "").strip()
                if text:
                    hashes.setdefault(el.get("id"), set()).add(hashlib.sha1(text.encode("utf-8")).hexdigest())
    return hashes


def append_missing(path, values):
    existing = set()
    if os.path.exists(path):
        with open(path) as file:
            existing = {line.strip() for line in file if line.strip()}
    missing = [value for value in sorted(values) if value not in existing]
    if not missing:
        return
    with open(path, "a") as file:
        for value in missing:
            file.write(value + "\n")


roots = sdk_roots()
hashes = license_hashes(roots)
if not hashes:
    sys.stderr.write("No Android SDK license hashes found under: {}\n".format(", ".join(roots)))
    sys.exit(1)

for sdk in roots:
    licenses_dir = os.path.join(sdk, "licenses")
    if not os.path.exists(licenses_dir):
        os.makedirs(licenses_dir)
    for license_id, values in hashes.items():
        append_missing(os.path.join(licenses_dir, license_id), values)
