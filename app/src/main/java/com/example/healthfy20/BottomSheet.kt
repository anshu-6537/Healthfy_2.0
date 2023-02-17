package com.example.healthfy20

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class BottomSheet : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_sheet)

        Toast.makeText(this,"bottomclass", Toast.LENGTH_SHORT).show()
        val btn_click_login = findViewById<Button>(R.id.login)
        btn_click_login.setOnClickListener {
            val intent = Intent(this, SignIn::class.java)
            startActivity(intent)

        }
    }
}