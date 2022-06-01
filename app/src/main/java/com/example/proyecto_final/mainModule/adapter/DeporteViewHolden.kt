package com.example.proyecto_final.mainModule.adapter

import android.content.Intent
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto_final.data.model.Deporte
import com.example.proyecto_final.databinding.ItemListBinding
import com.example.proyecto_final.mainModule.view.Partidos

class DeporteViewHolden (view: View): RecyclerView.ViewHolder(view){
    val binding = ItemListBinding.bind(view)

    fun render(deporteList: Deporte){
        binding.txtLvvreFecha.text = deporteList.deporte
        itemView.setOnClickListener {
            llamarPartidos()
        }
    }

    fun llamarPartidos() {
        val intent = Intent(binding.txtLvvreFecha.context, Partidos::class.java)
        intent.putExtra("deporte", binding.txtLvvreFecha.text)
        binding.txtLvvreFecha.context.startActivity(intent)
    }
}