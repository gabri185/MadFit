package com.example.proyecto_final.mainModule.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto_final.R
import com.example.proyecto_final.data.model.Partido

class PartidoAdapter(val partido: List<Partido>) : RecyclerView.Adapter<PartidoViewHolden>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PartidoViewHolden {
        val layoutInflater = LayoutInflater.from(parent.context)
        return PartidoViewHolden(layoutInflater.inflate(R.layout.item_partidos,parent,false))
    }

    override fun onBindViewHolder(holder: PartidoViewHolden, position: Int) {
        val item = partido[position]

        holder?.render(item)

    }

    override fun getItemCount(): Int = partido.size
}
