package com.example.feng.scheduleto_dos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class LoginScreen : AppCompatActivity() {

    lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_screen)

        loginButton = findViewById(R.id.login_button)

        loginButton.setOnClickListener{
            Intent(this@LoginScreen, AddHabit::class.java).also {
                startActivity(it)
            }
        }
    }
}