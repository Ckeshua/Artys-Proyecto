package com.UnabEduardo.proyectotitulo

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.database.Cursor
import android.net.Uri
import android.os.Bundle
import android.provider.OpenableColumns
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
const val REQ_PICK_FILE = 1
class MainActivity_gallery : AppCompatActivity() {
    val positiveButtonClick = { dialog: DialogInterface, which: Int ->
        Toast.makeText(
            applicationContext,
            android.R.string.yes, Toast.LENGTH_SHORT
        ).show()

        // Request code for selecting a PDF document.
/*
        val PICK_PDF_FILE = 2
        fun openFile(pickerInitialUri: Uri) {
            val intent = Intent(Intent.ACTION_OPEN_DOCUMENT).apply {
                addCategory(Intent.CATEGORY_OPENABLE)
        /*        type = "*/glb"
                setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
            }
            startActivityForResult(intent, REQ_PICK_FILE)
        }*/

        /*val negativeButtonClick = { dialog: DialogInterface, which: Int ->
            Toast.makeText(
                applicationContext,
                android.R.string.no, Toast.LENGTH_SHORT
            ).show()
        }*/

    }
    /*private fun copyFiletoInternal(FileUri: Uri): String {
        val TheCursor: Cursor? = getContentResolver().query(
            FileUri,
            arrayOf<String>(OpenableColumns.DISPLAY_NAME, OpenableColumns.SIZE),null,null,null
        )
        TheCursor?.moveToFirst()
        val displayName: String? = TheCursor?.getString(TheCursor.getColumnIndex(OpenableColumns.DISPLAY_NAME));
        long size= TheCursor.getLong(TheCursor?.getColumnIndex(OpenableColumns.SIZE));

    }



    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode== RESULT_OK && requestCode== REQ_PICK_FILE){
            if (data!=null && data.getData()!= null){
                var newFilePath=copyFiletoInternal(data.data)
            }
        }
    }
*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery)


    }

        fun withEditText(view: View) {
        val builder = AlertDialog.Builder(this)
        val inflater = layoutInflater
        builder.setTitle("Nombre del proyecto")
        val dialogLayout = inflater.inflate(R.layout.alerdialog_nombremodelo, null)
        val editText  = dialogLayout.findViewById<EditText>(R.id.editText)
        builder.setView(dialogLayout)
        builder.setPositiveButton("OK") { dialogInterface, i -> Toast.makeText(applicationContext, "EditText is " + editText.text.toString(), Toast.LENGTH_SHORT).show();

        startActivity(Intent(this,MainActivity_3dmodelling::class.java).putExtra("key",i))
        }
        builder.show()
    }

}