package data.model

import data.local.JsonFileStore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CatalogueRepositoryImpl(context: Context) : CatalogueRepository {
    private val store = JsonFileStore(context)
    private val fileName = "catalogue.json"

    override suspend fun fetchCatalogueFromWeb(): List<Article> = withContext(Dispatchers.IO) {
        // TODO : WebFactory.createArticle() n'est pas encore implémenté
        // (étape 4 — en attente d'un échantillon HTML de page produit réel).
        // Pour l'instant on ne peut scraper que les catégories, pas les articles.
        emptyList()
    }

    override suspend fun getCachedCatalogue(): List<Article> = withContext(Dispatchers.IO) {
        store.read<List<Article>>(fileName) ?: emptyList()
    }

    override suspend fun setTracked(articleId: String, tracked: Boolean) = withContext(Dispatchers.IO) {
        val current = store.read<List<Article>>(fileName) ?: emptyList()
        val updated = current.map { if (it.id == articleId) it.copy(isTracked = tracked) else it }
        store.write(fileName, updated)
    }
}
