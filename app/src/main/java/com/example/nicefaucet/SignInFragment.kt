package com.example.nicefaucet

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment


class SignInFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

    // Inflate the layout for this fragment
    val view = inflater.inflate(R.layout.fragment_signin, container, false)
    val button = view.findViewById<Button>(R.id.sign_in_button)
    button.setOnClickListener {
        val intent = Intent(context, MainActivity::class.java).apply {
            activity?.finish()
        }
        startActivity(intent)
    }
    return view
}

}