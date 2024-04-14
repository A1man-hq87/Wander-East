package com.example.mywandereast

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class MainActivity19 : AppCompatActivity() {

    private lateinit var btnB6: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main19)

        //declare reference
        btnB6 = findViewById<ImageButton>(R.id.btnBack6)

        //function
        btnB6.setOnClickListener {
            val i = Intent(this, MainActivity8::class.java)
            startActivity(i)
        }
    }
}