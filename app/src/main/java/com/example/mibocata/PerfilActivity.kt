package com.example.mibocata

import androidx.appcompat.app.AppCompatActivity


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast

class PerfilActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.perfilactivity)

        val imageCalendar = findViewById<ImageView>(R.id.calendario)
        val imageHistory = findViewById<ImageView>(R.id.historial)
        val imagePerfil = findViewById<ImageView>(R.id.perfil)
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
    }
}