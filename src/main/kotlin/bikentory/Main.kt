package bikentory

import data.scraper.WebFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.jsoup.Jsoup
import kotlin.collections.forEachIndexed

var url = "https://www.decathlon.ca/fr/sports/velo-cyclisme/velos?Ns=priceAscending"

suspend fun main() = withContext(Dispatchers.Default){
    try{
        // Coroutines for url fetcher
        // https://kotlinlang.org/docs/coroutines-basics.html#coroutinescope-async

        // Recursive investigation to do, all link collection
        println("Fetching url")
        val doc = Jsoup.connect(url)
            .userAgent("Mozilla")
            .timeout(5000)
            .get()

        println("Fetching passed")

//        val categories = WebFactory.createCategories(doc)
//        categories?.forEachIndexed { index, categ ->
//            println("Category $index : ${categ.type}")
//        }

    }
    catch (exc: Exception){
        println("Exception : ${exc.message}")
    }
}


