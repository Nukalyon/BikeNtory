package com.decathlon

data class Article (
    val link : String,
    //marque de l'article
    val brand : String,
    //catégorie de l'article
    val parent : String,
    //nom du modèle
    val name : String,
    //id pour reference
    val id : String,
    //source image (Download ?)

    //stock restant ? list de mag ? class stock (easier)?

    // Stockage en ligne ? ou physique ?
){
}