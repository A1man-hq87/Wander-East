package com.example.mywandereast

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class MainActivity6 : AppCompatActivity() {

    private lateinit var btnA : ImageButton
    private lateinit var btnH6 : ImageButton
    private lateinit var btnB7: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main6)

        btnA = findViewById<ImageButton>(R.id.btnAbout2)
        btnH6 = findViewById<ImageButton>(R.id.btnHistory6)
        btnB7 = findViewById<ImageButton>(R.id.btnBack7)

        //set function for button
        //var = static variable
        btnA.setOnClickListener {
            val i = Intent (this, MainActivity11::class.java)
            startActivity(i)
        }
        btnH6.setOnClickListener {
            val i = Intent (this, MainActivity20::class.java)
            startActivity(i)
        }
        btnB7.setOnClickListener {
            val i = Intent (this, MainActivity3::class.java)
            startActivity(i)
        }
    }
}