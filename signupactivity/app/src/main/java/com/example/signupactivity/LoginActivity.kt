package com.example.signupactivity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.signupactivity.data.AppDatabase
import com.example.signupactivity.data.User
import java.util.regex.Matcher
import java.util.regex.Pattern

class LoginActivity : AppCompatActivity() {
    private lateinit var loginUsername: EditText
    private lateinit var loginPassword: EditText
    private lateinit var loginBtn: Button
    private lateinit var loginSign: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)
        supportActionBar?.setTitle("Log IN")

        loginUsername = findViewById(R.id.loginusername)
        loginPassword = findViewById(R.id.loginpassword)
        loginBtn = findViewById(R.id.loginbtn)
        loginSign = findViewById(R.id.logintosignupbtn)


        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "app-database"
        ).allowMainThreadQueries().build()
        val userDao = db.userDao()

        loginBtn.setOnClickListener {
            val tempUser = userDao.getUser(loginUsername.text.toString())
            if (tempUser.password.equals(loginPassword.text.toString())) {
                Toast.makeText(baseContext, "Login Sucessfull", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(
                    baseContext,
                    "Invalid Username/Password ; Login Failed",
                    Toast.LENGTH_SHORT
                ).show()
            }

        }
        loginSign.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}