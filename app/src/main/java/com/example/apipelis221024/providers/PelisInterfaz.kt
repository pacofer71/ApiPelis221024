package com.example.apipelis221024.providers

import com.example.apipelis221024.models.ListaPeliculas
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PelisInterfaz {
    @GET("3/movie/popular")
    suspend fun taerPeliculas(@Query("api_key") key: String) : Response<ListaPeliculas>

}