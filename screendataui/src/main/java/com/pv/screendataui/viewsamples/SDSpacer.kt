package com.pv.screendataui.viewsamples

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.pv.screendata.views.SomeSpacer

@Composable
fun SDSpacer(someSpacer: SomeSpacer) {
    Box(
        modifier = Modifier.fillMaxWidth().then(Modifier.height(someSpacer.size.dp)),
    )
}

@Preview
@Composable
fun sdSpacerPreview() {
    SDSpacer(someSpacer = SDSpacer.mock)
}

object SDSpacer {
    val mock = SomeSpacer(
        size = 4
    )
}
