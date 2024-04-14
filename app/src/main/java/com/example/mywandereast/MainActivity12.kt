package com.example.mywandereast

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class MainActivity12 : AppCompatActivity() {

    private lateinit var btnB11: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main12)

        btnB11 = findViewById<ImageButton>(R.id.btnBack11)

        btnB11.setOnClickListener {
            val i = Intent (this, MainActivity5::class.java)
            startActivity(i)
        }
    }
}