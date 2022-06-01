package com.example.proyecto_final.mainModule.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.proyecto_final.data.local.entitys.AppDatabase
import com.example.proyecto_final.data.model.Partido
import com.example.proyecto_final.databinding.ActivityPartidosBinding
import com.example.proyecto_final.mainModule.adapter.PartidoAdapter

class Partidos : AppCompatActivity() {
    private lateinit var binding: ActivityPartidosBinding
    private lateinit var deporte: String
    private lateinit var lista: List<Partido>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPartidosBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setup()
    }

    fun setup() {
        val bundle = intent.extras
        deporte = bundle?.getString("deporte")!!

        Toast.makeText(this, deporte, Toast.LENGTH_SHORT).show()

        binding.fabGuardar.setOnClickListener {
            startActivity(Intent(this, CrearPartido::class.java))
        }

        crear_list()

        binding.refrescar.setOnRefreshListener {

            refrescar()
        }


    }

    fun crear_list() {
        val db = Room.databaseBuilder(
            binding.deportes.context,
            AppDatabase::class.java, "database-user"
        ).allowMainThreadQueries().build()

        val partidoDao = db.partidosDao()

        lista = partidoDao.getAll(deporte)

        val manager = LinearLayoutManager(this)
        //val decoration = DividerItemDecoration(this, manager.orientation)



        binding.listaDeportes.layoutManager = manager
        binding.listaDeportes.adapter = PartidoAdapter(lista)
        //binding.listaDeportes.addItemDecoration(decoration)
    }

    private fun refrescar() {

        crear_list()
        val SPLASH_DISPLAY_LENGTH:Int  = 1000;
        /* Una vez pasado el tiempo se iniciara la activity de login.*/
        Handler ().postDelayed(Runnable (){

            /* Creamos el intent de la activity del login y la iniciamos. */
            binding.refrescar.setRefreshing(false)

        }, SPLASH_DISPLAY_LENGTH.toLong());
    }
}