package com.pv.screendataandroid

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.pv.screendataui.SDFutureScreen
import com.pv.screendataui.SDScreenDemo
import com.pv.sddestination.SDScreenFetcher
import com.pv.sddestination.SDScreenFetcherStore
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.onStart

@Composable
@Preview
fun previewSDFutureScreen() {
    SDFutureScreen(id = "")
}

object sdFutureScreenMock {

    fun setupStore() {
        with(SDScreenFetcherStore) {
            screenFetcher = object : SDScreenFetcher {
                override fun fetchScreen(id: String) =
                    flowOf(SDScreenDemo.error)
                        .onStart { delay(1000) }
            }
            loadingScreen = SDScreenDemo.loading
        }

    }
}
