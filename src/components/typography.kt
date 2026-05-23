package ui.components

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType

object Typography {
    val h1 = TextStyle(
        fontSize = TextUnit(36f, TextUnitType.Sp),
        fontWeight = FontWeight.ExtraBold,
        lineHeight = TextUnit(40f, TextUnitType.Sp)
    )
    val h2 = TextStyle(
        fontSize = TextUnit(30f, TextUnitType.Sp),
        fontWeight = FontWeight.Bold,
        lineHeight = TextUnit(36f, TextUnitType.Sp)
    )
    val h3 = TextStyle(
        fontSize = TextUnit(24f, TextUnitType.Sp),
        fontWeight = FontWeight.SemiBold,
        lineHeight = TextUnit(32f, TextUnitType.Sp)
    )
    val h4 = TextStyle(
        fontSize = TextUnit(20f, TextUnitType.Sp),
        fontWeight = FontWeight.SemiBold,
        lineHeight = TextUnit(28f, TextUnitType.Sp)
    )
    val h5 = TextStyle(
        fontSize = TextUnit(16f, TextUnitType.Sp),
        fontWeight = FontWeight.SemiBold,
        lineHeight = TextUnit(24f, TextUnitType.Sp)
    )
    val h6 = TextStyle(
        fontSize = TextUnit(14f, TextUnitType.Sp),
        fontWeight = FontWeight.SemiBold,
        lineHeight = TextUnit(20f, TextUnitType.Sp)
    )
    val large = TextStyle(
        fontSize = TextUnit(18f, TextUnitType.Sp),
        fontWeight = FontWeight.Normal,
        lineHeight = TextUnit(28f, TextUnitType.Sp)
    )
    val body = TextStyle(
        fontSize = TextUnit(14f, TextUnitType.Sp),
        fontWeight = FontWeight.Normal,
        lineHeight = TextUnit(20f, TextUnitType.Sp)
    )
    val small = TextStyle(
        fontSize = TextUnit(12f, TextUnitType.Sp),
        fontWeight = FontWeight.Normal,
        lineHeight = TextUnit(16f, TextUnitType.Sp)
    )
    val muted = TextStyle(
        fontSize = TextUnit(14f, TextUnitType.Sp),
        fontWeight = FontWeight.Normal,
        lineHeight = TextUnit(20f, TextUnitType.Sp)
    )
    val lead = TextStyle(
        fontSize = TextUnit(20f, TextUnitType.Sp),
        fontWeight = FontWeight.Normal,
        lineHeight = TextUnit(28f, TextUnitType.Sp)
    )
    val blockquote = TextStyle(
        fontSize = TextUnit(14f, TextUnitType.Sp),
        fontWeight = FontWeight.Normal,
        lineHeight = TextUnit(20f, TextUnitType.Sp)
    )
    val code = TextStyle(
        fontSize = TextUnit(12f, TextUnitType.Sp),
        fontWeight = FontWeight.Medium,
        lineHeight = TextUnit(16f, TextUnitType.Sp)
    )
    val label = TextStyle(
        fontSize = TextUnit(14f, TextUnitType.Sp),
        fontWeight = FontWeight.Medium,
        lineHeight = TextUnit(20f, TextUnitType.Sp)
    )
}