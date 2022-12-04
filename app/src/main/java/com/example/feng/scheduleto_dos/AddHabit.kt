package com.example.feng.scheduleto_dos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

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

    var habit = ""
    var time = 0
    var minutesOrHours = false
    var numSessions = 0

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

        addHabitButton.setOnClickListener {
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

            days.sort()
            minutesOrHours = timeButton.isChecked //hours is true, minutes is false
            habit = habitName.text.toString()

            when(CheckIfBlank(habit, habitTime.text.toString(), sessions.text.toString())) {

                HabitSuccess.habit -> {
                    habitName.error = getString(R.string.error_habit)
                    habitName.requestFocus()
                    habitName.selectAll()
                }
                HabitSuccess.time -> {
                    habitTime.error = getString(R.string.error_time)
                    habitTime.requestFocus()
                    habitTime.selectAll()
                }
                HabitSuccess.sessions -> {
                    sessions.error = getString(R.string.error_sessions)
                    sessions.requestFocus()
                    sessions.selectAll()
                }
                HabitSuccess.success -> {
                    time = habitTime.text.toString().toInt()
                    if((minutesOrHours && time >= 24) || (!minutesOrHours && time >= 1440)) {
                        Toast.makeText(applicationContext, "Time cannot exceed or be equal to total time in a day", Toast.LENGTH_SHORT).show()
                        habitTime.requestFocus()
                        habitTime.selectAll()
                    }
                    else {
                        numSessions = sessions.text.toString().toInt()

                        Toast.makeText(applicationContext, getString(R.string.habit_success), Toast.LENGTH_SHORT).show()
                        var result = "Your habit is: $habit for $time"
                        result += if(minutesOrHours)
                            " hours "
                        else
                            " minutes "
                        result += "for $numSessions sessions per week"
                        if(days.isNotEmpty())
                            result += " preferably on days: $days"

                        Intent(this@AddHabit, MainActivity::class.java).also {
                            it.putExtra("EXTRA_RESULT", result)
                            startActivity(it)
                        }
                    }
                }
            }
        }
    }

    fun CheckIfBlank(habit: String, time: String, sessions: String): HabitSuccess {

        if(habit.isNullOrBlank()) {
            return HabitSuccess.habit
        }
        if(time.isNullOrBlank()) {
            return HabitSuccess.time
        }
        if(sessions.isNullOrBlank()) {
            return HabitSuccess.sessions
        }
        return HabitSuccess.success
    }

    enum class HabitSuccess(val intValue: Int) {
        habit(1),
        time(2),
        sessions(3),
        success(0)
    }
}