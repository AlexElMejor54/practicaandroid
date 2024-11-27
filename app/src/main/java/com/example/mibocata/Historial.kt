package com.example.mibocata

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView

class Historial : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.historialactivity)

        val listView: ListView = findViewById(R.id.lista)
        val imagePerfil = findViewById<ImageView>(R.id.perfil)
        val imageCalendar = findViewById<ImageView>(R.id.calendario)
        val imageHistory = findViewById<ImageView>(R.id.historial)
        val imageLogo = findViewById<ImageView>(R.id.logo)

        val elementos = listOf(
            "20/20/2020: Atún con lechuga",
            "20/20/2020: Jamón con tomate",
            "20/20/2020: Queso fresco con espinacas",
            "20/20/2020: Pollo con mostaza",
            "20/20/2020: Salmón ahumado y aguacate"
        )

        val adapter = ArrayAdapter(
            this, // Contexto
            android.R.layout.simple_list_item_1, // Layout predefinido para cada elemento
            elementos // Lista de datos
        )

        // Asignar el Adapter al ListView
        listView.adapter = adapter


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
