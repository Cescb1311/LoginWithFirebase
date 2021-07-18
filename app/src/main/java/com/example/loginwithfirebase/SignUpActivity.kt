package com.example.loginwithfirebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        setupRegistro()
    }
    private fun setupRegistro(){
        title ="Registrarse"
        btCreateAccount.setOnClickListener {
            if (etEmailRegister.text.isNotEmpty() && etNameRegister.text.isNotEmpty() && etPasswordRegister.text.isNotEmpty()){
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(etEmailRegister.text.toString(),
                    etPasswordRegister.text.toString()).addOnCompleteListener {
                    if(it.isSuccessful){
                        showHome(etNameRegister.text.toString(), it.result?.user?.email.toString())
                    }else{
                        Toast.makeText(this,"Se ha producido un error autenticando al usuario",Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
        btReturn.setOnClickListener {
            startActivity(Intent(this,AuthActivity::class.java))
        }
    }
    fun showHome(name: String, email:String){
        val homeIntent = Intent(this,HomeActivity::class.java).apply {
            putExtra("name",name)
            putExtra("email",email)
        }
        startActivity(homeIntent)
    }
}