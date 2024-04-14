package com.example.mywandereast

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class MainActivity8 : AppCompatActivity() {

    private lateinit var btnIbout: ImageButton
    private lateinit var btnH: ImageButton
    private lateinit var btnB4: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main8)

        btnIbout = findViewById<ImageButton>(R.id.imgbtnAbout)
        btnH = findViewById<ImageButton>(R.id.btnHistory)
        btnB4 = findViewById<ImageButton>(R.id.btnBack4)

        //set function for button
        //var = static variable
        btnIbout.setOnClickListener {
            val i = Intent(this, MainActivity13::class.java)
            startActivity(i)
        }
        btnH.setOnClickListener {
            val i = Intent(this, MainActivity19::class.java)
            startActivity(i)
        }
        btnB4.setOnClickListener {
            val i = Intent(this, MainActivity4::class.java)
            startActivity(i)
        }
    }
}