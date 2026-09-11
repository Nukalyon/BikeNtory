package data.model

/**
 * Consulte la disponibilité d'un article dans les autres magasins.
 *
 * Deux sources possibles :
 * - le stock officiel interne (fiable, exact)
 * - le panneau "vérifier la disponibilité" du site Decathlon.ca (scrapable,
 *   mais avec une marge de sécurité de -1 par rapport au stock physique réel)
 */
interface DisponibiliteRepository {
    suspend fun getStockOfficiel(articleId: String): List<Stockage>
    suspend fun getStockWeb(articleId: String): List<Stockage>
}
