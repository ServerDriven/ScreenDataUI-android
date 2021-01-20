package com.pv.screendataui

import androidx.compose.runtime.Composable
import com.pv.screendata.views.SomeCustomView

data class SomeStore(
    val customViews: Map<String, AnySDComposable>
)

object SomeStoreHolder {
    var store: SomeStore? = null
}

typealias AnySDComposable = @Composable (SomeCustomView) -> Unit
