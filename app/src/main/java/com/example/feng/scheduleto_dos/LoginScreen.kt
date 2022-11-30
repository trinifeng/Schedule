package com.example.feng.scheduleto_dos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginScreen : AppCompatActivity() {

    lateinit var loginButton: Button
    lateinit var loginText: EditText
    lateinit var passwordText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_screen)

        loginButton = findViewById(R.id.login_button)
        loginText = findViewById(R.id.username_edit_text)
        passwordText = findViewById(R.id.password_edit_text)

        loginButton.setOnClickListener{
            when(CheckLogin(loginText.text.toString(), passwordText.text.toString())) {

                LoginSuccess.login -> {
                    Toast.makeText(applicationContext, getString(R.string.error_login), Toast.LENGTH_SHORT).show()
                    loginText.error = "Invalid Username"
                    loginText.requestFocus()
                    loginText.selectAll()
                }
                LoginSuccess.password -> {
                    Toast.makeText(applicationContext, getString(R.string.error_password), Toast.LENGTH_SHORT).show()
                    passwordText.error = "Invalid Password"
                    passwordText.requestFocus()
                    passwordText.selectAll()
                }
                LoginSuccess.success -> {
                    Toast.makeText(applicationContext, getString(R.string.success), Toast.LENGTH_SHORT).show()
                    Intent(this@LoginScreen, AddHabit::class.java).also {
                        startActivity(it)
                    }
                }
            }
        }
    }

    fun CheckLogin(login: String, password: String): LoginSuccess {
        val holdLogin = "Trini"
        val holdPassword = "password"

        if(holdLogin != login) {
            return LoginSuccess.login
        }
        if(holdPassword != password) {
            return LoginSuccess.password
        }
        return LoginSuccess.success
    }

    enum class LoginSuccess(val intValue: Int) {
        login(1),
        password(2),
        success(0)
    }
}