package com.example.mywandereast

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class MainActivity20 : AppCompatActivity() {

    private lateinit var btnB8: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main20)

        btnB8 = findViewById<ImageButton>(R.id.btnBack8)

        btnB8.setOnClickListener {
            val i = Intent (this, MainActivity6::class.java)
            startActivity(i)
        }
    }
}