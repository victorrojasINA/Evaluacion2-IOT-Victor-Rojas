package com.victorrojas.evaluacionIoT

import android.Manifest
import android.bluetooth.BluetoothAdapter
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginActivity : AppCompatActivity() {

    private val requestPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted: Boolean ->
            if (isGranted) {
                // si el usuario concede el permiso, entonces se verifica el estado
                showBluetoothStatus()
            } else {
                // si el usuario niega el permiso, se muestra el que no dio permiso
                showPermissionDeniedDialog()
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val buttonLogin = findViewById<Button>(R.id.buttonLogin)
        val textViewGoToRegister = findViewById<TextView>(R.id.textViewGoToRegister)
        val textViewGoToRecover = findViewById<TextView>(R.id.textViewGoToRecover)
        val buttonCheckBluetooth = findViewById<Button>(R.id.buttonCheckBluetooth)

        buttonLogin.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Simulación Exitosa")
                .setMessage("Inicio de sesión completado")
                .setPositiveButton("Aceptar", null)
                .show()
        }
        textViewGoToRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
        textViewGoToRecover.setOnClickListener {
            startActivity(Intent(this, RecoverPasswordActivity::class.java))
        }

        // aqui va el boton de bluetooth
        buttonCheckBluetooth.setOnClickListener {
            checkAndRequestBluetoothPermission()
        }
    }

    private fun checkAndRequestBluetoothPermission() {
        // aqui se piden permisos
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            when {
                ContextCompat.checkSelfPermission(
                    this,
                    Manifest.permission.BLUETOOTH_CONNECT
                ) == PackageManager.PERMISSION_GRANTED -> {
                    // si ya se dieron los permisos, simplemente se muestra el estado
                    showBluetoothStatus()
                }
                else -> {
                    // si el permiso fue rechazo y no se tiene, se muestra denuevo el dar permiso
                    requestPermissionLauncher.launch(Manifest.permission.BLUETOOTH_CONNECT)
                }
            }
        } else {
            showBluetoothStatus()
        }
    }

    private fun showBluetoothStatus() {
        val bluetoothAdapter: BluetoothAdapter? = BluetoothAdapter.getDefaultAdapter()
        val message: String

        if (bluetoothAdapter == null) {
            message = "Este dispositivo no es compatible con Bluetooth"
        } else {
            // como ya hemos pasado el filtro de permisos, podemos verificar de forma segura
            message = if (bluetoothAdapter.isEnabled) "El Bluetooth está ACTIVADO" else "El Bluetooth está DESACTIVADO"
        }

        AlertDialog.Builder(this)
            .setTitle("Estado de Bluetooth")
            .setMessage(message)
            .setPositiveButton("Entendido", null)
            .show()
    }

    private fun showPermissionDeniedDialog() {
        AlertDialog.Builder(this)
            .setTitle("Permiso Denegado")
            .setMessage("No se puede verificar el estado del Bluetooth sin el permiso correspondiente")
            .setPositiveButton("Entendido", null)
            .show()
    }
}