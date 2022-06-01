package com.example.proyecto_final.data.local.entitys

import android.app.Application
import androidx.room.Room

class MisPartidos : Application(){

    companion object {
        lateinit var database: AppDatabase
    }

    override fun onCreate() {
        super.onCreate()
        database =  Room.databaseBuilder(this, AppDatabase::class.java, "tasks-db").build()
    }
}