package com.pv.screendataui.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.pv.screendata.types.ImageAspectScale
import com.pv.screendata.views.SomeImage
import com.pv.screendataui.R
import com.pv.screendataui.store.SomeAssetStoreHolder
import com.pv.screendataui.store.SomeImageLoaderStore
import com.pv.sddestination.SDDestinationStore

@Composable
fun SDImage(image: SomeImage) {

    if (image.style?.isHidden == true) return

    val iModifier = Modifier
        .fillMaxWidth()
        .height(image.style?.height?.dp ?: 300.dp)
        .then(
            Modifier.padding(
                start = image.style?.padding?.dp ?: 0.dp,
                end = image.style?.padding?.dp ?: 0.dp
            )
        )
        .then(Modifier.clickable(onClick = {
            SDDestinationStore.desinationHandler?.handeDestination(image.destination)
        }))

    val contentScale = when (image.aspectScale) {
        ImageAspectScale.fit -> ContentScale.Fit
        ImageAspectScale.fill -> ContentScale.FillHeight
    }

    if (image.assetName != null) {
        val imageSource = SomeAssetStoreHolder.store?.customAsset?.get(image.assetName)!!
        Image(
            imageVector = ImageVector.vectorResource(id = imageSource),
            contentDescription = ""
        )
    } else {
        val imageSource = SomeImageLoaderStore
            .imageLoader
            .loadImage(image.url)

        Image(
            imageSource.value,
            "",
            modifier = iModifier,
            contentScale = contentScale
        )
    }
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
        idRes = R.drawable.mine_image_sample,
        aspectScale = ImageAspectScale.fill
    )
}
