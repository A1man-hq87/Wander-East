package com.example.mywandereast

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity17 : AppCompatActivity() {
    //declare to connect with databases
    private lateinit var dbRef: DatabaseReference

    //initial all component
    private lateinit var btnS2: Button
    private lateinit var btnB: ImageButton
    private lateinit var email2: EditText
    private lateinit var feedback: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main17)

        //declare all component with reference
        btnS2 = findViewById<Button>(R.id.btnSubmit2)
        email2 = findViewById(R.id.eTEmail2)
        feedback = findViewById(R.id.eTfeedBack)
        btnB = findViewById<ImageButton>(R.id.btnBack)

        //popup message when click button add record
        Toast.makeText(this, "Submit", Toast.LENGTH_LONG).show()

        btnB.setOnClickListener {
            val i = Intent (this, MainActivity2::class.java)
            startActivity(i)
        }

        btnS2.setOnClickListener {
            //call function Employee data
            //parameter - change the input data to string
            saveData(
                email2.text.toString(),
                feedback.text.toString()
            )

        }
    }

        //create function to save data
        //this function send data to firebase

        //e = email
        //f = feedback

        private fun saveData(e: String, f: String) {
            dbRef = FirebaseDatabase.getInstance().getReference("User Feedback")

            //produce auto generate customer
            //push the data to database
            //!! refer must had record or id cannot null
            val userId = dbRef.push().key!!

            //user is a object
            //push the data to database
            //customer id will be autogenerate
            //data will output by users
            //input name, password, phone, email
            val em = feedback(e,userId, f)

            //setting to push data inside the table
            dbRef.child(userId).setValue(em)

                //success record it will popup success
                .addOnCompleteListener {
                    Toast.makeText(this, "perfectly success", Toast.LENGTH_LONG).show()
                    //fail to record
                }.addOnFailureListener {
                    Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG).show()
                }

            //declare variable i to connect to the next page activity
            val i = Intent(this, MainActivity2::class.java)
            startActivity(i)

        }
}