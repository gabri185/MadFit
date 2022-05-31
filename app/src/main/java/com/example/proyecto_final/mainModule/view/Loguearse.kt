package com.example.proyecto_final.mainModule.view

import android.app.ProgressDialog
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.biometric.BiometricManager
import androidx.biometric.BiometricPrompt
import androidx.core.content.ContextCompat
import com.example.proyecto_final.databinding.ActivityLoguearseBinding
import com.google.firebase.auth.FirebaseAuth
import java.util.concurrent.Executor

class Loguearse: AppCompatActivity() {
    private lateinit var binding: ActivityLoguearseBinding
    lateinit var progress: ProgressDialog
    lateinit var firebaseauth: FirebaseAuth
    private var canAuthenticate = false
    private lateinit var promptInfo: BiometricPrompt.PromptInfo
    private lateinit var biometricPrompt: BiometricPrompt
    private lateinit var executor: Executor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoguearseBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setup()
        //setupAuth()
        authenticate()

        firebaseauth = FirebaseAuth.getInstance();
        progress = ProgressDialog(this)
    }

    private fun setupAuth() {
        if (BiometricManager.from(this).canAuthenticate(
                BiometricManager.Authenticators.BIOMETRIC_STRONG
                        or BiometricManager.Authenticators.DEVICE_CREDENTIAL
            ) == BiometricManager.BIOMETRIC_SUCCESS
        ) {

            canAuthenticate = true

            promptInfo = BiometricPrompt.PromptInfo.Builder()
                .setTitle("Autenticación biométrica")
                .setSubtitle("Autentícate utilixando el sensor biométrico")
                .setAllowedAuthenticators(
                    BiometricManager.Authenticators.BIOMETRIC_STRONG
                            or BiometricManager.Authenticators.DEVICE_CREDENTIAL
                )
                .build()
        }
    }

    private fun authenticate() {

        executor = ContextCompat.getMainExecutor(this)
        biometricPrompt = BiometricPrompt(this, executor,
            object : BiometricPrompt.AuthenticationCallback() {
                override fun onAuthenticationError(
                    errorCode: Int,
                    errString: CharSequence
                ) {
                    super.onAuthenticationError(errorCode, errString)
                    Toast.makeText(
                        applicationContext,
                        "Authentication error: $errString", Toast.LENGTH_SHORT
                    )
                        .show()
                }

                override fun onAuthenticationSucceeded(
                    result: BiometricPrompt.AuthenticationResult
                ) {
                    super.onAuthenticationSucceeded(result)
                    Toast.makeText(
                        applicationContext,
                        "Authentication succeeded!", Toast.LENGTH_SHORT
                    )
                        .show()

                }

                override fun onAuthenticationFailed() {
                    super.onAuthenticationFailed()
                    Toast.makeText(
                        applicationContext, "Authentication failed",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                }
            })

        promptInfo = BiometricPrompt.PromptInfo.Builder()
            .setTitle("Autenticación biométrica")
            .setSubtitle("Autentícate utilixando el sensor biométrico")
            .setAllowedAuthenticators(
                BiometricManager.Authenticators.BIOMETRIC_STRONG or
                        BiometricManager.Authenticators.DEVICE_CREDENTIAL
            )
            .build()

        // Prompt appears when user clicks "Log in".
        // Consider integrating with the keystore to unlock cryptographic operations,
        // if needed by your app.

        binding.btLogin.setOnClickListener {
            biometricPrompt.authenticate(promptInfo)
        }
    }

    private fun setup() {
        binding.btLogin.setOnClickListener {
            login()
        }
    }

    private fun login() {
        //Conseguimos el email y la contraseña de las cajas de texto
        var email: String = binding.tvUsuario.text.toString()
        val contraseña: String = binding.tvContraseA.text.toString()

        //Comproba,os que las cajas de texto no estan vacias
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "Tienes que ingresar tu email", Toast.LENGTH_LONG).show();
        }
        if (TextUtils.isEmpty(contraseña)) {
            Toast.makeText(this, "Tienes que ingresar tu contraseña", Toast.LENGTH_LONG).show();
        }

        progress.setMessage("Logueandose")
        progress.show()

        firebaseauth.signInWithEmailAndPassword(email,contraseña)
            .addOnCompleteListener (this){ task ->
                if (task.isSuccessful){
                    Toast.makeText(
                        this, "Se ha logueado con exito" + binding.tvUsuario.text,
                        Toast.LENGTH_LONG

                    ).show();
                }else{
                    Toast.makeText(
                        this, "No se pudo loguear" + binding.tvUsuario.text,
                        Toast.LENGTH_LONG

                    ).show();
                }
                progress.dismiss()
            }
    }
}