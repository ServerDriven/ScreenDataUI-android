package com.pv.screendataui

import androidx.compose.ui.graphics.Color
import com.pv.screendata.objects.SomeColor

fun SomeColor.toComposeColor(): Color = Color(red, green, blue)