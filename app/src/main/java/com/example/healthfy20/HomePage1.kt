package com.example.healthfy20

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_home_page1.*

class HomePage1 : AppCompatActivity() {
    companion object {

        const val name = "name_extra"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page1)

        val Name = intent.getStringExtra(SignIn.name)
        namebox.setText(Name)
        val btn_click_diet = findViewById<ImageButton>(R.id.dietbutton)
        btn_click_diet.setOnClickListener {
            Toast.makeText(this,"First setup your Profile and then click BMI ",Toast.LENGTH_LONG).show()

        }

        val btn_click_profile = findViewById<ImageButton>(R.id.profilebutton)
        btn_click_profile.setOnClickListener {
            val intent = Intent(this, HomePage3::class.java)
            intent.putExtra(HomePage3.name , Name)
            startActivity(intent)

        }
    }
}