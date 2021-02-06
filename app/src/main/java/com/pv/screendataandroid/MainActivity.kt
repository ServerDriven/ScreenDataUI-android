package com.pv.screendataandroid

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.Text
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.tooling.preview.Preview
import com.pv.screendata.objects.Destination
import com.pv.screendataandroid.ui.ScreenDataAndroidTheme
import com.pv.screendataui.*
import com.pv.sddestination.SDDestinationHandler
import com.pv.sddestination.SDDestinationStore
import com.pv.sddestination.SDScreenFetcherStore

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        SomeStoreHolder.store = SDStoreDemo.mockStore
        SDDestinationStore.desinationHandler = object : SDDestinationHandler {

            override fun handeDestination(destination: Destination?) {
                Log.d("pv", "desti")
            }
        }
        sdFutureScreenMock.setupStore()

        setContent {
            SDScreenDemo.mock()
        }
    }
}
