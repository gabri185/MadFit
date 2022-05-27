package com.example.proyecto_final.mainModule.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.proyecto_final.R

class SplashActivity: AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        setup()
    }

    private fun setup() {
        /** Duracion de la splash activity **/
        val SPLASH_DISPLAY_LENGTH:Int  = 1000;
        /* Una vez pasado el tiempo se iniciara la activity de login.*/
        Handler ().postDelayed(Runnable (){

                /* Creamos el intent de la activity del login y la iniciamos. */
                startActivity(Intent(this, Login::class.java))

        }, SPLASH_DISPLAY_LENGTH.toLong());
    }
}