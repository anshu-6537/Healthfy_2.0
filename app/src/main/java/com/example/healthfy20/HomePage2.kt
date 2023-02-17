package com.example.healthfy20

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import android.widget.ImageButton
import android.widget.Toast
import com.example.healthfy20.databinding.ActivityHomePage2Binding
import kotlinx.android.synthetic.main.activity_home_page2.*

class HomePage2 : AppCompatActivity() {

    companion object {

        const val Bmi = "BMI_EXTRA"
    }

    private lateinit var binding: ActivityHomePage2Binding
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomePage2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        var bmiVALUE = intent.getStringExtra(Bmi)

        val temp = bmiVALUE?.toDouble()
        val bmiV = temp?.toInt()
        if (bmiV != null) {
            Toast.makeText(this, bmiV.toString(), Toast.LENGTH_SHORT).show()
        }
        bmiVALUE = bmiV.toString()
//        Toast.makeText(this, bmiVALUE.toString(), Toast.LENGTH_LONG).show()
//        val userName : String = binding.toString()
        readdata(bmiVALUE)

        val btn_click_back = findViewById<ImageButton>(R.id.back)
        btn_click_back.setOnClickListener {
            val intent = Intent(this, HomePage1::class.java)
            startActivity(intent)

        }
    }

    private fun readdata(bmiVALUE: String) {

        database = FirebaseDatabase.getInstance().getReference("BMI")
        database.child(bmiVALUE).get().addOnSuccessListener {

            if (it.exists()) {
                //reading data
                gif.visibility = View.INVISIBLE
                val breakfast = it.child("Breakfast").value
                val midmeal = it.child("MidMeal").value
                val lunch = it.child("Lunch").value
                val snacks = it.child("Snacks").value
                val dinner = it.child("Dinner").value

                Toast.makeText(this, "Successfully read", Toast.LENGTH_SHORT).show()
                //setting textView
                //gif.visibility = View.INVISIBLE
                binding.breakfast.text = breakfast.toString()
                binding.midmeal.text = midmeal.toString()
                binding.lunch.text = lunch.toString()
                binding.snack.text = snacks.toString()
                binding.dinner.text = dinner.toString()


            } else {
                Toast.makeText(this, "value doesn't exists", Toast.LENGTH_SHORT).show()


            }
        }.addOnFailureListener {

            Toast.makeText(this, "data can't be read", Toast.LENGTH_SHORT).show()
        }
    }
}