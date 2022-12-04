package com.example.feng.scheduleto_dos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var backButton: Button
    lateinit var resultOutput: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        backButton = findViewById(R.id.back_button)
        resultOutput = findViewById(R.id.result_output)

        val result = intent.getStringExtra("EXTRA_RESULT")

        resultOutput.text = result

        backButton.setOnClickListener {
            Intent(this@MainActivity, AddHabit::class.java).also {
                startActivity(it)
            }
        }
    }
}