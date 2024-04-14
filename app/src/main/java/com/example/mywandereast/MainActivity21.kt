package com.example.mywandereast

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class MainActivity21 : AppCompatActivity() {

    private lateinit var btnB12: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main21)

        btnB12 = findViewById<ImageButton>(R.id.btnBack12)

        btnB12.setOnClickListener {
            val i = Intent (this, MainActivity5::class.java)
            startActivity(i)
        }
    }
}