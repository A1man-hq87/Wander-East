package com.example.mywandereast

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.widget.Toolbar

class MainActivity2 : AppCompatActivity() {

    //INITIALIZED ALL COMPONENT
    //var = variable
    private lateinit var btnSh : ImageButton
    private lateinit var btnSk : ImageButton
    private lateinit var btnMap : ImageButton
    private lateinit var btnT : ImageButton
    private lateinit var btnF : ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        //references the comment
        btnSh = findViewById<ImageButton>(R.id.btnSabah)
        btnSk = findViewById<ImageButton>(R.id.btnSarawak)
        btnMap = findViewById<ImageButton>(R.id.btnMap)
        btnT = findViewById<ImageButton>(R.id.btnTravelTips)
        btnF = findViewById<ImageButton>(R.id.btnFeedback)

        //set function for button
        //var = static variable
        //button Sabah page
        btnSh.setOnClickListener {
            val i = Intent (this, MainActivity3::class.java)
            startActivity(i)
        }
        //Feedback page
        btnF.setOnClickListener {
            val i = Intent (this, MainActivity17::class.java)
            startActivity(i)
        }
        //button Sarawak page
        btnSk.setOnClickListener {
            val i = Intent (this, MainActivity4::class.java)
            startActivity(i)
        }
        //button map go to google map
        btnMap.setOnClickListener {
            val i = Intent (this, MainActivity16::class.java)
            startActivity(i)
        }
        //btn Tips function
        btnT.setOnClickListener {
            val i = Intent(this, MainActivity15::class.java)
            startActivity(i)
        }

    }
}