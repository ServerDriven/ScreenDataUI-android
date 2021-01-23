package com.pv.screendataui.viewsamples

import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.ScrollableRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.pv.screendataui.SDSomeView
import com.pv.screendata.extensions.SomeStyleHelper.paddingStyle
import com.pv.screendata.extensions.toSomeView
import com.pv.screendata.types.ViewDirectionAxis
import com.pv.screendata.views.SomeContainerView

@Composable
fun SDContainerView(containerView: SomeContainerView) {
    val content = @Composable {
        containerView.someViews.forEach {
            SDSomeView(someView = it)
        }
    }

    val cvModifier = Modifier.fillMaxWidth().then(
        Modifier.padding(
            start = containerView.someStyle?.paddingStart?.dp ?: 0.dp,
            end = containerView.someStyle?.paddingEnd?.dp ?: 0.dp
        )
    )

    when (containerView.axis) {
        ViewDirectionAxis.horizontal -> ScrollableRow(
            modifier = cvModifier,
        ) {
            content()
        }
        ViewDirectionAxis.vertical -> ScrollableColumn(
            modifier = cvModifier,
        ) {
            content()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun sdContainerViewPreview() {
    SDContainerView(
        containerView = SDContainerViewDemo.containerMock(ViewDirectionAxis.vertical)
    )
}

object SDContainerViewDemo {

    val containerMock = { axis: ViewDirectionAxis ->
        SomeContainerView(
            id = "someContainerId",
            axis = axis,
            someViews = listOf(
                SDLabel.mock.toSomeView(),
                SDLabel.mock.toSomeView(),
                SDLabel.mock.toSomeView()
            ),
            someStyle = paddingStyle(start = 4, end = 4)
        )
    }
}
