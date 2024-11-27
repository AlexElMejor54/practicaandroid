package com.example.mibocata

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Login : AppCompatActivity() {
    // Variables para las credenciales correctas
    private val validUsername = "admin"
    private val validPassword = "1234"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.loginactivity)

        // Referencias a los elementos del layout
        val usernameEditText = findViewById<EditText>(R.id.usuario)
        val passwordEditText = findViewById<EditText>(R.id.contrasena)
        val loginButton = findViewById<Button>(R.id.loginButton)

        // Configuración del botón
        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (username == validUsername && password == validPassword) {
                // Credenciales correctas, ir a la siguiente pantalla
                val intent = Intent(this, SeleccionBocata::class.java)
                startActivity(intent)
            } else {
                // Credenciales incorrectas, mostrar mensaje
                Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}