package com.pv.screendataandroid

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.clickable
import androidx.compose.material.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import com.pv.screendata.objects.Destination
import com.pv.screendataui.*
import com.pv.screendataui.store.SomeStoreHolder
import com.pv.screendataui.store.SomeToolbarStore
import com.pv.sddestination.SDDestinationHandler
import com.pv.sddestination.SDDestinationStore

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        SomeStoreHolder.store = SDStoreDemo.mockStore
        SDDestinationStore.desinationHandler = object : SDDestinationHandler {

            override fun handeDestination(destination: Destination?) {
                Log.d("pv", "desti")
            }
        }
        SomeToolbarStore.toolbarComposable = {
            val title = remember { mutableStateOf("state") }
            Text(
                text = title.value,
                color = Color.Magenta,
                modifier = Modifier.clickable(onClick = {
                    title.value = "Clicked"
                })
            )
        }
        sdFutureScreenMock.setupStore()

        setContent {
            SDSCreen(screen = Mock.temp)
        }
    }
}
