package com.example.mywandereast

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class MainActivity5 : AppCompatActivity() {

    private lateinit var btnbout: ImageButton
    private lateinit var btnH9: ImageButton
    private lateinit var btnB10: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)

        btnbout =findViewById<ImageButton>(R.id.btnBout)
        btnH9 = findViewById<ImageButton>(R.id.btnHistory9)
        btnB10 = findViewById<ImageButton>(R.id.btnBack10)

        //set function for button
        //var = static variable
        btnH9.setOnClickListener {
            val i = Intent (this, MainActivity12::class.java)
            startActivity(i)
        }
        btnB10.setOnClickListener {
            val i = Intent (this, MainActivity3::class.java)
            startActivity(i)
        }
        btnbout.setOnClickListener {
            val i = Intent (this, MainActivity21::class.java)
            startActivity(i)
        }

    }
}