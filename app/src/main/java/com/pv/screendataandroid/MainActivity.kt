package com.pv.screendataandroid

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.Text
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.tooling.preview.Preview
import com.pv.screendataandroid.ui.ScreenDataAndroidTheme
import com.pv.screendataui.SDScreenDemo
import com.pv.screendataui.SDStoreDemo
import com.pv.screendataui.SomeStoreHolder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        SomeStoreHolder.store = SDStoreDemo.mockStore
        setContent {
            SDScreenDemo.mock()
        }
    }
}
