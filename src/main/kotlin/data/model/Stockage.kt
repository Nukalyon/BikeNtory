package data.model

import kotlinx.serialization.Serializable

/**
 * Représente le stock d'un [Article] donné dans un [Magasin] donné.
 *
 * Note importante : le stock affiché sur Decathlon.ca applique une marge
 * de sécurité de -1 par rapport au stock physique réel. Cette classe
 * distingue donc la source de la donnée (officielle/interne vs. web).
 */
@Serializable
data class Stockage(
    val articleId: String,
    val magasin: Magasin,
    val quantite: Int = 0,
    // true si la quantité vient du système interne (fiable),
    // false si elle vient du scraping du site (biaisée de -1)
    val sourceOfficielle: Boolean = false,
    val enPromotion: Boolean = false,
    // Dernière unité disponible, information non-sensible au temps
    val derniereQuantite: Boolean = false
)