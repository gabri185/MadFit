package com.example.proyecto_final.mainModule.adapter

import android.content.Intent
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto_final.data.model.Deporte
import com.example.proyecto_final.data.model.Partido
import com.example.proyecto_final.databinding.ItemListBinding
import com.example.proyecto_final.databinding.ItemPartidosBinding
import com.example.proyecto_final.mainModule.view.Partidos

class PartidoViewHolden (view: View): RecyclerView.ViewHolder(view){
    val binding = ItemPartidosBinding.bind(view)

    fun render(partidolist: Partido){
        binding.tipo.text = partidolist.deporte + " " + partidolist.jugadores
        binding.lugar.text = partidolist.centro
        binding.hora.text = partidolist.hora
        binding.partidos.text = partidolist.fecha

        itemView.setOnClickListener {
            llamarPartidos()
        }
    }

    fun llamarPartidos() {
        val intent = Intent(binding.tipo.context, Partidos::class.java)
        binding.tipo.context.startActivity(intent)
    }
}