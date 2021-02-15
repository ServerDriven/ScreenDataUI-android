package com.pv.screendataui.views

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.pv.screendata.objects.SomeView
import com.pv.screendata.types.ViewDirectionAxis
import com.pv.screendata.types.ViewType
import com.pv.screendataui.store.SomeStoreHolder

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
        SDText(someText = someView.someText!!)
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
internal fun SDSomeViewPreview() {
    SDSomeView(someView = SDSomeViewDemo.mock)
}

internal object SDSomeViewDemo {

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
