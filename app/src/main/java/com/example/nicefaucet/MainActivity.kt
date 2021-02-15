package com.example.nicefaucet


import android.content.Intent
import android.os.Bundle
import android.os.Handler

import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.HandlerCompat.postDelayed
import com.google.firebase.auth.FirebaseAuth
import java.util.logging.Handler as LoggingHandler


@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setTheme(R.style.Theme_NiceFaucet)
        setContentView(R.layout.activity_main)


        mAuth = FirebaseAuth.getInstance()
        val user = mAuth.currentUser


        //if the user is not authenticated, send him to SignInActivity to authenticate first
        //else send him to the dashboard
        Handler().postDelayed( {
            if (user !=null){
                var dashboardIntent = Intent (this, DashBoardFragment ::class.java)
                startActivity(dashboardIntent)
            }else{
                val signIntent = Intent(this, SignInActivity::class.java)
                startActivity(signIntent)
            }
        }, 2000)
    }
}

