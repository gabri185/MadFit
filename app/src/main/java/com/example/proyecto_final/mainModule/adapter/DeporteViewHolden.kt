package com.example.proyecto_final.mainModule.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto_final.data.model.Deporte
import com.example.proyecto_final.databinding.ItemListBinding

class DeporteViewHolden (view: View): RecyclerView.ViewHolder(view){
    val binding = ItemListBinding.bind(view)

    fun render(deporteList: Deporte){
        binding.txtLvvreFecha.text = deporteList.deporte
    }
}