package com.pv.screendataui.views

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.Typeface
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pv.screendata.objects.SomeColor
import com.pv.screendata.objects.SomeStyle
import com.pv.screendata.types.FontType
import com.pv.screendata.views.SomeLabel
import com.pv.screendataui.store.SomeFontStoreHolder
import com.pv.screendataui.toComposeColor
import com.pv.sddestination.SDDestinationStore

@Composable
fun SDLabel(label: SomeLabel) {

    if (label.style?.isHidden == true) return

    val padding = label.style?.padding?.dp ?: 0.dp

    val labelModifier = Modifier
        .fillMaxWidth()
        .then(
            Modifier.clickable(onClick = {
                SDDestinationStore.desinationHandler?.handeDestination(label.destination)
            })
        )
        .then(
            Modifier.background(
                color = label.style?.backgroundColor?.toComposeColor() ?: Color.Transparent,
                shape = RoundedCornerShape(
                    size = label.style?.cornerRadius?.dp ?: 0.dp
                )
            )
        )
        .then(
            Modifier.padding(
                all = padding
            )
        )

    val textColor = label.style?.foregroundColor?.toComposeColor() ?: Color.White
    val shouldBold = SomeFontStoreHolder.someCustomFontMap[label.font]?.bold ?: false
    val weight = if (shouldBold) FontWeight.Bold else FontWeight.Normal
    val fontFamily = SomeFontStoreHolder.font?.let {
        FontFamily(it)
    }

    val horizontalAlignment = Alignment.Start

    Column(
        modifier = labelModifier,
        horizontalAlignment = horizontalAlignment
    ) {

        label.title.takeIf { it.isNotEmpty() }?.let {
            Text(
                text = label.title,
                fontSize = SomeFontStoreHolder.someCustomFontMap[label.font]!!.size,
                color = textColor,
                fontWeight = weight,
                fontFamily = fontFamily
            )
        }

        label.subtitle?.let {
            Text(
                text = it,
                fontSize = 12.sp,
                color = textColor,
                fontFamily = fontFamily
            )
        }
    }
}

@Preview
@Composable
private fun SDLabelPreview() {
    SDLabel(label = SDLabelMock.mock)
}

internal object SDLabelMock {

    val mock = SomeLabel(
        id = "sdLabelId",
        title = "",
        subtitle = "Just a subtitle",
        style = SomeStyle(
            foregroundColor = SomeColor(
                1f, 1f, 1f, 1f
            ),
            backgroundColor = SomeColor(
                0.5f, 0.5f, 0.5f, 1f
            ),
            cornerRadius = 8,
            padding = 12
        ),
        destination = null,
        font = FontType.title
    )
}

