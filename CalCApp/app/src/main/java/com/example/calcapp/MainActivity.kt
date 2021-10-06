package com.example.calcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Button
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    private lateinit var zero: TextView
    private lateinit var one: TextView
    private lateinit var two: TextView
    private lateinit var three: TextView
    private lateinit var four: TextView
    private lateinit var five: TextView
    private lateinit var six: TextView
    private lateinit var seven: TextView
    private lateinit var eight: TextView
    private lateinit var nine: TextView
    private lateinit var addition: TextView
    private lateinit var substraction: TextView
    private lateinit var multiplication: TextView
    private lateinit var division: TextView
    private lateinit var equals: TextView
    private lateinit var clear: Button
    private lateinit var result: TextView
    private lateinit var expression: TextView
    private lateinit var dot: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        zero = findViewById(R.id.zero)
        one = findViewById(R.id.one)
        two = findViewById(R.id.two)
        three = findViewById(R.id.three)
        four = findViewById(R.id.four)
        five = findViewById(R.id.five)
        six = findViewById(R.id.six)
        seven = findViewById(R.id.seven)
        eight = findViewById(R.id.eight)
        nine = findViewById(R.id.nine)
        addition = findViewById(R.id.plus)
        substraction = findViewById(R.id.minus)
        multiplication = findViewById(R.id.mult)
        division = findViewById(R.id.divide)
        equals = findViewById(R.id.equals)
        clear = findViewById(R.id.clear)
        result = findViewById(R.id.res)
        expression = findViewById(R.id.exp)
        dot = findViewById(R.id.deci)
        zero.setOnClickListener {
            pressButton("0", true)
        }
        one.setOnClickListener {
            pressButton("1", true)
        }
        two.setOnClickListener {
            pressButton("2", true)
        }
        three.setOnClickListener {
            pressButton("3", true)
        }
        four.setOnClickListener {
            pressButton("4", true)
        }
        five.setOnClickListener {
            pressButton("5", true)
        }
        six.setOnClickListener {
            pressButton("6", true)
        }
        seven.setOnClickListener {
            pressButton("7", true)
        }
        eight.setOnClickListener {
            pressButton("8", true)
        }
        nine.setOnClickListener {
            pressButton("9", true)
        }
        addition.setOnClickListener {
            pressButton("+", true)
        }
        substraction.setOnClickListener {
            pressButton("-", true)
        }
        multiplication.setOnClickListener {
            pressButton("*", true)
        }
        division.setOnClickListener {
            pressButton("/", true)
        }
        dot.setOnClickListener {
            pressButton(".", true)
        }
        clear.setOnClickListener {
            result.text = ""
            expression.text = ""
        }
        equals.setOnClickListener {
            val text = expression.text.toString()
            val expression = ExpressionBuilder(text).build()

            val expResult = expression.evaluate()
            val longResult = expResult.toLong()
            if (expResult == longResult.toDouble()) {
                result.text = longResult.toString()
            } else {
                result.text = expResult.toString()
            }

        }

    }

    fun pressButton(string: String, clear: Boolean) {
        if (clear) {
            result.text = ""
            expression.append(string)
        } else {
            expression.append(result.text)
            expression.append(string)
            result.text = ""
        }
    }
}