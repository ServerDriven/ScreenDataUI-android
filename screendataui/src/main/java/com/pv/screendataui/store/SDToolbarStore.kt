package com.pv.screendataui.store

import androidx.compose.runtime.Composable

object SomeToolbarStore {
    var toolbarComposable: (@Composable () -> Unit)? = null
}
