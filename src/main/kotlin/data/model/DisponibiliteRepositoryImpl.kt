package data.model

import android.content.Context
import data.local.JsonFileStore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DisponibiliteRepositoryImpl(context: Context) : DisponibiliteRepository {
    private val store = JsonFileStore(context)
    private val fileNameOfficiel = "stock_officiel.json"
    private val fileNameWeb = "stock_web.json"

    override suspend fun getStockOfficiel(articleId: String): List<Stockage> = withContext(Dispatchers.IO) {
        // TODO : connecter à la vraie source du stock officiel interne
        // (système Decathlon) — connexion pas encore définie.
        val all = store.read<List<Stockage>>(fileNameOfficiel) ?: emptyList()
        all.filter { it.articleId == articleId }
    }

    override suspend fun getStockWeb(articleId: String): List<Stockage> = withContext(Dispatchers.IO) {
        // TODO : scraping du panneau "vérifier la disponibilité" — bloqué pour
        // la même raison que createArticle() (besoin d'un échantillon HTML réel).
        val all = store.read<List<Stockage>>(fileNameWeb) ?: emptyList()
        all.filter { it.articleId == articleId }
    }
}
