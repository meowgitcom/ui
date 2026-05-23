package ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip

import LocalContentColor
import LocalPalette
import Space

@Composable fun Card(
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit
) {
    val palette = LocalPalette.current
    val shape = RoundedCornerShape(Space.lg)

    CompositionLocalProvider(LocalContentColor provides palette.cardForeground) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .clip(shape)
                .background(palette.card)
                .border(Space.hairline, palette.border, shape)
                .padding(Space.xl)
        ) {
            content()
        }
    }
}

@Composable fun CardHeader(
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = Space.md)
    ) {
        content()
    }
}

@Composable fun CardTitle(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        modifier = modifier,
        style = Typography.h5
    )
}

@Composable fun CardDescription(
    text: String,
    modifier: Modifier = Modifier
) {
    val palette = LocalPalette.current
    CompositionLocalProvider(LocalContentColor provides palette.mutedForeground) {
        Text(
            text = text,
            modifier = modifier,
            style = Typography.small
        )
    }
}

@Composable fun CardContent(
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = Space.md)
    ) {
        content()
    }
}

@Composable fun CardFooter(
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = Space.md)
    ) {
        content()
    }
}