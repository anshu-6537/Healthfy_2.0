package com.example.healthfy20

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_splash_screen.*

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val bottomanim= AnimationUtils.loadAnimation(this,R.anim.bottom_animation)

        pineaple.startAnimation(bottomanim)
//        val splash_time_out= 5000
        val homeIntent= Intent(this@SplashScreen, WelcomeActivity1::class.java)

//        handler =Handler()
        Handler().postDelayed({
            startActivity(homeIntent)
            finish()
        }, 3000)
    }
}