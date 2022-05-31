package com.example.proyecto_final.mainModule.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto_final.R
import com.example.proyecto_final.data.model.Deporte

class DeporteAdapter(val deporte: List<Deporte>) : RecyclerView.Adapter<DeporteViewHolden>() {
    private var posicionP = 2
    private var posicionI = 2

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DeporteViewHolden {
        val layoutInflater = LayoutInflater.from(parent.context)
        return DeporteViewHolden(layoutInflater.inflate(R.layout.item_list,parent,false))
    }

    override fun onBindViewHolder(holder: DeporteViewHolden, position: Int) {
        val item = deporte[position]

        holder?.render(item)


        if ((position % 2) == 0){
            if ((posicionP % 2) == 0){
                holder.itemView.setBackgroundColor(Color.rgb(139, 241, 125))
                posicionP ++
            }else{
                holder.itemView.setBackgroundColor(Color.rgb(255, 253, 100))
                posicionP ++
            }
        }
        else{
            if ((posicionI % 2) == 0){
                holder.itemView.setBackgroundColor(Color.rgb(132, 177, 246))
                posicionI ++
            }else{
                holder.itemView.setBackgroundColor(Color.rgb(246, 148, 230 ))
                posicionI ++
            }
        }
    }

    override fun getItemCount(): Int = deporte.size
}