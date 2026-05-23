package ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.SolidColor

import LocalPalette
import Space

@Composable fun Input(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    placeholder: String = "",
    enabled: Boolean = true,
    singleLine: Boolean = true,
) {
    val palette = LocalPalette.current
    val interactionSource = remember { MutableInteractionSource() }
    val isFocused by interactionSource.collectIsFocusedAsState()

    val borderColor = when {
        !enabled  -> palette.border.copy(alpha = 0.5f)
        isFocused -> palette.ring
        else      -> palette.border
    }

    val shape = RoundedCornerShape(Space.sm)

    BasicTextField(
        value = value,
        onValueChange = onValueChange,
        enabled = enabled,
        singleLine = singleLine,
        interactionSource = interactionSource,
        textStyle = Typography.body.copy(
            color = if (enabled) palette.foreground else palette.foreground.copy(alpha = 0.5f)
        ),
        cursorBrush = SolidColor(palette.foreground),
        modifier = modifier
            .fillMaxWidth()
            .height(Space.xxxl)
            .clip(shape)
            .background(palette.background)
            .border(Space.hairline, borderColor, shape),
        decorationBox = { innerTextField ->
            Box(
                contentAlignment = Alignment.CenterStart,
                modifier = Modifier.padding(horizontal = Space.md)
            ) {
                if (value.isEmpty()) {
                    Text(
                        text = placeholder,
                        style = Typography.body.copy(color = palette.mutedForeground)
                    )
                }
                innerTextField()
            }
        }
    )
}