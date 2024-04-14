package com.example.mywandereast

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class MainActivity14 : AppCompatActivity() {

    private lateinit var btnB14: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main14)

        btnB14 = findViewById<ImageButton>(R.id.btnBack14)

        btnB14.setOnClickListener {
            val i = Intent(this, MainActivity7::class.java)
            startActivity(i)
        }
    }
}