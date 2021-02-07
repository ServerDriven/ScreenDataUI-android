package com.pv.screendataui.views

import androidx.compose.material.Text
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.pv.screendata.objects.SomeColor
import com.pv.screendata.objects.SomeStyle
import com.pv.screendata.types.Alignment
import com.pv.screendata.views.SomeButton
import com.pv.screendataui.toSafeComposeColor
import com.pv.sddestination.SDDestinationStore

@Composable
fun SDButton(someButton: SomeButton) {

    val cbModifier = Modifier.fillMaxWidth().then(
        Modifier.padding(
            start = someButton.style?.padding?.dp ?: 0.dp,
            end = someButton.style?.padding?.dp ?: 0.dp
        )
    )

    TextButton(
        onClick = {
            SDDestinationStore.desinationHandler?.handeDestination(someButton.destination)
        },
        cbModifier,
        shape = RoundedCornerShape(someButton.style?.cornerRadius?.dp ?: 2.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = someButton.style?.backgroundColor?.toSafeComposeColor()
                ?: Color.Unspecified
        )
    ) {
        Text(
            text = someButton.title,
            textAlign = TextAlign.Center,
            color = someButton.style?.foregroundColor?.toSafeComposeColor() ?: Color.Magenta
        )
    }


}

@Preview
@Composable
internal fun SDButtonPreview() {
    SDButton(someButton = SDButtonMock.mock)
}

internal object SDButtonMock {

    val mock = SomeButton(
        id = null,
        actionID = null,
        title = "clieck meh mmooo",
        destination = null,
        style = SomeStyle(
            backgroundColor = SomeColor(
                0.314f,
                0.314f,
                0.314f,
                1f
            ),
            foregroundColor = SomeColor(
                81f / 255f,
                45f / 255f,
                168f / 255f,
                1f
            ),
            isHidden = false,
            cornerRadius = 4,
            alignment = Alignment.center
        )
    )
}

