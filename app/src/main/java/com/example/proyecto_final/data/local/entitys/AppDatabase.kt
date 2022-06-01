package com.example.proyecto_final.data.local.entitys

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [User::class, Partidos::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun partidosDao(): PartidosDao
}