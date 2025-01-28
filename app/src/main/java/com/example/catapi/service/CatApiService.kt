package com.example.catapi.service

import com.example.catapi.`object`.RazaGato
import retrofit2.http.GET

interface CatApiService {
    @GET("breeds")
    suspend fun getListadoRazas():List<RazaGato>
}