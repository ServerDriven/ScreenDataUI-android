package com.pv.screendataui.viewsamples

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pv.screendata.objects.SomeColor
import com.pv.screendata.objects.SomeStyle
import com.pv.screendata.types.Alignment
import com.pv.screendata.views.SomeText
import com.pv.screendataui.SDScreenDemo.hexToSomeColor
import com.pv.screendataui.toComposeColor
import com.pv.screendataui.toSafeComposeColor

@Composable
fun SDText(someText: SomeText) {

    val padding = someText.style?.padding?.dp ?: 0.dp

    val textModifier = Modifier.fillMaxWidth().then(
        Modifier.padding(
            start = padding,
            end = padding
        )
    )

    Text(
        text = someText.title,
        modifier = textModifier,
        fontSize = 14.sp,
        color = someText.style?.foregroundColor.toSafeComposeColor()
    )
}

@Preview(showBackground = true)
@Composable
fun sdTextPreview() {

    SDText(
        someText = SomeText(
            id = "id",
            title = "Trying this out tho",
            style = SomeStyle(
                backgroundColor = "#000000".hexToSomeColor(),
                foregroundColor = "#0080ff".hexToSomeColor(),
                cornerRadius = 0,
                padding = 8,
                alignment = Alignment.center
            )
        )
    )
}
