package com.codewithdivya.kmmapplication

import kotlinx.serialization.Serializable

@Serializable
data class GrainList(
    val entries: List<Grain>
)