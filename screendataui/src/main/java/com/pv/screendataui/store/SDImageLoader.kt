package com.pv.screendataui.store

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.ImageBitmap
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

interface SDImageLoader {

    fun loadImage(path: String): MutableState<ImageBitmap>
}

object SomeImageLoaderStore {

    lateinit var imageLoader: SDImageLoader
}
