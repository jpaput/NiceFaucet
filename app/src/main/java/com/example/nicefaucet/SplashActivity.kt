package com.example.nicefaucet

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.TextView
import android.widget.VideoView

class SplashActivity : AppCompatActivity() {

    private var userIsSignedIn = false
    //animation value
    private val animDuration = 1000 //time in ms




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setTheme(R.style.Theme_NiceFaucet)
        setContentView(R.layout.activity_splash)
        // This is used to hide the status bar and make
        // the splash screen as a full screen activity.

    }

    override fun onResume() {
        super.onResume()
        val videoView = findViewById<VideoView>(R.id.videoView)
        val textView: TextView = findViewById(R.id.logo)
        animDuration
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
