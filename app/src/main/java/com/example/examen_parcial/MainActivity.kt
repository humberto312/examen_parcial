package com.example.examen_parcial

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
class MainActivity : AppCompatActivity() {

    private val usuarios = listOf(
        Usuarios("Juan Pérez", "juan", "1234", "juan@example.com"),
        Usuarios("Ana Gómez", "ana", "5678", "ana@example.com")
    )

    private var intentos = 0  // Contador de intentos

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editLogin: EditText = findViewById(R.id.editLogin)
        val editPassword: EditText = findViewById(R.id.editPassword)
        val btnEntrar: Button = findViewById(R.id.btnEntrar)
        val textIntentos: TextView = findViewById(R.id.textIntentos)

        btnEntrar.setOnClickListener {
            intentos++  // Incrementar contador de intentos
            textIntentos.text = "Intentos: $intentos"  // Actualizar el TextView

            val login = editLogin.text.toString()
            val password = editPassword.text.toString()

            val usuarioEncontrado = usuarios.find {
                it.login == login && it.password == password
            }

            if (usuarioEncontrado != null) {
                // Lanzar la segunda pantalla si el login es correcto
                val intent = Intent(this, app_bienvenida::class.java)
                intent.putExtra("nombre", usuarioEncontrado.nombre)
                intent.putExtra("login", usuarioEncontrado.login)
                intent.putExtra("email", usuarioEncontrado.email)
                intent.putExtra("intentos", intentos)  // Pasar intentos
                startActivity(intent)
            } else {
                Toast.makeText(this, "Login o contraseña incorrectos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

