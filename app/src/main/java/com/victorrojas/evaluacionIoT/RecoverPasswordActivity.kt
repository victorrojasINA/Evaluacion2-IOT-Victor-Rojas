package com.victorrojas.evaluacionIoT

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RecoverPasswordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recover_password)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val buttonRecover = findViewById<Button>(R.id.buttonRecover)

        buttonRecover.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Recuperación Completada")
                .setMessage("Se ha enviado un correo para la recuperación de la contraseña")
                .setPositiveButton("Aceptar") { dialog, which ->
                    // Con esto podemos volver a la pantalla principal (el login)
                    finish()
                }
                .show()
        }
    }
}