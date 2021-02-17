package com.pv.screendataui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.pv.sddestination.SDScreenFetcherStore

@Composable
fun SDFutureScreen(id: String) {

    val screen = SDScreenFetcherStore.screenFetcher
        .fetchScreen(id)
        .collectAsState(initial = SDScreenFetcherStore.loadingScreen)

    SDScreen(screen = screen.value)
}
