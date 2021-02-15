package com.pv.screendataui.store

import androidx.compose.runtime.Composable
import com.pv.screendata.screens.SomeScreen

object SomeToolbarStore {
    var toolbarCheck: ((SomeScreen) -> Boolean)? = null
    var toolbarComposable: (@Composable () -> Unit)? = null
}
