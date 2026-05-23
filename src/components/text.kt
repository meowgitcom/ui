package ui.components

import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle

import LocalContentColor

@Composable
fun Text(
    text: String,
    modifier: Modifier = Modifier,
    style: TextStyle = TextStyle.Default
) {
    val color = LocalContentColor.current
    BasicText(
        text = text,
        modifier = modifier,
        style = style.copy(color = color)
    )
}