package data.scraper

import data.model.Category
import com.decathlon.data.scraper.CategoryException
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import kotlin.jvm.Throws

class WebFactory{
    // Static use
    companion object {
        private const val CssSelectorCategory = ".visual-grid__wrapper"

        @Throws(CategoryException::class)
        fun createCategories(doc: Document): List<Category>?{
            val panel = doc.select(CssSelectorCategory).first()
                ?: throw CategoryException("Couldn't select, check css selector")
            println("panel selected :\n $panel")
            val categList = panel.select("ul").first()?.select("li")
            return categList?.mapNotNull { categ -> parseToCategory(categ) }
        }

        // TODO : implémenter le DeepSearch de chaque article dans une catégorie.
        fun createArticle(category: Category?){
            //DeepSearch each item in a category to create an article,
            // link this article to the category
        }

        fun parseToCategory(li: Element): Category {
            val title = li.select("span").text()
            // Le lien de navigation vers la catégorie est le href du <a>,
            // pas le srcset de l'image (qui pointait vers une image, pas une page).
            val link = li.select("a").attr("href")
            return Category(type = title, link = link)
        }
    }

}