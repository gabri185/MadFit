package com.example.proyecto_final.mainModule.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.proyecto_final.databinding.ActivityLoginBinding

class Login: AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setup()
    }

    private fun setup() {

        binding.btLogin.setOnClickListener {
            startActivity(Intent(this, Loguearse::class.java))
        }
        binding.btRegistrarse.setOnClickListener {
            startActivity(Intent(this, Registrarse::class.java))
        }
    }
}