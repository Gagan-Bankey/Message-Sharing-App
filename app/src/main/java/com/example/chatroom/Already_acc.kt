package com.example.chatroom

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.acc_already.*

class Already_acc(): AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.acc_already)

        log_button.setOnClickListener addOnCompleteListener@{
            var user1 = already_emailtext.text.toString()
            var pass2= already_passtest.text.toString()
            if (user1.isEmpty() || pass2.isEmpty()) {
                Toast.makeText(this, "please enter email and password first", Toast.LENGTH_SHORT).show()
                return@addOnCompleteListener }
            Log.i("Already_acc","email $user1")
            Log.i("Already_acc","pass $pass2")
            FirebaseAuth.getInstance().signInWithEmailAndPassword(user1,pass2)
                .addOnCompleteListener {
                  if(!it.isSuccessful)
                  {  return@addOnCompleteListener
                  }
                    Toast.makeText(this, "sucessfully signed in", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this,page_1 ::class.java))
                }


                .addOnFailureListener {
                    Log.d("mainia", " ${it.message}")
                    Toast.makeText(this, "${it.message}", Toast.LENGTH_SHORT).show()
                }
        }
        back_regtext.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }
    }
}
