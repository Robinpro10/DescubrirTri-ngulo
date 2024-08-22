package com.example.descubrirtringulo

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Referencias a los elementos de la vista
        val lado1 = findViewById<EditText>(R.id.lado1)
        val lado2 = findViewById<EditText>(R.id.lado2)
        val lado3 = findViewById<EditText>(R.id.lado3)
        val botonDeterminar = findViewById<Button>(R.id.botonDeterminar)
        val resultadoTriangulo = findViewById<TextView>(R.id.resultadoTriangulo)

        botonDeterminar.setOnClickListener {
            // Obtener los valores de los lados
            val l1 = lado1.text.toString().toIntOrNull()
            val l2 = lado2.text.toString().toIntOrNull()
            val l3 = lado3.text.toString().toIntOrNull()

            // Verificar que los valores ingresados sean válidos
            if (l1 != null && l2 != null && l3 != null) {
                // Determinar el tipo de triángulo
                val tipoTriangulo = determinarTipoTriangulo(l1, l2, l3)
                resultadoTriangulo.text = "El triángulo es $tipoTriangulo"
            } else {
                resultadoTriangulo.text = "Por favor, introduce valores válidos para los tres lados."
            }
        }
    }

    // Método para determinar el tipo de triángulo
    private fun determinarTipoTriangulo(lado1: Int, lado2: Int, lado3: Int): String {
        return when {
            lado1 == lado2 && lado2 == lado3 -> "Equilátero"
            lado1 == lado2 || lado1 == lado3 || lado2 == lado3 -> "Isósceles"
            else -> "Escaleno"
        }
    }
}