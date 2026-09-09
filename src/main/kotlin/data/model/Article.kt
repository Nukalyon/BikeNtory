package data.model

import kotlinx.serialization.Serializable

/**
 * Représente un modèle de vélo, tel que trouvé sur le catalogue Decathlon.ca
 * ou saisi manuellement dans l'inventaire.
 */
@Serializable
data class Article(
    val id: String,
    val name: String,
    val brand: String,
    // Catégorie parente (ex: "Vélos hybrides et de randonnée")
    val parent: String,
    // Lien vers la page du produit sur Decathlon.ca
    val link: String,
    // Image du produit (séparée du lien produit)
    val imageUrl: String? = null,
    // Code-barre physique du vélo (sous le cadre).
    // Non utilisé pour l'instant : prévu pour le futur scan.
    val barcode: String? = null,
    // Vrai si ce modèle est "suivi" activement par le conseiller
    // (panneau de suivi du catalogue)
    val isTracked: Boolean = false,
    // Vrai si l'article a été ajouté manuellement en boutique
    // sans être encore reconnu par le système officiel Decathlon
    val isManualEntry: Boolean = false
)