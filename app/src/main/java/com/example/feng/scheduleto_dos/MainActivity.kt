package com.example.feng.scheduleto_dos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var backButton: Button
    lateinit var resultOutput: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        backButton = findViewById(R.id.back_button)
        resultOutput = findViewById(R.id.result_output)

        val name = intent.getStringExtra("EXTRA_NAME")
        val time = intent.getIntExtra("EXTRA_TIME", 0)
        val numSessions = intent.getIntExtra("EXTRA_SESSIONS", 0)
        val days = intent.getIntegerArrayListExtra("EXTRA_DAYS")
        val minutesOrHours = intent.getBooleanExtra("EXTRA_MINUTES_OR_HOURS", false)

        var sessionsPerDay = 0
        var daysPerWeek = numSessions

        if (days != null) {
            daysPerWeek = days.size
        }
        else if(numSessions > 7) {
            daysPerWeek = 7
        }

        sessionsPerDay = numSessions / daysPerWeek
        var totalTime: Double = (time * sessionsPerDay).toDouble()
        if(!minutesOrHours)
            totalTime /= 60.0
        if(totalTime >= 16) {
            Toast.makeText(applicationContext, "Your habit takes too long in one day!", Toast.LENGTH_SHORT).show()
        }
        else if(sessionsPerDay >= 5) {
            Toast.makeText(applicationContext, "You have too many sessions on one day. Showing only 5", Toast.LENGTH_SHORT).show()
        }

        resultOutput.text = "$name \n $time \n $numSessions \n $days \n $minutesOrHours"

        backButton.setOnClickListener {
            Intent(this@MainActivity, AddHabit::class.java).also {
                startActivity(it)
            }
        }
    }
}