package data.model

import kotlinx.serialization.Serializable

@Serializable
data class Magasin(
    val nom: String,
    // Distance approximative depuis le magasin courant (en km), si connue
    val distanceKm: Float? = null
)