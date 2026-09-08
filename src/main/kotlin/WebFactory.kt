package com.decathlon

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

        fun createArticle(category: Category?){
            //DeepSearch each item in a category to create an article,
            // link this article to the category
        }

        fun parseToCategory(li: Element): Category {
            //println("Parse to category this element : \n $li")
            /*
            Parse to category this element :
                 <li class="visual-grid__item visual-grid__item--undefined" aria-hidden="false">
                 <div class="category-card category-card--grid">
                  <div class="category-card__image">
                   <div class="media media--variant-default">
                    <div class="aspect-ratio aspect-ratio--1-1">
                     <div class="aspect-ratio__content">
                      <img alt="" fetchpriority="auto" loading="lazy" width="100" height="100" decoding="async" data-nimg="1" style="color:transparent" sizes="(min-width: 1200px) 11vw, (min-width: 600px) 21vw, 104px" srcset="https://contents.mediadecathlon.com/s1104432/k$2f85dd2a9522ba4b3fb4fc12ea12ef2c/367e916b-4bb8-4b62-b325-4e68fe7a2abd.jpg?format=auto&amp;f=320x0 320w, https://contents.mediadecathlon.com/s1104432/k$2f85dd2a9522ba4b3fb4fc12ea12ef2c/367e916b-4bb8-4b62-b325-4e68fe7a2abd.jpg?format=auto&amp;f=640x0 640w, https://contents.mediadecathlon.com/s1104432/k$2f85dd2a9522ba4b3fb4fc12ea12ef2c/367e916b-4bb8-4b62-b325-4e68fe7a2abd.jpg?format=auto&amp;f=969x0 969w, https://contents.mediadecathlon.com/s1104432/k$2f85dd2a9522ba4b3fb4fc12ea12ef2c/367e916b-4bb8-4b62-b325-4e68fe7a2abd.jpg?format=auto&amp;f=1920x0 1920w, https://contents.mediadecathlon.com/s1104432/k$2f85dd2a9522ba4b3fb4fc12ea12ef2c/367e916b-4bb8-4b62-b325-4e68fe7a2abd.jpg?format=auto&amp;f=3000x0 3000w" src="https://contents.mediadecathlon.com/s1104432/k$2f85dd2a9522ba4b3fb4fc12ea12ef2c/367e916b-4bb8-4b62-b325-4e68fe7a2abd.jpg?format=auto&amp;f=3000x0">
                     </div>
                    </div>
                   </div>
                  </div>
                  <div class="category-card__name category-card__name--grid">
                   <span class="vp-body-s"><a tabindex="0" href="/fr/sports/velo-cyclisme/velos-hybrides-randonnee">V�los hybrides et de randonn�e</a></span>
                  </div>
                 </div></li>
             */
            val title = li.select("span").text()
            val link = li.select("img").attr("srcset")
            return Category(type = title, link = link)
        }
    }

}