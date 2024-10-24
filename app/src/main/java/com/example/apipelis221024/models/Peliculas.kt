package com.example.apipelis221024.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.util.ArrayList

data class Pelicula(
    @SerializedName("title") val titulo: String,
    @SerializedName("overview") val sinopsis: String,
    @SerializedName("poster_path") val poster: String,
    @SerializedName("backdrop_path") val caratula: String,
    @SerializedName("vote_average") val puntuacion: Float
): Serializable

data class ListaPeliculas(
    @SerializedName("results") val listaPeliculas: MutableList<Pelicula>
)
