package data.model

import kotlinx.serialization.Serializable

@Serializable
data class Category(
    val type : String,
    val link : String
)