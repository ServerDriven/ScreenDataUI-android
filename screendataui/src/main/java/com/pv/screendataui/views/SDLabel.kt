package com.pv.screendataui.views

import androidx.compose.material.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.pv.screendata.objects.SomeColor
import com.pv.screendata.objects.SomeStyle
import com.pv.screendata.types.Alignment
import com.pv.screendata.types.FontType
import com.pv.screendata.views.SomeLabel
import com.pv.screendataui.toComposeColor

@Composable
fun SDLabel(label: SomeLabel) {

    val padding = label.style?.padding?.dp ?: 0.dp

    val labelModifier = Modifier.fillMaxWidth().then(
        Modifier.padding(
            start = padding,
            end = padding
        )
    )

    val textColor = label.style?.foregroundColor?.toComposeColor() ?: Color.Magenta

    val size = when (label.font) {
        FontType.largeTitle -> 24.sp
        FontType.title -> 20.sp
        FontType.headline -> 16.sp
        FontType.body -> 14.sp
        FontType.footnote -> 12.sp
        FontType.caption -> 12.sp
    }

    Column(modifier = labelModifier) {

        label.title.takeIf { it.isNotEmpty() }?.let {
            Text(
                text = label.title,
                fontSize = size,
                color = textColor,
                textAlign = TextAlign.Center
            )
        }

        label.subtitle?.let {
            Text(
                text = it,
                fontSize = 12.sp,
                color = textColor
            )
        }
    }
}

@Preview
@Composable
internal fun SDLabelPreview() {
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
            alignment = Alignment.center
        ),
        destination = null,
        font = FontType.title
    )
}

