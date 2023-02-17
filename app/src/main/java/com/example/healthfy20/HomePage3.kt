package com.example.healthfy20

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_home_page3.*

class HomePage3 : AppCompatActivity() {
    companion object {

        const val name = "name_extra"
//        const val heightvalue = "height_extra"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page3)

        val Name = intent.getStringExtra(SignIn.name)
        val heightValue = intent.getStringExtra("heightvalue")
        val weightValue = intent.getStringExtra("weightvalue")
        name.setText(Name)

        val btn_click_back = findViewById<ImageButton>(R.id.back)
        btn_click_back.setOnClickListener {
            val intent = Intent(this, HomePage1::class.java)
            startActivity(intent)
        }


        //Toast.makeText(this,heightValue,Toast.LENGTH_SHORT).show()\

        val btn_click_height = findViewById<Button>(R.id.heightupdate)
        btn_click_height.setOnClickListener {
            val intent = Intent(this, Height::class.java)

            startActivity(intent)
        }
        val btn_click_weight = findViewById<Button>(R.id.weightupdate)
        btn_click_weight.setOnClickListener {
            val intent = Intent(this, Height::class.java)
            startActivity(intent)
        }

        height.setText(heightValue)
        weight.setText(weightValue)

        val heightthis=170
        val weightthis =65
        val btn_click:Button = findViewById(R.id.bmiid)
        btn_click.setOnClickListener {
            val intent = Intent(this, bmi::class.java)
            intent.putExtra("height",heightValue)
            intent.putExtra("weight",weightValue)
            startActivity(intent)

        }
    }
}