package com.pv.screendataui.viewsamples

import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.ui.tooling.preview.Preview
import com.pv.screendata.views.SomeLabel
import com.pv.screendataui.toComposeColor

@Composable
fun SDLabel(label: SomeLabel) {

    val labelModifier = Modifier.fillMaxWidth() +
            Modifier.padding(
                start = label.someStyle?.paddingStart?.dp ?: 0.dp,
                end = label.someStyle?.paddingEnd?.dp ?: 0.dp
            )

    val textColor = label.someStyle?.foregroundColor?.toComposeColor() ?: Color.White


    Column(modifier = labelModifier) {
        Text(
            text = label.title,
            fontSize = 16.sp,
            color = textColor,
            textAlign = TextAlign.Center
        )

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
fun sdLabelPreview() {
    SDLabel(label = SDLabel.mock)
}

object SDLabel {

    val mock = SomeLabel(
        id = "sdLabelId",
        title = "Just the main Title",
        subtitle = "Just a subtitle",
        someStyle = null,
        destination = null
    )
}

