import hashlib, os, sys, xml.etree.ElementTree as ET
sdk = ""/opt/android-sdk-linux"
for r, _, fs in os.walk(sdk):
    if "package.xml" not in fs:
        continue
    fp = os.path.join(r, "package.xml")
    try:
        tree = ET.parse(fp)
        for el in tree.iter():
            tag = el.tag.split("}")[-1] if "}" in el.tag else el.tag
            if tag != "license" or not el.get("id"):
                continue
            t = (el.text or "").strip()
            if not t:
                continue
            h = hashlib.sha1(t.encode("utf-8")).hexdigest()
            ld = os.path.join(sdk, "licenses")
            if not os.path.exists(ld):
                os.makedirs(ld)
            with open(os.path.join(ld, el.get("id")), "a") as f:
                f.write("\n" + h)
    except Exception as e:
        sys.stderr.write("skip {}: {}\n".format(fp, e))