package com.pv.screendataui

import androidx.compose.ui.graphics.Color
import com.pv.screendata.objects.SomeColor

fun SomeColor.toComposeColor(): Color = Color(red, green, blue)

fun SomeColor?.toSafeComposeColor(): Color = this?.let { toComposeColor() } ?: Color.Unspecified

private fun Float.toColor() = this / 255f
