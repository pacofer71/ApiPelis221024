package com.example.apipelis221024

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.apipelis221024.adapters.PeliculasAdapter
import com.example.apipelis221024.databinding.ActivityMainBinding
import com.example.apipelis221024.models.Pelicula
import com.example.apipelis221024.providers.ApiClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var lista= mutableListOf<Pelicula>()
    val adapter=PeliculasAdapter(lista){
        peli->irDetalle(peli)
    }
    var api=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        api=getString(R.string.api_pelis)
        setRecycler()
    }

    private fun traerDatos() {
        lifecycleScope.launch(Dispatchers.IO) {
            val datos = ApiClient.apiClient.taerPeliculas(api)
            val listaP= datos.body()?.listaPeliculas?: emptyList<Pelicula>().toMutableList()
            withContext(Dispatchers.Main){
                if(datos.isSuccessful){
                    adapter.lista=listaP
                    adapter.notifyDataSetChanged()
                }else{
                    Toast.makeText(this@MainActivity, "Sin Peliculas", Toast.LENGTH_SHORT).show()
                }
            }

        }
    }

    private fun setRecycler() {
        val layoutManager=GridLayoutManager(this, 2)
        binding.recView.layoutManager=layoutManager

        binding.recView.adapter=adapter
        traerDatos()
    }

    private fun irDetalle(peli: Pelicula){
        val i= Intent(this, DetalleActivity::class.java).apply {
            putExtra("PELICULA", peli)
        }
        startActivity(i)
    }


}