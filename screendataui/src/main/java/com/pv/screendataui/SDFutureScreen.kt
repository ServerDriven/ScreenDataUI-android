package com.pv.screendataui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import com.pv.screendata.screens.SomeScreen
import com.pv.sddestination.SDScreenFetcher
import com.pv.sddestination.SDScreenFetcherStore
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.onStart

@Composable
fun SDFutureScreen(id: String) {

    val screen = SDScreenFetcherStore.screenFetcher
        .fetchScreen(id)
        .collectAsState(initial = SDScreenFetcherStore.loadingScreen)

    SDSCreen(screen = screen.value)
}
