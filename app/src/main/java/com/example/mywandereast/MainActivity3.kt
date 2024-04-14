package com.example.mywandereast

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class MainActivity3 : AppCompatActivity() {
    //INITIALIZED ALL COMPONENT
    //var = variable
    private lateinit var btnP1 : ImageButton
    private lateinit var btnP2 : ImageButton
    private lateinit var btnB2: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        //declare all component with reference
        btnP1 = findViewById<ImageButton>(R.id.btnPlace1)
        btnP2 = findViewById<ImageButton>(R.id.btnPlace2)
        btnB2 = findViewById<ImageButton>(R.id.btnBack2)

        //set function for button
        //var = static variable
        btnP1.setOnClickListener {
            val i = Intent (this, MainActivity5::class.java)
            startActivity(i)
        }
        btnB2.setOnClickListener {
            val i = Intent (this, MainActivity2::class.java)
            startActivity(i)
        }

        btnP2.setOnClickListener {
            val i = Intent (this, MainActivity6::class.java)
            startActivity(i)
        }
    }
}