package com.example.apipelis221024

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.apipelis221024.databinding.ActivityDetalleBinding
import com.example.apipelis221024.models.Pelicula
import com.squareup.picasso.Picasso

class DetalleActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetalleBinding
    private lateinit var peli: Pelicula

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityDetalleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        recuperarPeli()
        setListeners()
    }

    private fun setListeners() {
        binding.btnVolver.setOnClickListener {
            finish()
        }
    }

    private fun recuperarPeli() {
        val datos=intent.extras
        peli=datos?.getSerializable("PELICULA") as Pelicula
        binding.tvSinopsis.text=peli.sinopsis
        Picasso.get().load("https://image.tmdb.org/t/p/original${peli.poster}").into(binding.ivDetalle)
        Log.d("PELI", "https://image.tmdb.org/t/p/original${peli.poster}")
        binding.tvTitutloDetalle.text=peli.titulo
        binding.tvPuntuacion.text=peli.puntuacion.toString()

    }
}