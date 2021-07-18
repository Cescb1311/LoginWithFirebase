package com.example.loginwithfirebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_auth.*
import kotlinx.android.synthetic.main.activity_sign_up.*

class AuthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        setup()
    }

    private fun setup(){
        title="Autenticación"
        btSignIn.setOnClickListener {
            if (etEmailRegister.text.isNotEmpty() && etNameRegister.text.isNotEmpty() && etPasswordRegister.text.isNotEmpty()){
                FirebaseAuth.getInstance().signInWithEmailAndPassword(etEmailRegister.text.toString(),
                    etPasswordRegister.text.toString()).addOnCompleteListener {
                    if(it.isSuccessful){
                        startActivity(Intent(this,HomeActivity::class.java))

                    }else{
                        Toast.makeText(this,"Se ha producido un error autenticando al usuario",
                            Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
        btSignUp.setOnClickListener {
            startActivity(Intent(this,SignUpActivity::class.java))
        }

    }


}