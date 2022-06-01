package com.example.proyecto_final.data.local.entitys

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.proyecto_final.data.model.Partido

@Dao
interface PartidosDao {
    @Query("SELECT * FROM partidos WHERE deporte= :dep")
    fun getAll(dep: String): List<Partido>

    @Insert
    fun insertAll(vararg partidos: Partidos)
}