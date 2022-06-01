package com.example.proyecto_final.mainModule.view

import android.R
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.proyecto_final.data.local.entitys.AppDatabase
import com.example.proyecto_final.data.local.entitys.Partidos
import com.example.proyecto_final.databinding.ActivityCrearBinding

class CrearPartido :AppCompatActivity(){

    private lateinit var binding: ActivityCrearBinding
    private lateinit var centro: String
    private lateinit var deporte: String
    private lateinit var jugadores: String
    private lateinit var fecha: String
    private lateinit var hora: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCrearBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setup()
    }

    fun setup() {

        spinerCentro(binding.txtnombrecentro)
        spinerDeporte(binding.txtdeporte)
        spinerJugadores(binding.txtjugadores)
        spinerFecha(binding.txtfecha)
        spinerHora(binding.txthora)

        binding.guardar.setOnClickListener {
            guardar()
            onBackPressed()
        }

    }


    private fun spinerCentro(spiner: Spinner) {
        var lista = ArrayList<String>()
        lista.add("Centro1")
        lista.add("Centro2")
        lista.add("Centro3")
        lista.add("Centro4")
        lista.add("Centro5")

        spiner.setAdapter(
            ArrayAdapter<String>(
                this,
                R.layout.simple_spinner_dropdown_item,
                lista
            )
        )

        binding.txtnombrecentro.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>,
                                        view: View, position: Int, id: Long) {
                centro = lista[position]
            }
            override fun onNothingSelected(parent: AdapterView<*>) {
                // write code to perform some action
            }
            }
    }

    private fun spinerDeporte(spiner: Spinner) {
        var lista = ArrayList<String>()
        lista.add("FUTBOL")
        lista.add("BALONCESTO")
        lista.add("TENIS")
        lista.add("BADMINTON")
        lista.add("BOLOS")
        lista.add("PADEL")

        spiner.setAdapter(
            ArrayAdapter<String>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                lista
            )
        )

        binding.txtdeporte.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>,
                                        view: View, position: Int, id: Long) {
                deporte = lista[position]
            }
            override fun onNothingSelected(parent: AdapterView<*>) {
                // write code to perform some action
            }
        }
    }

    private fun spinerJugadores(spiner: Spinner) {
        var lista = ArrayList<String>()
        lista.add("1 vs 1")
        lista.add("2 vs 2")
        lista.add("3 vs 3")
        lista.add("4 vs 4")
        lista.add("5 vs 5")
        lista.add("6 vs 6")
        lista.add("7 vs 7")
        lista.add("9 vs 9")
        lista.add("11 vs 11")

        spiner.setAdapter(
            ArrayAdapter<String>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                lista
            )
        )

        binding.txtjugadores.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>,
                                        view: View, position: Int, id: Long) {
                jugadores = lista[position]
            }
            override fun onNothingSelected(parent: AdapterView<*>) {
                // write code to perform some action
            }
        }
    }

    private fun spinerFecha(spiner: Spinner) {
        var lista = ArrayList<String>()
        lista.add("miercoles, 1 jun. 2022")
        lista.add("jueves, 2 jun. 2022")
        lista.add("viernes, 3 jun. 2022")
        lista.add("sabado, 4 jun. 2022")
        lista.add("domingo, 5 jun. 2022")

        spiner.setAdapter(
            ArrayAdapter<String>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                lista
            )
        )

        binding.txtfecha.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>,
                                        view: View, position: Int, id: Long) {
                fecha = lista[position]
            }
            override fun onNothingSelected(parent: AdapterView<*>) {
                // write code to perform some action
            }
        }
    }

    private fun spinerHora(spiner: Spinner) {
        var lista = ArrayList<String>()
        lista.add("8:30")
        lista.add("9:00")
        lista.add("9:30")
        lista.add("10:00")
        lista.add("10:30")
        lista.add("11:00")
        lista.add("11:30")
        lista.add("12:00")
        lista.add("12:30")
        lista.add("13:00")
        lista.add("13:30")
        lista.add("14:00")
        lista.add("14:30")
        lista.add("15:00")
        lista.add("15:30")
        lista.add("16:00")
        lista.add("16:30")
        lista.add("17:00")
        lista.add("17:30")

        spiner.setAdapter(
            ArrayAdapter<String>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                lista
            )
        )

        binding.txthora.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>,
                                        view: View, position: Int, id: Long) {
                hora = lista[position]
            }
            override fun onNothingSelected(parent: AdapterView<*>) {
                // write code to perform some action
            }
        }
    }

    private fun guardar() {
        val db = Room.databaseBuilder(
            binding.tcentro.context,
            AppDatabase::class.java, "database-user"
        ).allowMainThreadQueries().build()

        val partidoDao = db.partidosDao()

        val partido = Partidos(
            centro,
            deporte,
            jugadores,
            fecha,
            hora
        )

        partidoDao.insertAll(partido)


        println(partidoDao.getAll(deporte))

    }
}