package com.pv.screendataui.store

import androidx.compose.runtime.Composable

object SomeToolbarStore {
    var toolbarCheck: (() -> Boolean)? = null
    var toolbarComposable: (@Composable () -> Unit)? = null
}
