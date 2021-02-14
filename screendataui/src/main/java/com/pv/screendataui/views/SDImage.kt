package com.pv.screendataui.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.pv.screendata.views.SomeImage
import com.pv.screendataui.R
import com.pv.sddestination.SDDestinationStore

// Todo : Not implemented yet boi

@Composable
fun SDImage(image: SomeImage) {

    val iModifier = Modifier.fillMaxWidth().then(
        Modifier.padding(
            start = image.style?.padding?.dp ?: 0.dp,
            end = image.style?.padding?.dp ?: 0.dp
        )
    )

    Image(
        imageResource(id = image.idRes ?: R.drawable.mine_image_sample),
        modifier = iModifier.then(Modifier.clickable(onClick = {
            SDDestinationStore.desinationHandler?.handeDestination(image.destination)
        }))
    )
}

@Preview
@Composable
internal fun SDImagePreview() {
    SDImage(image = SDImageMock.mock)
}

internal object SDImageMock {

    val mock = SomeImage(
        id = "",
        url = "",
        style = null,
        destination = null,
        idRes = R.drawable.mine_image_sample
    )
}