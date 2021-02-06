package com.pv.screendataui.viewsamples

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.pv.screendata.types.ViewDirectionAxis
import com.pv.screendata.views.SomeSpacer
import com.pv.screendataui.SDScreenDemo.hexToSomeColor

@Composable
fun SDSpacer(someSpacer: SomeSpacer) {
    Box(
        modifier = Modifier.size(someSpacer.size.dp, someSpacer.size.dp)
    )
}

@Preview
@Composable
fun sdSpacerPreview() {
    SDSpacer(someSpacer = SDSpacer.mock)
}

object SDSpacer {
    val mock = SomeSpacer(
        size = 24,
        axis = ViewDirectionAxis.vertical
    )
}
