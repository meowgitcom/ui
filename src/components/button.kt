package ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color

import LocalContentColor
import LocalPalette
import Space

enum class ButtonVariant {
    Default,
    Destructive,
    Outline,
    Secondary,
    Ghost,
    Link
}

enum class ButtonSize {
    Default,
    Sm,
    Lg,
    Icon
}

@Composable
fun Button(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    variant: ButtonVariant = ButtonVariant.Default,
    size: ButtonSize = ButtonSize.Default,
    enabled: Boolean = true,
    content: @Composable () -> Unit
) {
    val palette = LocalPalette.current

    val (bg, fg, borderColor) = when (variant) {
        ButtonVariant.Default     -> Triple(palette.primary, palette.primaryForeground, Color.Transparent)
        ButtonVariant.Destructive -> Triple(palette.destructive, palette.destructiveForeground, Color.Transparent)
        ButtonVariant.Outline     -> Triple(Color.Transparent, palette.foreground, palette.border)
        ButtonVariant.Secondary   -> Triple(palette.secondary, palette.secondaryForeground, Color.Transparent)
        ButtonVariant.Ghost       -> Triple(Color.Transparent, palette.foreground, Color.Transparent)
        ButtonVariant.Link        -> Triple(Color.Transparent, palette.primary, Color.Transparent)
    }

    val padding = when (size) {
        ButtonSize.Default -> PaddingValues(horizontal = Space.lg, vertical = Space.sm)
        ButtonSize.Sm      -> PaddingValues(horizontal = Space.md, vertical = Space.xs)
        ButtonSize.Lg      -> PaddingValues(horizontal = Space.xl, vertical = Space.md)
        ButtonSize.Icon    -> PaddingValues(all = Space.none)
    }

    val height = when (size) {
        ButtonSize.Default -> Space.xxxl
        ButtonSize.Sm      -> Space.xxl
        ButtonSize.Lg      -> Space.xxxxl
        ButtonSize.Icon    -> Space.xxxl
    }

    val shape = RoundedCornerShape(Space.sm)

    CompositionLocalProvider(LocalContentColor provides if (enabled) fg else fg.copy(alpha = 0.5f)) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = modifier
                .height(height)
                .clip(shape)
                .background(if (enabled) bg else bg.copy(alpha = 0.5f))
                .border(BorderStroke(Space.hairline, if (enabled) borderColor else borderColor.copy(alpha = 0.5f)), shape)
                .clickable(
                    enabled = enabled,
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() }
                ) { onClick() }
                .padding(padding)
        ) {
            content()
        }
    }
}