package com.example.apipelis221024.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.apipelis221024.databinding.PelisLayoutBinding
import com.example.apipelis221024.models.Pelicula
import com.squareup.picasso.Picasso

class PeliculaViewHolder(v: View): RecyclerView.ViewHolder(v) {
    val binding=PelisLayoutBinding.bind(v)
    fun render(peli: Pelicula, onDetalleClik: (Pelicula) -> Unit){
        binding.tvTitulo.text=peli.titulo
        Picasso.get().load("https://image.tmdb.org/t/p/original${peli.caratula}").into(binding.ivCaratula)
        itemView.setOnClickListener {
            onDetalleClik(peli)
        }
    }

}
