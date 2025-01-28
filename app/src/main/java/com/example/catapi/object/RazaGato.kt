package com.example.catapi.`object`

data class RazaGato(
    val id:String,
    val name:String,
    val temperament:String,
    val origin:String,
    val weight: Weight,
)

data class Weight(
    val imperial:String,
    val metric:String
)