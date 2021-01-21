package com.example.nicefaucet

import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.MediaController
import android.widget.Toast
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    //declaring  a null variable for VideoView
    var videoView: VideoView? = null

    //declaring a null variable for MediaController
    var mediaControls: MediaController? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // assigning id of VideoView from
        // activity_main.xml layout file
        videoView = findViewById<View>(R.id.viewVideo) as VideoView

        if (mediaControls == null) {

            // creating an object of media controller class,
            // MediaController is a layout for control the medium sound and video
            // we implant this xml only in the code
            mediaControls = MediaController(this)

            // set the anchor view for the video view
            mediaControls!!.setAnchorView(this.videoView)
        }
        // set the media controller for video view
        videoView!!.setMediaController(mediaControls)

        // set the absolute path of the video file which is going to be played
        videoView!!.setVideoURI(Uri.parse("android.resource://" + packageName + "/" + R.raw.animation))


        videoView!!.requestFocus()

        // starting the video
        videoView!!.start()

        //display a toast message
        //after the video is completed
        videoView!!.setOnCompletionListener {
            Toast.makeText(applicationContext, " Video completed ", Toast.LENGTH_LONG).show()
        }
        //display a toast message if any
        //error occurs while playing the video
        videoView!!.setOnCompletionListener {
            Toast.makeText(
                applicationContext,
                " an Error Occured " + " While Playing Video !!!",
                Toast.LENGTH_LONG
            ).show()
            false
        }

    }

}