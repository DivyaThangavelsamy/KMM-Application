package com.codewithdivya.kmmapplication

import android.graphics.Bitmap
import android.graphics.BitmapFactory

// 1
actual typealias Image = Bitmap

// 2
actual fun ByteArray.toNativeImage(): Image? =
    BitmapFactory.decodeByteArray(this, 0, this.size)