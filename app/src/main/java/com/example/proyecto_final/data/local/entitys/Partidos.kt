package com.example.proyecto_final.data.local.entitys

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Partidos (
    @ColumnInfo(name = "centro") val centro: String?,
    @ColumnInfo(name = "deporte") val deporte: String?,
    @ColumnInfo(name = "jugadores") val jugadores: String?,
    @ColumnInfo(name = "fecha") val fecha: String?,
    @ColumnInfo(name = "hora") val hora: String?,
    @PrimaryKey(autoGenerate = true) var id: Int = 0

    )