package com.pv.screendataui.viewsamples

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pv.screendata.objects.SomeColor
import com.pv.screendata.objects.SomeStyle
import com.pv.screendata.types.Alignment
import com.pv.screendata.views.SomeText
import com.pv.screendataui.SDScreenDemo.hexToSomeColor

@Composable
fun SDText(someText: SomeText) {

    val textModifier = Modifier.fillMaxWidth().then(
        Modifier.padding(
            start = someText.style.paddingStart.dp,
            end = someText.style.paddingEnd.dp
        )
    )

    Text(
        text = someText.title,
        modifier = textModifier
    )
}

@Preview
@Composable
internal fun sdTextPreview() {

    SDText(
        someText = SomeText(
            id = "id",
            title = "Trying this out",
            style = SomeStyle(
                backgroundColor = "#000000".hexToSomeColor(),
                foregroundColor = "#0080ff".hexToSomeColor(),
                cornerRadius = 0,
                paddingStart = 8,
                paddingEnd = 8,
                alignment = Alignment.center
            )
        )
    )
}
