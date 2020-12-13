package com.pv.screendataui.viewsamples

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.pv.screendata.views.SomeImage
import com.pv.screendataui.R

// Todo : Not implemented yet boi

@Composable
fun SDImage(image: SomeImage) {

    val iModifier = Modifier.fillMaxWidth() +
            Modifier.padding(
                start = image.someStyle?.paddingStart?.dp ?: 0.dp,
                end = image.someStyle?.paddingEnd?.dp ?: 0.dp
            )

    Image(
        asset = imageResource(id = R.drawable.mine_image_sample),
        modifier = iModifier
    )
}

@Preview
@Composable
fun sdImagePreview() {
    SDImage(image = SDImage.mock)
}

object SDImage {

    val mock = SomeImage(
        id = "",
        url = "",
        someStyle = null,
        destination = null
    )
}
