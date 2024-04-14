package com.example.mywandereast

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class MainActivity4 : AppCompatActivity() {
    //INITIALIZED ALL COMPONENT
    //var = variable
    private lateinit var btnP3 : ImageButton
    private lateinit var btnP4 : ImageButton
    private lateinit var btnB3: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        //declare all component with reference
        btnP3 = findViewById<ImageButton>(R.id.btnPlace5)
        btnP4 = findViewById<ImageButton>(R.id.btnPlace6)
        btnB3 = findViewById<ImageButton>(R.id.btnBack3)

        //set function for button
        //var = static variable
        btnP3.setOnClickListener {
            val i = Intent (this, MainActivity7::class.java)
            startActivity(i)
        }
        btnB3.setOnClickListener {
            val i = Intent (this, MainActivity2::class.java)
            startActivity(i)
        }

        btnP4.setOnClickListener {
            val i = Intent (this, MainActivity8::class.java)
            startActivity(i)
        }
    }
}