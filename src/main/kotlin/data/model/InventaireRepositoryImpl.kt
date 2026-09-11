package data.model

import android.content.Context
import data.local.JsonFileStore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class InventaireRepositoryImpl(context: Context) : InventaireRepository {
    private val store = JsonFileStore(context)
    private val fileName = "inventaire.json"

    override suspend fun getAll(): List<Article> = withContext(Dispatchers.IO) {
        store.read<List<Article>>(fileName) ?: emptyList()
    }

    override suspend fun addManualEntry(article: Article) = withContext(Dispatchers.IO) {
        val current = store.read<List<Article>>(fileName) ?: emptyList()
        store.write(fileName, current + article.copy(isManualEntry = true))
    }

    override suspend fun removeEntry(articleId: String) = withContext(Dispatchers.IO) {
        val current = store.read<List<Article>>(fileName) ?: emptyList()
        store.write(fileName, current.filterNot { it.id == articleId })
    }
}
