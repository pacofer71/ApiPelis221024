package com.example.apipelis221024.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.apipelis221024.R
import com.example.apipelis221024.models.Pelicula

class PeliculasAdapter(
    public var lista: MutableList<Pelicula>,
    private val onDetalleClik: (Pelicula)->Unit,
    ): RecyclerView.Adapter<PeliculaViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeliculaViewHolder {
        val v=LayoutInflater.from(parent.context).inflate(R.layout.pelis_layout, parent, false)
        return PeliculaViewHolder(v)
    }

    override fun getItemCount()=lista.size

    override fun onBindViewHolder(holder: PeliculaViewHolder, position: Int) {
        val pelicula=lista[position]
        holder.render(pelicula, onDetalleClik)
    }
}