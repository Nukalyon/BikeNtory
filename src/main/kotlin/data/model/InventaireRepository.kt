package data.model

/**
 * Gère l'inventaire saisi manuellement en boutique — notamment les vélos
 * physiquement présents mais pas encore reconnus par le système officiel.
 */
interface InventaireRepository {
    suspend fun getAll(): List<Article>
    suspend fun addManualEntry(article: Article)
    suspend fun removeEntry(articleId: String)
    // TODO (futur) : suspend fun addByBarcode(barcode: String): Article?
}