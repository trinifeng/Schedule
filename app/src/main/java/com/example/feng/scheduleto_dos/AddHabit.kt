package com.example.feng.scheduleto_dos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class AddHabit : AppCompatActivity() {

    lateinit var addHabitButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_habit)

        addHabitButton = findViewById(R.id.add_habit_button)

        addHabitButton.setOnClickListener {
            Intent(this@AddHabit, MainActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}