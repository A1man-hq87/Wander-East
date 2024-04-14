package com.example.mywandereast

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class MainActivity7 : AppCompatActivity() {

    private lateinit var btnA4 : ImageButton
    private lateinit var btnB13: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main7)

        btnA4 = findViewById<ImageButton>(R.id.btnAbout4)
        btnB13 = findViewById<ImageButton>(R.id.btnBack13)

        //set function for button
        //var = static variable
        btnA4.setOnClickListener {
            val i = Intent(this, MainActivity14::class.java)
            startActivity(i)
        }
        btnB13.setOnClickListener {
            val i = Intent(this, MainActivity4::class.java)
            startActivity(i)
        }
    }
}