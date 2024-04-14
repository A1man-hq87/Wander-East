package com.example.mywandereast

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    //INITIALIZED ALL COMPONENT
    //var = variable
    private lateinit var btnS : Button
    private lateinit var btnRr : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //define button references
        btnS = findViewById<Button>(R.id.btnSkip)
        btnRr = findViewById<Button>(R.id.btnRegister)

        //set function for button
        //var = static variable
        btnS.setOnClickListener {
            val i = Intent (this, MainActivity2::class.java)
            startActivity(i)
        }
        btnRr.setOnClickListener {
            val i = Intent (this, MainActivity9::class.java)
            startActivity(i)
        }

    }
}