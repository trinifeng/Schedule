package com.example.feng.scheduleto_dos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var backButton: Button
    lateinit var sunOutput: TextView
    lateinit var monOutput: TextView
    lateinit var tuesOutput: TextView
    lateinit var wedOutput: TextView
    lateinit var thursOutput: TextView
    lateinit var friOutput: TextView
    lateinit var satOutput: TextView
    var result = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        backButton = findViewById(R.id.back_button)
        //resultOutput = findViewById(R.id.result_output)
        sunOutput = findViewById(R.id.sunday_habits)
        monOutput = findViewById(R.id.monday_habits)
        tuesOutput = findViewById(R.id.tuesday_habits)
        wedOutput = findViewById(R.id.wed_habits)
        thursOutput = findViewById(R.id.thurs_habits)
        friOutput = findViewById(R.id.fri_habits)
        satOutput = findViewById(R.id.sat_habits)

        val name = intent.getStringExtra("EXTRA_NAME")
        val time = intent.getIntExtra("EXTRA_TIME", 0)
        val numSessions = intent.getIntExtra("EXTRA_SESSIONS", 0)
        var days = intent.getIntegerArrayListExtra("EXTRA_DAYS")
        val minutesOrHours = intent.getBooleanExtra("EXTRA_MINUTES_OR_HOURS", false)

        var sessionsPerDay = 0
        var daysPerWeek = numSessions
        var habit = ""

        if (days != null && !(days.contains(0))) {
            daysPerWeek = days.size
        }
        else if(numSessions > 7) {
            daysPerWeek = 7
        }

        if (days != null) {
            if(days.contains(0)) {
                val daySpacing: Int = 7 / daysPerWeek
                var sum = 1
                while (sum <= 7 && days.size <= daysPerWeek) {
                    days.add(sum)
                    sum += daySpacing
                }
                days.remove(0)
            }
        }

        sessionsPerDay = numSessions / daysPerWeek

        for(i in 1..sessionsPerDay) {
            habit += "$name \n $time "
            if (minutesOrHours)
                habit += "hours"
            else
                habit += "minutes"
            habit += "\n"
        }

        var totalTime: Double = (time * sessionsPerDay).toDouble()
        if(!minutesOrHours)
            totalTime /= 60.0

        if(totalTime >= 16) {
            Toast.makeText(applicationContext, "Your habit takes too long in one day! Please re-enter your habit", Toast.LENGTH_SHORT).show()
        }
        else if(sessionsPerDay >= 5) {
            Toast.makeText(applicationContext, "You have too many sessions on one day. Please re-enter your habit", Toast.LENGTH_SHORT).show()
        }
        else if (days != null) {
            result += habit

            for(i in 1..sessionsPerDay) {
                if (days.contains(1))
                    sunOutput.text = result
                if(days.contains(2))
                    monOutput.text = result
                if (days.contains(3))
                    tuesOutput.text = result
                if(days.contains(4))
                    wedOutput.text = result
                if (days.contains(5))
                    thursOutput.text = result
                if(days.contains(6))
                    friOutput.text = result
                if(days.contains(7))
                    satOutput.text = result
            }
        }
        else {
            Toast.makeText(applicationContext, "Error occurred. Please try again", Toast.LENGTH_SHORT).show()
        }

        //resultOutput.text = "$name \n $time \n $numSessions \n $days \n $minutesOrHours"

        backButton.setOnClickListener {
            Intent(this@MainActivity, AddHabit::class.java).also {
                startActivity(it)
            }
        }
    }
}