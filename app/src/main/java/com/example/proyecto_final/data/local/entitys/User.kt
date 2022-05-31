package com.example.proyecto_final.data.local.entitys

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey val correo: String,
    @ColumnInfo(name = "nombreUser") val nombreUser: String?,
    @ColumnInfo(name = "nombre") val nombre: String?,
    @ColumnInfo(name = "apellidos") val apellidos: String?,
    @ColumnInfo(name = "movil") val movil: String?,
    @ColumnInfo(name = "ciudad") val ciudad: String?,
    @ColumnInfo(name = "calle") val calle: String?,
    @ColumnInfo(name = "numero") val numero: String?
        )