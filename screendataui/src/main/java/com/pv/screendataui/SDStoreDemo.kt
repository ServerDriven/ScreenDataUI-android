package com.pv.screendataui

import androidx.compose.material.Text
import androidx.compose.ui.graphics.Color
import com.pv.screendataui.store.SomeStore

object SDStoreDemo {

    val mockStore = SomeStore(
        customViews = mapOf("pogthisisacustomview" to {
            Text(
                text = "pog o ${it.title}",
                color = Color.Cyan
            )
        })
    )
}
