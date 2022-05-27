package com.example.proyecto_final.mainModule.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.proyecto_final.databinding.ActivityLoguearseBinding

class Loguearse: AppCompatActivity() {
    private lateinit var binding: ActivityLoguearseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoguearseBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}