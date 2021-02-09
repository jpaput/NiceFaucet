package com.example.nicefaucet

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.AnimationSet
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import android.widget.VideoView
import androidx.core.graphics.rotationMatrix

class SplashActivity : AppCompatActivity() {

    private var userIsSignedIn = false


    lateinit var fadeIn:Animation
  //  lateinit var fadeOut:Animation


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setTheme(R.style.Theme_NiceFaucet)
        setContentView(R.layout.activity_splash)


        val imageView = findViewById<ImageView>(R.id.logo)
        //Animations
        fadeIn = AnimationUtils.loadAnimation(this,R.anim.fade_in)
    //    fadeOut = AnimationUtils.loadAnimation(this,R.anim.fade_out)


        imageView.animation = fadeIn
      //  imageView.animation = fadeOut
    }


    override fun onResume() {
        super.onResume()
        val videoView = findViewById<VideoView>(R.id.videoView)



        // set the absolute path of the video file which is going to be played
        videoView.setVideoURI(Uri.parse("android.resource://" + packageName + "/" + R.raw.animation1))

        videoView.requestFocus()

        // starting the video
        videoView.start()

        videoView.setOnCompletionListener {
            if(userIsSignedIn) {
                val intent = Intent(this, MainActivity::class.java).apply {
                    finish()
                }
                startActivity(intent)
            } else {
                val intent = Intent(this, SignInActivity::class.java).apply {
                    finish()
                }
                startActivity(intent)
            }
        }
    }
}
