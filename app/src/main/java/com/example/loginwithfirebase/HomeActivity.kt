package com.example.loginwithfirebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val bundle = intent.extras
        val name = bundle?.getString("name")
        val email = bundle?.getString("email")
        homeSetup(name?:"",email?:"")
    }
    private fun  homeSetup(name: String, email: String){
        title= "Inicio"
        tvName.text=name
        tvEmail.text=email
        btLogOut.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            onBackPressed()
        }
    }
}