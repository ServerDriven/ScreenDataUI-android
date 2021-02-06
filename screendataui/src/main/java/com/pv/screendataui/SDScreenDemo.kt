package com.pv.screendataui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.pv.screendata.extensions.SomeStyleHelper.paddingStyle
import com.pv.screendata.extensions.toSomeLabel
import com.pv.screendata.extensions.toSomeView
import com.pv.screendata.objects.SomeColor
import com.pv.screendata.objects.SomeStyle
import com.pv.screendata.screens.SomeScreen
import com.pv.screendata.types.Alignment
import com.pv.screendata.types.FontType
import com.pv.screendata.types.ViewDirectionAxis
import com.pv.screendata.views.SomeContainerView
import com.pv.screendata.views.SomeCustomView
import com.pv.screendata.views.SomeLabel
import com.pv.screendata.views.SomeSpacer
import com.pv.screendataui.viewsamples.SDButton
import com.pv.screendataui.viewsamples.SDImage

// would this function only take an id paraeter?
@Composable
fun SDSCreen(screen: SomeScreen) {

    // write code for initial from navigator ?

    Scaffold(
        Modifier.fillMaxSize(),
        backgroundColor = screen.backgroundColor.toSafeComposeColor(),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        screen.title,
                        color = Color.White
                    )
                },
                backgroundColor = Color.Black
            )
        },
    ) {
        SDSomeView(someView = screen.someView)
    }
}

@Preview(showBackground = true)
@Composable
fun sdScreenPreview() {
    SDScreenDemo.mock()
}

object SDScreenDemo {
    @Composable
    fun mock() = SDSCreen(
        screen = mockScreen
    )

    val mockScreen = SomeScreen(
        id = "yoloId",
        title = "YoloTitile",
        backgroundColor = SomeColor(
            102f / 255f,
            187f / 255f,
            106f / 255f,
            .1f
        ),
        toolbarColor = SomeColor(
            102f / 255f,
            187f / 255f,
            106f / 255f,
            .1f
        ),
        headerView = null,
        someView = SomeContainerView(
            id = null,
            axis = ViewDirectionAxis.vertical,
            views = listOf(
                SDImage.mock.toSomeView(),
                SomeSpacer(size = 8, axis = ViewDirectionAxis.vertical).toSomeView(),
                "what".toSomeLabel()
                    .copy(style = paddingStyle(8))
                    .toSomeView(),
                "yea".toSomeLabel()
                    .copy(style = paddingStyle(8))
                    .toSomeView(),
                SomeSpacer(size = 8, axis = ViewDirectionAxis.vertical).toSomeView(),
                Pair("Something", "Worse")
                    .toSomeLabel()
                    .copy(style = paddingStyle(8))
                    .toSomeView(),
                SomeSpacer(size = 8, axis = ViewDirectionAxis.vertical).toSomeView(),
                "what".toSomeLabel()
                    .copy(style = paddingStyle(8))
                    .toSomeView(),
                SomeSpacer(size = 8, axis = ViewDirectionAxis.vertical).toSomeView(),
                Pair(
                    "Something important", """
                        Is this an important piece of informtation or just another bunch of fake news if you read this far then you are a fool lul
                    """.trimIndent()
                ).toSomeLabel()
                    .copy(style = paddingStyle(8))
                    .toSomeView(),
                SomeSpacer(size = 8, axis = ViewDirectionAxis.vertical).toSomeView(),
                SomeCustomView(
                    id = "pogthisisacustomview",
                    title = "Can i pass the title even"
                ).toSomeView(),
                SomeSpacer(size = 32, axis = ViewDirectionAxis.vertical).toSomeView(),
                SomeCustomView(
                    id = "pogthisisacustomview",
                    title = "psss"
                ).toSomeView(),
                SDButton.mock
                    .copy(
                        style = SomeStyle(
                            isHidden = false,
                            cornerRadius = 4,
                            padding = 8,
                            alignment = Alignment.center
                        )
                    )
                    .toSomeView()
            ),
            style = null
        ).toSomeView(),
        footerView = null
    )

    val error = SomeScreen(
        title = "Error",
        backgroundColor = "#d32f2f".hexToSomeColor(),
        someView = SomeContainerView(
            axis = ViewDirectionAxis.vertical,
            views = listOf(
                SomeLabel(
                    title = "Error loading screen",
                    subtitle = "Could not find lol",
                    font = FontType.body
                ).toSomeView()
            )
        ).toSomeView()
    )

    val loading = SomeScreen(
        id = "loading",
        title = "",
        backgroundColor = "#afb42b".hexToSomeColor(),
        someView = SomeContainerView(
            axis = ViewDirectionAxis.vertical,
            views = listOf(
                SomeLabel(
                    title = "Currently loading",
                    font = FontType.body
                ).toSomeView()
            )
        ).toSomeView()
    )

    fun String.hexToSomeColor(): SomeColor {
        val hex = this.replace("#", "")

        val red = "${hex[0]}${hex[1]}".toLong(radix = 16).toFloat() / 255
        val green = "${hex[2]}${hex[3]}".toLong(radix = 16).toFloat() / 255
        val blue = "${hex[4]}${hex[5]}".toLong(radix = 16).toFloat() / 255

        return SomeColor(
            red, green, blue, 1f
        )
    }
}

private fun Float.toColor() = this / 255f
