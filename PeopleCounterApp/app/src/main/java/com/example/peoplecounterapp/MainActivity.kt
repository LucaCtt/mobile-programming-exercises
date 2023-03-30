package com.example.peoplecounterapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnPlusOne = findViewById<Button>(R.id.btn_plus_one)
        val tvParticipants = findViewById<TextView>(R.id.tv_participants)
        var timesClicked = 0

        btnPlusOne.setOnClickListener{
            timesClicked++
            tvParticipants.text = "Participants: $timesClicked"
            Toast.makeText(this, "Participant added successfully", Toast.LENGTH_SHORT).show()
        }
    }
}