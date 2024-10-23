package com.example.examen_parcial

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class app_bienvenida : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bienvenida_app)

        val textNombre: TextView = findViewById(R.id.textNombre)
        val textLogin: TextView = findViewById(R.id.textLogin)
        val textEmail: TextView = findViewById(R.id.textEmail)

        // Obtener los datos enviados desde la primera pantalla
        val nombre = intent.getStringExtra("nombre")
        val login = intent.getStringExtra("login")
        val email = intent.getStringExtra("email")
        val intentos = intent.getIntExtra("intentos", 0)  // Obtener intentos

        // Mostrar los datos en los TextView
        textNombre.text = "Nombre: $nombre"
        textLogin.text = "Login: $login"
        textEmail.text = "Email: $email"
    }
}
