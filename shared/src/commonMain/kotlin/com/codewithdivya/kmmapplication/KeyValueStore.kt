package com.codewithdivya.kmmapplication

expect class Controller

expect fun Controller.getBool(key: String): Boolean
expect fun Controller.setBool(key: String, value: Boolean)