package com.example.feng.scheduleto_dos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Menu : AppCompatActivity() {

    lateinit var addHabitButton: Button
    lateinit var viewHabitsButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        addHabitButton = findViewById(R.id.add_habit_screen_button)
        viewHabitsButton = findViewById(R.id.view_habits_button)

        addHabitButton.setOnClickListener {
            Intent(this@Menu, AddHabit::class.java).also {
                startActivity(it)
            }
        }

        viewHabitsButton.setOnClickListener {
            Intent(this@Menu, ViewHabits::class.java).also {
                startActivity(it)
            }
        }
    }
}