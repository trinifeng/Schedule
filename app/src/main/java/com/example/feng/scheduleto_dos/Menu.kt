package com.example.feng.scheduleto_dos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Menu : AppCompatActivity() {

    lateinit var addHabitButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        addHabitButton = findViewById(R.id.add_habit_screen_button)
    }
}