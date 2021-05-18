package com.pv.screendataui.store

import androidx.annotation.FontRes
import androidx.compose.ui.unit.TextUnit
import com.pv.screendata.types.FontType
import androidx.compose.ui.unit.sp

data class SomeCustomFont(
    @FontRes val font: Int = -1,
    val size: TextUnit,
    val bold: Boolean = false
)

object SomeFontStoreHolder {
    val someCustomFontMap = mutableMapOf(
        FontType.largeTitle to SomeCustomFont(size = 24.sp),
        FontType.title to SomeCustomFont(size = 20.sp),
        FontType.headline to SomeCustomFont(size = 16.sp, bold = true),
        FontType.body to SomeCustomFont(size = 14.sp),
        FontType.footnote to SomeCustomFont(size = 12.sp),
        FontType.caption to SomeCustomFont(size = 12.sp, bold = true)
    )
}
