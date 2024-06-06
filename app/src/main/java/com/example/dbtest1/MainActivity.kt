package com.example.dbtest1

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.dbtest1.model.User
import com.example.dbtest1.viewmodel.UserViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var userViewModel: UserViewModel
    private lateinit var builder: AlertDialog.Builder
    private lateinit var dialog: AlertDialog
    private lateinit var age: EditText
    private lateinit var name: EditText
    private lateinit var save: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        userViewModel.getAllUser(this.applicationContext)?.observe(this) {

        }
        var fab = findViewById<FloatingActionButton>(R.id.floatingActionButton)
        fab.setOnClickListener {
            openDialog()
        }
    }

    private fun openDialog() {
        builder = AlertDialog.Builder(this)
        val itemView: View = LayoutInflater.from(applicationContext).inflate(R.layout.dialog, null)
        dialog = builder.create()
        dialog.setView(itemView)
        name = itemView.findViewById(R.id.name)
        age = itemView.findViewById(R.id.age)
        save = itemView.findViewById(R.id.save)
        save.setOnClickListener {
            saveDataIntoRoomDatabase()
        }
        dialog.show()
    }

    private fun saveDataIntoRoomDatabase() {
        val getName = name.text.toString().trim()
        val getAge = age.text.toString().trim()

        if(!TextUtils.isEmpty(getName) && !TextUtils.isEmpty(getAge)){

        }else{
            Toast.makeText(applicationContext,"Please fill all the fields",Toast.LENGTH_SHORT)
            dialog.dismiss()
        }
    }
}