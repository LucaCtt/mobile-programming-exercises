package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private var tvInput: TextView? = null
    private var lastNumeric: Boolean = true
    private var lastDot: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvInput = findViewById(R.id.tvInput)
    }

    fun onDigit(view: View) {
        //Toast.makeText(this, "Button clicked", Toast.LENGTH_SHORT).show()
        if (tvInput?.text == "0") {
            tvInput?.text = ""
        }
        tvInput?.append((view as Button).text)
        lastNumeric = true
        lastDot = false
    }

    fun onClear(view: View) {
        tvInput?.text = ""
    }

    fun onDecimal(view: View) {
        if (lastNumeric && !lastDot && !tvInput?.text?.contains(".")!!) {
            tvInput?.append(".")
            lastNumeric = false
            lastDot = true
        }
    }

    private fun isOperatorAdded(value: String): Boolean {
        return if (value.startsWith("-")) {
            false
        } else {
            value.contains("/")
                    || value.contains("*")
                    || value.contains("+")
                    || value.contains("-")
        }
    }

    fun onOperator(view: View) {
        tvInput?.text?.let {
            if (lastNumeric && !isOperatorAdded(it.toString())) {
                tvInput?.append((view as Button).text)
                lastNumeric = false
                lastDot = false
            }
        }
    }

    fun onEqual(view: View) {
        if (lastNumeric && !lastDot) {
            val tvValue = tvInput?.text.toString()
            try {
                val splitValue = tvValue.split("-")
                val one = splitValue[0]
                val two = splitValue[1]
                var result = one.toDouble() - two.toDouble()
                tvInput?.text = result.toString()
            } catch (e: java.lang.ArithmeticException) {
                e.printStackTrace()
                tvInput?.text = "ERR"
            }
        }
    }
}