package com.UnabEduardo.proyectotitulo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth

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
                    findViewById<EditText>(R.id.InputPassw).text.isNotEmpty()
                ) {
                    FirebaseAuth.getInstance()
                        .createUserWithEmailAndPassword(
                            InputEmail.text.toString(),
                            InputPassw.text.toString()
                        ).addOnCompleteListener {
                            if (it.isSuccessful) {
                                startActivity(myintent)
                            } else {
                                showAlert(1)
                            }
                        }
                }
            }
            else{
                showAlert(2)
            }
        }
    }
    private fun showAlert(number: Int){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        if(number==1) {
            builder.setMessage("Se ha producido un error al registrar usuario")
        }
        else if(number==2){
            builder.setMessage("Es necesario aceptar los terminos y condiciones")
        }
        builder.setPositiveButton("Aceptar",null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

}