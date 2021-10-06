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

class SignupActivity : AppCompatActivity() {
    private lateinit var signUpUsername: EditText
    private lateinit var signUpPassword: EditText
    private lateinit var signUpBtn: Button
    private lateinit var signUpLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signup)
        supportActionBar?.setTitle("Sign UP")

        signUpUsername = findViewById(R.id.signupusername)
        signUpPassword = findViewById(R.id.signuppassword)
        signUpBtn = findViewById(R.id.signupbtn)
        signUpLogin = findViewById(R.id.signuptologinbtn)


        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "app-database"
        ).allowMainThreadQueries().build()
        val userDao = db.userDao()

        signUpBtn.setOnClickListener {
            if (signUpPassword.text.toString().length < 8 && !isValidPassword(signUpPassword.text.toString())) {
                Toast.makeText(baseContext, "Invalid password", Toast.LENGTH_SHORT).show()
            } else {
                val newUser = User(signUpUsername.text.toString(), signUpPassword.text.toString())
                userDao.insert(newUser)
                Toast.makeText(baseContext, "Sign Up Successfull", Toast.LENGTH_SHORT).show()
            }
        }
        signUpLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
    fun isValidPassword(password: String?): Boolean {
        val pattern: Pattern
        val matcher: Matcher
        val PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[a-z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$"
        pattern = Pattern.compile(PASSWORD_PATTERN)
        matcher = pattern.matcher(password)
        return matcher.matches()
    }
    }


