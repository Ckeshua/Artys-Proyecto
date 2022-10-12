package com.UnabEduardo.proyectotitulo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.ImageButton
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val user = FirebaseAuth.getInstance().currentUser
        if (user != null) {
            val textView: TextView = findViewById(R.id.textViewemail)
            textView.text = user.email


        }
        val button: ImageButton = findViewById(R.id.aGallerybutton)
        button.setOnClickListener(){
            val myintent = Intent(this,MainActivity_gallery::class.java)
            startActivity(myintent)
        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val user= FirebaseAuth.getInstance().currentUser
        val inflater: MenuInflater = menuInflater
        if (user!= null){
            inflater.inflate(R.menu.actionbar_logout, menu)
        }
        else{
            inflater.inflate(R.menu.actionbar1, menu)
        }
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        return when (item.itemId) {
            R.id.login_button -> {
                val myintent = Intent(this,Activity_auth::class.java)
                startActivity(myintent)
                true
            }
            R.id.logout_button -> {
                FirebaseAuth.getInstance().signOut()
                val myintent = Intent(this,MainActivity::class.java)
                startActivity(myintent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}