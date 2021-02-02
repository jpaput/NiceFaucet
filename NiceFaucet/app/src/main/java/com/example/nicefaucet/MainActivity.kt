package com.example.nicefaucet

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import com.example.nicefaucet.R.id.viewVideo
import com.google.firebase.auth.FirebaseAuth
import java.lang.Thread.sleep


class MainActivity : AppCompatActivity() {

    private var mAuth: FirebaseAuth? = null

    //animation value
    private val animDuration = 3000 //time in ms

    //declaring  a null variable for VideoView
    var videoView: VideoView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setTheme(R.style.Theme_NiceFaucet)
        setContentView(R.layout.activity_main)

        mAuth = FirebaseAuth.getInstance()

        // assigning id of VideoView from
        // activity_main.xml layout file
        videoView = findViewById<View>(viewVideo) as VideoView

        // val splashFragment = SplashFragment()
        //  val signInFragment = SignInFragment()

        //  supportFragmentManager.beginTransaction().apply {
        //        replace(nav_host_fragment_container, splashFragment)
        //         commit()
    }
    override fun onResume() {
        super.onResume()

        animDuration
        // set the absolute path of the video file which is going to be played
        videoView!!.setVideoURI(Uri.parse("android.resource://" + packageName + "/" + R.raw.animation1))

        videoView!!.requestFocus()

        // starting the video
        videoView!!.start()

        videoView!!.setOnCompletionListener {
            //TODO go to next fragment (login)
            // After 5 seconds redirect to another intent

            sleep(5 * 1000)
            val i = Intent(baseContext, SignInFragment::class.java)
            startActivity(i)
        }

    }

}

