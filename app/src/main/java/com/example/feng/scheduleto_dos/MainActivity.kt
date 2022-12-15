package com.example.feng.scheduleto_dos

import Habit
import HabitList
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
var habitList = HabitList()

class MainActivity : AppCompatActivity() {

    lateinit var backButton: Button
    lateinit var resultOutput: TextView
    lateinit var sunOutput: TextView
    lateinit var monOutput: TextView
    lateinit var tuesOutput: TextView
    lateinit var wedOutput: TextView
    lateinit var thursOutput: TextView
    lateinit var friOutput: TextView
    lateinit var satOutput: TextView

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

        val habit = Habit(name, time, numSessions, days as ArrayList<Int>, minutesOrHours)

        habitList.hl.add(habit)
        Toast.makeText(applicationContext, habitList.hl.size.toString(), Toast.LENGTH_LONG).show()

        var errorCheck: Int = habit.checkErrors()

        if(errorCheck == 1) {
            Toast.makeText(applicationContext, "Your habit takes too long in one day! Please re-enter your habit", Toast.LENGTH_SHORT).show()
        }
        else if(errorCheck == 2) {
            Toast.makeText(applicationContext, "You have too many sessions on one day. Showing only 5", Toast.LENGTH_SHORT).show()
        }
        else {
            var newDays = habit.setDays()
            sunOutput.text = habitList.sunHabits()
            monOutput.text = habitList.monHabits()
            tuesOutput.text = habitList.tuesHabits()
            wedOutput.text = habitList.wedHabits()
            thursOutput.text = habitList.thursHabits()
            friOutput.text = habitList.friHabits()
            satOutput.text = habitList.satHabits()
        }

        //resultOutput.text = "$name \n $time \n $numSessions \n $days \n $minutesOrHours"

        backButton.setOnClickListener {
            Intent(this@MainActivity, AddHabit::class.java).also {
                startActivity(it)
            }
        }
    }
}