package com.example.mywandereast

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class MainActivity11 : AppCompatActivity() {

    private lateinit var btnB9: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main11)

        btnB9 = findViewById<ImageButton>(R.id.btnBack9)

        btnB9.setOnClickListener {
            val i = Intent (this, MainActivity6::class.java)
            startActivity(i)
        }
    }
}