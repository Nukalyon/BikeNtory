package data.local

import android.content.Context
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.File

/**
 * Lit/écrit des données sérialisables dans un fichier JSON du stockage
 * interne de l'app (privé, pas besoin de permission).
 *
 * Conçu comme une brique isolée : le jour où on migre vers Room/une DB,
 * seule cette classe est remplacée — les Repository n'ont pas à changer
 * de signature.
 */
class JsonFileStore(private val context: Context) {
    private val json = Json {
        prettyPrint = true
        ignoreUnknownKeys = true
    }

    inline fun <reified T> read(fileName: String): T? {
        val file = File(context.filesDir, fileName)
        if (!file.exists()) return null
        return try {
            json.decodeFromString(file.readText())
        } catch (e: Exception) {
            null
        }
    }

    inline fun <reified T> write(fileName: String, data: T) {
        val file = File(context.filesDir, fileName)
        file.writeText(json.encodeToString(data))
    }
}