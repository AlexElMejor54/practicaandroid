package com.example.mibocata

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.InputStreamReader
import java.time.LocalDate


class SeleccionBocata : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.seleccionbocata)

        // Referencias a los EditTexts
        val imageCalendar = findViewById<ImageView>(R.id.calendario)
        val imageHistory = findViewById<ImageView>(R.id.historial)
        val imagePerfil = findViewById<ImageView>(R.id.perfil)
        val imageLogo = findViewById<ImageView>(R.id.logo)

        // Obtener el día actual

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
        val bocadillossemana = cargarBocadillosDesdeJson()
        val diaActual = diaActual()

        val bocadillocaliente = bocadillossemana.bocadilloscalientes[diaActual]
        val bocadillofrio = bocadillossemana.bocadillosfrios[diaActual]


        val textoscalientes = findViewById<TextView>(R.id.bocatascalientes)
        val textosfrios = findViewById<TextView>(R.id.bocatasfrios)

        textosfrios.text = bocadillofrio?: "No hay bocadillo"
        textoscalientes.text = bocadillocaliente?: "No hay bocadillo"


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
    }

}


