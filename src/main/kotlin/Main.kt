package com.decathlon

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.jsoup.Jsoup

var url = "https://www.decathlon.ca/fr/sports/velo-cyclisme/velos?Ns=priceAscending"

data class Category(
    val type : String,
    val link : String
)
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
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

        val categories = WebFactory.createCategories(doc)

        categories?.forEachIndexed { index, categ ->
            println("Category $index : ${categ.type}")
        }

    }
    catch (exc: Exception){
        println("Exception : ${exc.message}")
    }
}


