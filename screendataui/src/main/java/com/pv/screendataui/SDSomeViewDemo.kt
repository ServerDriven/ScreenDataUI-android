package com.pv.screendataui

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.pv.screendata.objects.SomeView
import com.pv.screendata.types.ViewDirectionAxis
import com.pv.screendata.types.ViewType
import com.pv.screendataui.viewsamples.*

// Todo : find safe fallback on those labels
@Composable
fun SDSomeView(someView: SomeView) = when (someView.type) {
    ViewType.label -> {
        SDLabel(label = someView.someLabel!!)
    }
    ViewType.image -> {
        SDImage(image = someView.someImage!!)
    }
    ViewType.labeledImage -> {
        SDLabeledImage(labeledImage = someView.someLabeledImage!!)
    }
    ViewType.container -> {
        SDContainerView(containerView = someView.someContainer!!)
    }
    ViewType.custom -> {
        SomeStoreHolder.store?.customViews
            ?.get(someView.someCustomView?.id)
            ?.invoke(someView.someCustomView!!)
    }
    ViewType.text -> {
        Text(text = someView.someText!!.title)
    }
    ViewType.button -> {
        SDButton(someButton = someView.someButton!!)
    }
    ViewType.spacer -> {
        SDSpacer(someSpacer = someView.someSpacer!!)
    }
}

@Preview(showBackground = true)
@Composable
fun sdSomeViewPreview() {
    SDSomeView(someView = SDSomeViewDemo.mock)
}

object SDSomeViewDemo {

    val mock = SomeView(
        type = ViewType.container,
        someContainer = SDContainerViewDemo.containerMock(ViewDirectionAxis.vertical),
        someText = null,
        someButton = null,
        someImage = null,
        someLabel = null,
        someLabeledImage = null,
        someCustomView = null
    )
}
