package com.example.nicefaucet

import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.MediaController
import android.widget.Toast
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {


    //declaring  a null variable for VideoView
    var videoView: VideoView? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setTheme(R.style.Theme_NiceFaucet)
        setContentView(R.layout.activity_main)

        // assigning id of VideoView from
        // activity_main.xml layout file
        videoView = findViewById<View>(R.id.viewVideo) as VideoView

         }
    override fun onResume() {
        super.onResume()

        // set the absolute path of the video file which is going to be played
        videoView!!.setVideoURI(Uri.parse("android.resource://" + packageName + "/" + R.raw.animation1))

        videoView!!.requestFocus()

        // starting the video
        videoView!!.start()

        videoView!!.setOnCompletionListener {
            //TODO go to next fragment (login)

        }

    }

}



