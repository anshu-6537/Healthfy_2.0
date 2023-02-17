package com.example.healthfy20

import kotlinx.android.synthetic.main.activity_bmi.*
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity



class bmi : AppCompatActivity() {

    companion object {


    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmi)
        val Height = intent.getStringExtra("height")
        val Weight = intent.getStringExtra("weight")
        val heightvalue = Height?.toDouble()
        val weightvalue = Weight?.toDouble()

        //Toast.makeText(this, heightvalue.toString(), Toast.LENGTH_SHORT).show()
        var bmivalue= weightvalue?.div((heightvalue?.times(heightvalue)!!))?.times(10000)


        if (bmivalue != null) {
            bmivalue = Math.round(bmivalue * 100.0) / 100.0
        }
        //Toast.makeText(this, bmivalue.toString(),Toast.LENGTH_SHORT).show()
        bmi.text= bmivalue.toString()

        
        val btn_click_next = findViewById<Button>(R.id.generate)
        btn_click_next.setOnClickListener {
            val intent = Intent(this, HomePage2::class.java)
            intent.putExtra(HomePage2.Bmi , bmivalue.toString())
            startActivity(intent)
        }
        val btn_click_back = findViewById<ImageButton>(R.id.back)
        btn_click_back.setOnClickListener {
            val intent = Intent(this, HomePage3::class.java)
            startActivity(intent)
        }
    }
}