package com.example.mywandereast

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MainActivity9 : AppCompatActivity() {

    //initialized the component
    private lateinit var btnRes: Button
    private lateinit var btnLog: Button
    private lateinit var email: EditText
    private lateinit var password: EditText

    //declare the firebase
    private lateinit var firebaseDatabase: FirebaseDatabase
    private lateinit var databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main9)

        //declare component
        btnRes = findViewById<Button>(R.id.signUp)
        btnLog = findViewById<Button>(R.id.btnLogin)
        email = findViewById(R.id.emailLogin)
        password = findViewById(R.id.passwordLogin)

        firebaseDatabase = FirebaseDatabase.getInstance()
        databaseReference = firebaseDatabase.reference.child("Traveler")

        //function button register to activity mainActivity2
        btnRes.setOnClickListener {
            val i = Intent(this, MainActivity10::class.java)
            startActivity(i)
        }

        //btn Login sett
        btnLog.setOnClickListener {
            val email = email.text.toString()
            val password = password.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                logIn(email, password)
            } else {
                Toast.makeText(
                    this@MainActivity9,
                    "All fields are mandatory", Toast.LENGTH_LONG
                ).show()
            }
        }

    }

    //create the function login
    //this function read data to firebase
    //p = password
    //e = email
    private fun logIn(email: String, password: String) {
        databaseReference.orderByChild("userEmail").equalTo(email)
            .addListenerForSingleValueEvent(object :
                ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    if (dataSnapshot.exists()) {
                        for (custSnapshot: DataSnapshot in dataSnapshot.children) {
                            val model = custSnapshot.getValue(Traveler::class.java)

                            if (model != null && model.userPassword == password) {
                                Toast.makeText(
                                    this@MainActivity9,
                                    "Login Successful",
                                    Toast.LENGTH_LONG
                                )
                                    .show()
                                startActivity(
                                    Intent(
                                        this@MainActivity9,
                                        MainActivity2::class.java
                                    )
                                )
                                finish()
                                return
                            }
                        }
                    }
                    Toast.makeText(this@MainActivity9, "Login Failed", Toast.LENGTH_LONG).show()
                }

                override fun onCancelled(databaseError: DatabaseError) {
                    Toast.makeText(
                        this@MainActivity9,
                        "Database error: ${databaseError.message}",
                        Toast.LENGTH_LONG
                    ).show()
                }

            })
    }
}
