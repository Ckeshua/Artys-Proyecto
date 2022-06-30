package com.UnabEduardo.proyectotitulo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        hola()
    }
    private fun hola(){
        findViewById<Button>(R.id.login_button).setOnClickListener {
            val myintent = Intent(this,Activity_auth::class.java)
            startActivity(myintent)
        }
    }
}