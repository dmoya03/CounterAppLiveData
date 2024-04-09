package com.example.counterlivedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

class MainActivity : AppCompatActivity() {

    // Crear un LiveData mutable para el contador
    private val contadorLiveData = MutableLiveData<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textViewCounter = findViewById<TextView>(R.id.textViewCounter)
        val buttonIncrement = findViewById<Button>(R.id.buttonIncrement)

        // Inicializar el contador
        contadorLiveData.value = 0

        // Observar el cambio en el contador y actualizar la interfaz de usuario
        contadorLiveData.observe(this, Observer { contador ->
            textViewCounter.text = "Contador: $contador"
        })

        // Incrementar el contador cada vez que se presiona el botón
        buttonIncrement.setOnClickListener {
            val contadorActual = contadorLiveData.value ?: 0
            contadorLiveData.value = contadorActual + 1
        }
    }
}
