package com.example.proyecto_final.mainModule.view

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.proyecto_final.databinding.ActivityRegistrarseBinding
import com.google.firebase.auth.FirebaseAuth

class Registrarse: AppCompatActivity() {
    private lateinit var binding: ActivityRegistrarseBinding
    lateinit var progress: ProgressDialog
    lateinit var firebaseauth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrarseBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setup()

        firebaseauth= FirebaseAuth.getInstance();
        progress = ProgressDialog(this)

    }

    private fun setup() {


        binding.btRegistrarse.setOnClickListener {
            comprobarContraseña()
        }
    }

    private fun comprobarContraseña() {
        if (binding.tvContraseA.text.toString() == binding.tvContraseAR.text.toString()) {
            registrarUsuario()
        }else{
            Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_LONG).show();
        }
    }
    private fun registrarUsuario() {
        //Conseguimos el email y la contraseña de las cajas de texto
        var email: String = binding.tvUsuario.text.toString()
        val contraseña: String = binding.tvContraseA.text.toString()

        //Comproba,os que las cajas de texto no estan vacias
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "Tienes que ingresar tu email", Toast.LENGTH_LONG).show();
        }else{
            if (TextUtils.isEmpty(contraseña)) {
                Toast.makeText(this, "Tienes que ingresar tu contraseña", Toast.LENGTH_LONG).show();
            }
        }

        progress.setMessage("Realizando registro en linea")
        progress.show()


        firebaseauth.createUserWithEmailAndPassword(email, contraseña)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Toast.makeText(
                        this, "Se ha registrado el usuario con el email" + binding.tvUsuario.text,
                        Toast.LENGTH_LONG

                    ).show();
                    startActivity(Intent(this, Datos::class.java))
                } else {
                    // If sign in fails, display a message to the user.
                    Toast.makeText(this, "No se pudo registrar el usuario", Toast.LENGTH_LONG)
                        .show();
                }
                progress.dismiss()
            }
    }
}