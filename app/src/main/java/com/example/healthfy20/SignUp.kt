package com.example.healthfy20

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.*
import androidx.datastore.core.DataStore
import com.example.healthfy20.databinding.ActivitySignUpBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.firebase.auth.FirebaseAuth
import java.util.prefs.Preferences

class SignUp : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding
    private lateinit var firebaseAuth: FirebaseAuth


    //Radio button
    private var radioSexGroup: RadioGroup? = null
    private var radioSexButton: RadioButton? = null
    private var btnDisplay: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.next.setOnClickListener {
            val name = binding.entername.text.toString()
            val email = binding.entermail.text.toString()
            val pass = binding.enterpass.text.toString()
            val confrmPass = binding.entercnfrmpass.text.toString()




            if (email.isNotEmpty() && pass.isNotEmpty() && confrmPass.isNotEmpty()) {
                if (pass == confrmPass) {
                    firebaseAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener {
                        if (it.isSuccessful) {
                            val intent = Intent(this, SignIn::class.java)
                            intent.putExtra(SignIn.name, name)
                            startActivity(intent)
                        } else {
                            Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                        }
                    }
                } else {
                    Toast.makeText(this, "Password doesnt matches", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Empty fields not allowed", Toast.LENGTH_SHORT).show()
            }
        }
    }

}
//        val btnShow = findViewById<Button>(R.id.next)
//        btnShow.setOnClickListener {
//            val view: View = layoutInflater.inflate(R.layout.activity_bottom_sheet, null)
//            val dialog = BottomSheetDialog(this)
//            dialog.setContentView(view)
//            dialog.show()
//            }
//
//            val btn_click_back = findViewById<ImageButton>(R.id.back)
//            btn_click_back.setOnClickListener {
//                val intent = Intent(this, SignupORSignIn::class.java)
//                startActivity(intent)
//
//            }
//
//        }
//    }

//        fun addListenerOnButton() {
//            radioSexGroup = findViewById<View>(android.R.id.radioSex) as RadioGroup
//            btnDisplay = findViewById<View>(android.R.id.btnDisplay) as Button
//            btnDisplay!!.setOnClickListener(object : View.OnClickListener {
//                override fun onClick(v: View?) {
//// get selected radio button from radioGroup
//                    val selectedId = radioSexGroup!!.checkedRadioButtonId
//                    // find the radiobutton by returned id
//                    radioSexButton = findViewById<View>(selectedId) as RadioButton
//                    Toast.makeText(this@SignUp, radioSexButton!!.text, Toast.LENGTH_SHORT)
//                        .show()
//                }
//            })
//        }