package com.pv.screendataui.views

import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.ScrollableRow
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.pv.screendata.extensions.SomeStyleHelper.paddingStyle
import com.pv.screendata.extensions.toSomeView
import com.pv.screendata.types.ViewDirectionAxis
import com.pv.screendata.views.SomeContainerView

@Composable
fun SDContainerView(containerView: SomeContainerView) {
    val content = @Composable {
        containerView.views.forEach {
            SDSomeView(someView = it)
        }
    }

    val padding = containerView.style?.padding?.dp ?: 0.dp

    val cvModifier = Modifier.fillMaxWidth().then(
        Modifier.padding(
            start = padding,
            end = padding
        )
    )

    val scrollable = containerView.isScrollable

    when (containerView.axis) {
        ViewDirectionAxis.horizontal ->
            if (scrollable) ScrollableRow(
                modifier = cvModifier,
            ) {
                content()
            } else {
                Row(modifier = cvModifier) {
                    content()
                }
            }
        ViewDirectionAxis.vertical -> if (scrollable)
            ScrollableColumn(
                modifier = cvModifier,
            ) {
                content()
            } else {
            Column(modifier = cvModifier) {
                content()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
internal fun SDContainerViewPreview() {
    SDContainerView(
        containerView = SDContainerViewDemo.containerMock(ViewDirectionAxis.vertical)
    )
}

internal object SDContainerViewDemo {

    val containerMock = { axis: ViewDirectionAxis ->
        SomeContainerView(
            id = "someContainerId",
            axis = axis,
            views = listOf(
                SDLabelMock.mock.toSomeView(),
                SDLabelMock.mock.toSomeView(),
                SDLabelMock.mock.toSomeView()
            ),
            style = paddingStyle(4)
        )
    }
}
