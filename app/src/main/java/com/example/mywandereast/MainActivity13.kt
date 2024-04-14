package com.example.mywandereast

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class MainActivity13 : AppCompatActivity() {

    private lateinit var btnB5: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main13)

        //declare references
        btnB5 = findViewById<ImageButton>(R.id.btnBack5)

        //function for btn back
        btnB5.setOnClickListener {
            val i = Intent(this, MainActivity8::class.java)
            startActivity(i)
        }
    }
}