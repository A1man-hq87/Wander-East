package com.example.mywandereast

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity10 : AppCompatActivity() {

    //declare to connect with databases
    private lateinit var dbRef: DatabaseReference

    //initial all component
    private lateinit var submit: Button
    private lateinit var name: EditText
    private lateinit var password: EditText
    private lateinit var phone: EditText
    private lateinit var email: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main10)

        //declare all component with references
        submit = findViewById<Button>(R.id.btnSubmit)
        name = findViewById(R.id.eTName)
        password = findViewById(R.id.eTpassword)
        phone = findViewById(R.id.eTphone)
        email = findViewById(R.id.eTEmail)

        //popup message when click button add record
        Toast.makeText(this, "Submit", Toast.LENGTH_LONG).show()

        submit.setOnClickListener {
            //call function Employee data
            //parameter - change the input data to string
            saveData(
                email.text.toString(), name.text.toString(),
                password.text.toString(), phone.text.toString()
            )
        }
    }

    //create function to save data
    //this function send data to firebase
    //n = name
    //p = password
    //e = email
    //t = phone
    private fun saveData(e: String, n: String, p: String, t: String) {
        //get instances
        //customers refer to table
        //customer can change to other name
        //link database name customer
        dbRef = FirebaseDatabase.getInstance().getReference("Traveler")

        //produce auto generate customer
        //push the data to database
        //!! refer must had record or id cannot null
        val userId = dbRef.push().key!!

        //user is a object
        //push the data to database
        //customer id will be autogenerate
        //data will output by users
        //input name, password, phone, email
        val em = Traveler(e, userId, n, p, t)

        //setting to push data inside the table
        dbRef.child(userId).setValue(em)

            //success record it will popup success
            .addOnCompleteListener {
                Toast.makeText(this, "success", Toast.LENGTH_LONG).show()
                //fail to record
            }.addOnFailureListener {
                Toast.makeText(this, "Failure", Toast.LENGTH_LONG).show()
            }

        //declare variable i to connect to the next page activity
        val i = Intent(this, MainActivity9::class.java)
        startActivity(i)
    }
}