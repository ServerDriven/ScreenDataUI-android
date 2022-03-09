package com.pv.screendataui.store

typealias SDAction = () -> Unit

object SDActionStore {
    val actions = mutableMapOf<String, SDAction>()
}
