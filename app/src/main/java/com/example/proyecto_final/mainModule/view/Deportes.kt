package com.example.proyecto_final.mainModule.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proyecto_final.DeporteProvider
import com.example.proyecto_final.databinding.ActivityListadeportesBinding
import com.example.proyecto_final.mainModule.adapter.DeporteAdapter
import com.example.proyecto_final.mainModule.adapter.DeporteViewHolden

class Deportes : AppCompatActivity(){

    private lateinit var binding: ActivityListadeportesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListadeportesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        crear_list()
    }

    fun crear_list() {

        val manager = LinearLayoutManager(this)
        val decoration = DividerItemDecoration(this, manager.orientation)

        binding.listaDeportes.layoutManager = manager
        binding.listaDeportes.adapter = DeporteAdapter(DeporteProvider.deporteList)
        binding.listaDeportes.addItemDecoration(decoration)
    }
}