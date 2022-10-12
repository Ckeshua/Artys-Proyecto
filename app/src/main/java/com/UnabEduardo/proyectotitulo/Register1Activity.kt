package com.UnabEduardo.proyectotitulo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth
import java.util.regex.Matcher
import java.util.regex.Pattern

class Register1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        val InputEmail = findViewById<EditText>(R.id.InputEmail)
        val InputPassw = findViewById<EditText>(R.id.InputPassw)
        val myintent = Intent(this, MainActivity::class.java)

        findViewById<Button>(R.id.Btn_registerBD).setOnClickListener {
            if (findViewById<CheckBox>(R.id.checkBox).isChecked) {
                if (findViewById<EditText>(R.id.InputEmail).text.isNotEmpty() &&
                    findViewById<EditText>(R.id.InputPassw).text.isNotEmpty() &&
                    InputPassw.length() >= 8
                )// {
                //if (checkpass(InputPassw.toString()))
                //{
                    FirebaseAuth.getInstance()
                        .createUserWithEmailAndPassword(
                            InputEmail.text.toString(),
                            InputPassw.text.toString()
                        ).addOnCompleteListener {
                            if (it.isSuccessful) {
                                startActivity(myintent)
                            } else {
                                showAlert("Se ha producido un error al registrar usuario")
                            }
                        }
                // }
                //else{
                //  showAlert(mensajepass)
                //}
            else {
                showAlert(
                    "La contraseña no es valida." +
                            "Por favor inserte una contraseña con largo mayor a 6"
                )
            }
        }
            else{
                showAlert("Se ha producido un error al registrar usuario")
            }
        }
    }
    private fun showAlert(mensaje: String){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage(mensaje)
        builder.setPositiveButton("Aceptar",null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    private fun checkpass (pass: String){
        if (pass.length <8){
            return
        }
    }
}