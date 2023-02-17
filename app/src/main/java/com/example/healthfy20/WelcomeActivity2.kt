package com.example.healthfy20

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class WelcomeActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome2)

        val btn_click_next = findViewById<Button>(R.id.skip)
        btn_click_next.setOnClickListener {
            val intent = Intent(this, SignupORSignIn::class.java)
            startActivity(intent)
        }
        val btn_click_skip = findViewById<Button>(R.id.getstarted)
        btn_click_skip.setOnClickListener {
            val intent = Intent(this, SignupORSignIn::class.java)
            startActivity(intent)
        }
    }
}