package com.example.proyecto_final

import com.example.proyecto_final.data.model.Deporte

class DeporteProvider {
    companion object{
        val deporteList = listOf<Deporte>(
            Deporte(
                "FUTBOL",
                "2354",
                true
            ),
            Deporte(
                "BALONCESTO",
                "1154",
                true
            ),
            Deporte(
                "TENIS",
                "2954",
                true
            ),
            Deporte(
                "BADMINTON",
                "3154",
                false
            ),
            Deporte(
                "BOLOS",
                "158",
                false
            ),
            Deporte(
                "PADEL",
                "450",
                true
            )
        )
    }
}