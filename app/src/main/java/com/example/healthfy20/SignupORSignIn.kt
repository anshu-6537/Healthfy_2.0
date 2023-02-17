package com.example.healthfy20

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SignupORSignIn : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup_orsign_in)

        val btn_click_next = findViewById<Button>(R.id.signin)
        btn_click_next.setOnClickListener {
            val intent = Intent(this, SignIn::class.java)
            startActivity(intent)

        }
        val btn_click_skip = findViewById<Button>(R.id.signup)
        btn_click_skip.setOnClickListener {
            val intent = Intent(this, SignUp::class.java)
            startActivity(intent)
        }
        val btn_click_signed = findViewById<TextView>(R.id.alreadysigned)
        btn_click_signed.setOnClickListener {
            val intent = Intent(this, SignIn::class.java)
            startActivity(intent)
        }
    }
}