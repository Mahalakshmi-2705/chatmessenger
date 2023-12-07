package com.example.chatmessenger.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.chatmessenger.R


import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.auth.FirebaseAuth

class ForgotActivity: AppCompatActivity() {

    private lateinit var resetmail: TextInputLayout
    private lateinit var resetPass: Button

    private lateinit var auth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot)

        resetmail=findViewById(R.id.Resetemail)
        resetPass=findViewById(R.id.buttonResetPassword)

        auth = FirebaseAuth.getInstance()

        resetPass.setOnClickListener {
            val spass = resetmail.editText?.text.toString()
            auth.sendPasswordResetEmail(spass)
                .addOnSuccessListener {
                    Toast.makeText(this, "Please Check your Email", Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener {
                    Toast.makeText(this, it.toString(), Toast.LENGTH_SHORT).show()
                }
        }


    }
}