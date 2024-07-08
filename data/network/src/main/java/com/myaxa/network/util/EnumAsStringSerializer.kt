package com.myaxa.network.util

import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

/**
 * Need to create custom enum-string serializers
 * Inspired by [this question](https://stackoverflow.com/questions/72433719/serialize-enum-as-an-integer)
 */
abstract class EnumAsStringSerializer<T : Enum<*>>(
    serialName: String,
    val serialize: (v: T) -> String,
    val deserialize: (v: String) -> T
) : KSerializer<T> {
    override val descriptor: SerialDescriptor =
        PrimitiveSerialDescriptor(serialName, PrimitiveKind.STRING)

    override fun serialize(encoder: Encoder, value: T) {
        encoder.encodeString(serialize(value))
    }

    override fun deserialize(decoder: Decoder): T {
        val v = decoder.decodeString()
        return deserialize(v)
    }
}