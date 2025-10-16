package com.victorrojas.evaluacionIoT

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Con esto hacemos que haya una demora al iniciar la app
        Handler(Looper.getMainLooper()).postDelayed({

            // Despues de la demora se mostrara lo siguiente
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()

        }, 3000)
    }
}