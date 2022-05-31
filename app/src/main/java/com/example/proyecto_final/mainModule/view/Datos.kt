package com.example.proyecto_final.mainModule.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.proyecto_final.data.local.entitys.AppDatabase
import com.example.proyecto_final.data.local.entitys.User
import com.example.proyecto_final.databinding.AcivityDatosBinding

class Datos: AppCompatActivity() {
    private lateinit var binding: AcivityDatosBinding
    private lateinit var correo: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = AcivityDatosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras
        correo = bundle?.getString("correo")!!

        binding.btLogin.setOnClickListener {
            insertarDatos()
        }

    }

    private fun insertarDatos() {

        val db = Room.databaseBuilder(
            binding.btLogin.context,
            AppDatabase::class.java, "database-user"
        ).allowMainThreadQueries().build()

        val userDao = db.userDao()


        val user = User(
            correo,
            binding.tvUsuario.text.toString(),
            binding.tvNombre.text.toString(),
            binding.tvApellidos.text.toString(),
            binding.tvTelefono.text.toString(),
            binding.tvCiudad.text.toString(),
            binding.tvCalle.text.toString(),
            binding.tvNumero.text.toString()
        )





        userDao.insertAll(user)
        //userDao.deleteAll()

        println(userDao.getAll())
    }
}