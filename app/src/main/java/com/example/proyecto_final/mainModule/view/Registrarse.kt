package com.example.proyecto_final.mainModule.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.proyecto_final.databinding.ActivityRegistrarseBinding

class Registrarse: AppCompatActivity() {
    private lateinit var binding: ActivityRegistrarseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrarseBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setup()
    }

    private fun setup() {
        binding.btRegistrarse.setOnClickListener {
            startActivity(Intent(this, Datos::class.java))
        }
    }
}