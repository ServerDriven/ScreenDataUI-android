package com.pv.screendataandroid

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.Text
import com.pv.screendata.extensions.toSomeLabel
import com.pv.screendata.extensions.toSomeView
import com.pv.screendata.objects.SomeColor
import com.pv.screendata.screens.SomeScreen
import com.pv.screendataui.SDScreen

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
//            Text(text = "Hi")
            SDScreen(
                screen = SomeScreen(
                    title = "This is a title",
                    backgroundColor = SomeColor(1f, 0f, 0f, 1f),
                    someView = "here's a label !".toSomeLabel().toSomeView()
                )
            )
        }
    }
}
