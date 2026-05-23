import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

data class Palette(
    val background: Color,
    val foreground: Color,
    val primary: Color,
    val primaryForeground: Color,
    val secondary: Color,
    val secondaryForeground: Color,
    val muted: Color,
    val mutedForeground: Color,
    val accent: Color,
    val accentForeground: Color,
    val destructive: Color,
    val destructiveForeground: Color,
    val card: Color,
    val cardForeground: Color,
    val popover: Color,
    val popoverForeground: Color,
    val border: Color,
    val input: Color,
    val ring: Color
)

val LocalPalette = compositionLocalOf<Palette> { error("no palette provided") }
val LocalContentColor = compositionLocalOf { Color.Unspecified }

@Composable fun ApplyTheme(
    palette: Palette,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(LocalPalette provides palette, LocalContentColor provides palette.foreground) {
        content()
    }
}