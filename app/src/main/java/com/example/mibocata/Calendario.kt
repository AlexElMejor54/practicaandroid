package com.example.mibocata

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


import android.content.Intent
import android.widget.GridView

import android.widget.ImageView
import android.widget.TextView
import com.example.mibocataa.ProximoAdapter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.InputStreamReader
import java.time.LocalDate


class Calendario : AppCompatActivity() {

    @SuppressLint("SetTextI18n", "CutPasteId", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.calendarioactivity)

        val siguientebocatacaliente = findViewById<TextView>(R.id.bocatasiguientecaliente)
        val siguientebocatafrio = findViewById<TextView>(R.id.bocatasiguientefrio)



        // Obtener el día siguiente
        fun tomorrow(): String{
            val today = LocalDate.now()
            val tomorrow = today.plusDays(1)
            return tomorrow.dayOfWeek.toString()
        }

        val imagePerfil = findViewById<ImageView>(R.id.perfil)
        val imageCalendar = findViewById<ImageView>(R.id.calendario)
        val imageHistory = findViewById<ImageView>(R.id.historial)
        val imageLogo = findViewById<ImageView>(R.id.logo)

        imageCalendar.setOnClickListener {
            val intent = Intent(this, Calendario::class.java)
            startActivity(intent)
        }

        imageHistory.setOnClickListener {
            val intent = Intent(this, Historial::class.java)
            startActivity(intent)
        }
        imagePerfil.setOnClickListener {
            val intent = Intent(this, PerfilActivity::class.java)
            startActivity(intent)
        }
        imageLogo.setOnClickListener {
            val intent = Intent(this, SeleccionBocata::class.java)
            startActivity(intent)
        }


        fun diaActual(): String{
            val diaActual = LocalDate.now()
            return diaActual.dayOfWeek.toString()
        }

        fun cargarBocadillosDesdeJson(): Bocadillo {
            val inputStream = resources.openRawResource(R.raw.bocadillosemana)
            val lector = InputStreamReader(inputStream)
            val tipo = object : TypeToken<Bocadillo>() {}.type
            return Gson().fromJson(lector, tipo)
        }

        fun cargarBocadillosSemanaDesdeJson(): BocadilloProximo {
            val inputStream = resources.openRawResource(R.raw.bocadilloproximo)
            val lector = InputStreamReader(inputStream)
            val tipo = object : TypeToken<BocadilloProximo>() {}.type
            return Gson().fromJson(lector, tipo)
        }

        val bocadiloproximos = cargarBocadillosSemanaDesdeJson()

        val bocadilloproximomap = bocadiloproximos.bocadillos


        val bocadillossemana = cargarBocadillosDesdeJson()
        val siguientedia = tomorrow()



        val bocadillocaliente = bocadillossemana.bocadilloscalientes[siguientedia]
        val bocadillofrio = bocadillossemana.bocadillosfrios[siguientedia]

        val textoscalientes = findViewById<TextView>(R.id.bocatasiguientecaliente)
        val textosfrios = findViewById<TextView>(R.id.bocatasiguientefrio)

        textosfrios.text = bocadillofrio?: "No hay bocadillo"
        textoscalientes.text = bocadillocaliente?: "No hay bocadillo"

        val bocatagrid : GridView = findViewById(R.id.gridbocata)
        val adapter = ProximoAdapter(this,bocadilloproximomap)
        bocatagrid.adapter = adapter

    }
}
