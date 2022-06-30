package com.UnabEduardo.proyectotitulo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth

class Activity_auth : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        val InputEmail = findViewById<EditText>(R.id.InputEmail)
        val InputPassw = findViewById<EditText>(R.id.InputPassw)
        val myintent = Intent(this, MainActivity::class.java)

        findViewById<Button>(R.id.Btn_IniciarS).setOnClickListener {
            if (findViewById<EditText>(R.id.InputEmail).text.isNotEmpty() &&
                findViewById<EditText>(R.id.InputPassw).text.isNotEmpty()
            ) {
                FirebaseAuth.getInstance()
                    .signInWithEmailAndPassword(
                        InputEmail.text.toString(),
                        InputPassw.text.toString()
                    ).addOnCompleteListener {
                        if (it.isSuccessful) {
                            startActivity(myintent)
                        }
                        else{
                            showAlert()
                        }
                    }
            }
        }
        findViewById<Button>(R.id.Btn_register).setOnClickListener {
            if (findViewById<EditText>(R.id.InputEmail).text.isNotEmpty() &&
                findViewById<EditText>(R.id.InputPassw).text.isNotEmpty()
            ){
                FirebaseAuth.getInstance()
                    .createUserWithEmailAndPassword(
                        InputEmail.text.toString(),
                        InputPassw.text.toString()
                    ).addOnCompleteListener {
                        if (it.isSuccessful){
                            startActivity(myintent)
                        }
                        else{
                            showAlert()
                        }
                    }
            }

        }
    }
    private fun showAlert(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Se ha producido un error al autenticar usuario")
        builder.setPositiveButton("Aceptar",null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
}
