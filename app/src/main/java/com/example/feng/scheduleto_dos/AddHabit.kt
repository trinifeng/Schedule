package com.example.feng.scheduleto_dos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ToggleButton

class AddHabit : AppCompatActivity() {

    lateinit var addHabitButton: Button
    lateinit var habitName: EditText
    lateinit var habitTime: EditText
    lateinit var timeButton: ToggleButton
    lateinit var sessions: EditText
    lateinit var mondayCheck: CheckBox
    lateinit var tuesdayCheck: CheckBox
    lateinit var wednesdayCheck: CheckBox
    lateinit var thursdayCheck: CheckBox
    lateinit var fridayCheck: CheckBox
    lateinit var saturdayCheck: CheckBox
    lateinit var sundayCheck: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_habit)

        addHabitButton = findViewById(R.id.add_habit_button)
        habitName = findViewById(R.id.habit_name_text)
        habitTime = findViewById(R.id.habit_time)
        timeButton = findViewById(R.id.minutes_or_hours)
        sessions = findViewById(R.id.num_sessions)
        mondayCheck = findViewById(R.id.monday_check)
        tuesdayCheck = findViewById(R.id.tuesday_check)
        wednesdayCheck = findViewById(R.id.wednesday_check)
        thursdayCheck = findViewById(R.id.thursday_check)
        fridayCheck = findViewById(R.id.friday_check)
        saturdayCheck = findViewById(R.id.saturday_check)
        sundayCheck = findViewById(R.id.sunday_check)

        var days = arrayListOf<Int>()
        if(sundayCheck.isChecked) {
            days.add(1)
        }
        if(mondayCheck.isChecked) {
            days.add(2)
        }
        if(tuesdayCheck.isChecked) {
            days.add(3)
        }
        if(wednesdayCheck.isChecked) {
            days.add(4)
        }
        if(thursdayCheck.isChecked) {
            days.add(5)
        }
        if(fridayCheck.isChecked) {
            days.add(6)
        }
        if(saturdayCheck.isChecked) {
            days.add(7)
        }

        addHabitButton.setOnClickListener {
            Intent(this@AddHabit, MainActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}