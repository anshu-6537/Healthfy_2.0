package com.example.healthfy20

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import com.example.healthfy20.databinding.ActivitySignInBinding

import com.google.firebase.auth.FirebaseAuth


class SignIn : AppCompatActivity() {
    companion object {

        const val name = "name_extra"
    }

    private lateinit var  binding: ActivitySignInBinding
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        val Name = intent.getStringExtra(name)

        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth=FirebaseAuth.getInstance()
        binding.alreadysigned.setOnClickListener {
            val intent = Intent(this, SignUp::class.java)
            startActivity(intent)
        }

        binding.button.setOnClickListener {
            val email = binding.emailEt.text.toString()
            val pass = binding.passET.text.toString()



            if (email.isNotEmpty() && pass.isNotEmpty()) {

                firebaseAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener {
                    if (it.isSuccessful) {
                        val intent = Intent(this, HomePage1::class.java)
                        intent.putExtra(HomePage1.name , Name)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }


        val btn_click_back = findViewById<ImageButton>(R.id.back)
        btn_click_back.setOnClickListener {
            val intent = Intent(this, SignupORSignIn::class.java)
            startActivity(intent)
        }
    }
}