package com.pv.screendataui.store

data class SomeAssetStore(
    val customAsset: Map<String, Int>
)

object SomeAssetStoreHolder {
    var store: SomeAssetStore? = null
}
