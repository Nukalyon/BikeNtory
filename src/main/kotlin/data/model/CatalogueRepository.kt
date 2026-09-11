package data.model

/**
 * Gère le catalogue des vélos scrapés depuis Decathlon.ca,
 * et l'état "suivi / non suivi" choisi par le conseiller.
 *
 * L'implémentation (à venir, étape 6) lira/écrira dans un JSON local.
 * Le jour où on migre vers une vraie base de données, seule
 * l'implémentation change — pas le code qui consomme cette interface.
 */
interface CatalogueRepository {
    suspend fun fetchCatalogueFromWeb(): List<Article>
    suspend fun getCachedCatalogue(): List<Article>
    suspend fun setTracked(articleId: String, tracked: Boolean)
}
