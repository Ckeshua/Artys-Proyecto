package com.UnabEduardo.proyectotitulo

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class Activityprofile : AppCompatActivity() {
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.actionbar_profile, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        return when (item.itemId) {
            R.id.editar -> {
                val myintent = Intent(this,Activity_auth::class.java)
                startActivity(myintent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        firebaseAuth = FirebaseAuth.getInstance()
        loadUserInfo()
    }
    private fun loadUserInfo(){
        val textView: TextView = findViewById(R.id.email_textv)
        textView.text = firebaseAuth.currentUser?.email
        if (firebaseAuth.currentUser?.displayName == ""){
            val textView: TextView = findViewById(R.id.textv_name)
            textView.setText("Nombre No asignado")
        }
        else {
            val textView: TextView = findViewById(R.id.textv_name)
            textView.text = firebaseAuth.currentUser?.displayName
        }
        if (firebaseAuth.currentUser?.phoneNumber == ""){
            val textView: TextView = findViewById(R.id.number_textv)
            textView.setText("Numero No asignado")
        }
        else {
            val textView: TextView = findViewById(R.id.number_textv)
            textView.text = firebaseAuth.currentUser?.phoneNumber
        }
    }
}