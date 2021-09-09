package com.example.chatroom

import android.app.Activity
import android.content.Intent
import android.graphics.drawable.BitmapDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.provider.MediaStore
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity() : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       FirebaseAuth.getInstance()
        
        var email_e = email_edittext_reg.text.toString()
        var pass_word = password_edittext_reg.text.toString()
        var user_name = username_edittext_reg.text.toString()

        reg_button_reg.setOnClickListener {
            email_e = email_edittext_reg.text.toString()
            pass_word = password_edittext_reg.text.toString()
            user_name = username_edittext_reg.text.toString()
            if(email_e.isEmpty() ||pass_word.isEmpty()||user_name.isEmpty() )
            {
                Toast.makeText(this,"please enter values first",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            
            Log.d("MainActivity", "email is $email_e")
            Log.d("MainActivity", " password $pass_word")
            Log.d("MainActivity","username $user_name")

            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email_e,pass_word)
                .addOnCompleteListener {
                    if(!it.isSuccessful)return@addOnCompleteListener
                     Log.d("mainia","successfully created user with uid ${it.result?.user?.uid}")
                    Toast.makeText(this, "signed up successfully", Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener {
                    Log.d("mainia","failed to create user:  ${it.message} ")
                    Toast.makeText(this, "something went wrong ${it.message}", Toast.LENGTH_SHORT).show()
                }
        }

        already_textview.setOnClickListener {
            startActivity(Intent(this,Already_acc::class.java))
        }



        }

    }
