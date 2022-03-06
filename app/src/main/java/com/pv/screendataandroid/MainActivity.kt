package com.pv.screendataandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.Text
import androidx.compose.ui.platform.ComposeView
import com.pv.screendata.extensions.toSomeLabel
import com.pv.screendata.extensions.toSomeView
import com.pv.screendata.objects.SomeColor
import com.pv.screendata.screens.SomeScreen
import com.pv.screendataui.SDScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<ComposeView>(R.id.main_compose).setContent {
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
