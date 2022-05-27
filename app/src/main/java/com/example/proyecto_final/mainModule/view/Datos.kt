package com.example.proyecto_final.mainModule.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.proyecto_final.databinding.AcivityDatosBinding

class Datos: AppCompatActivity() {
    private lateinit var binding: AcivityDatosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = AcivityDatosBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}