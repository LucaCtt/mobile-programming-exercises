package com.example.hmds

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    private var tvSelectedDate: TextView? = null
    private var tvResults: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnDatePicker = findViewById<Button>(R.id.btnSelectedDate)
        tvSelectedDate = findViewById(R.id.tvSelectedDate)
        tvResults = findViewById(R.id.tvResults)

        btnDatePicker.setOnClickListener{
            clickDatePicker()
        }
    }

    private fun clickDatePicker() {
        val cal = Calendar.getInstance()
        val year = cal.get(Calendar.YEAR)
        val month = cal.get(Calendar.MONTH)
        val day = cal.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(this, DatePickerDialog.OnDateSetListener{_, year, month, dayOfMonth ->
            val selectedDate = "$dayOfMonth/${month+1}/$year"
            //Toast.makeText(this, selectedDate, Toast.LENGTH_LONG).show()
            tvSelectedDate?.text = "Since $selectedDate,"

            val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ITALY)
            val theDate = sdf.parse(selectedDate)
            val selectedDayInDays = theDate.time / 86_400_000

            val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))
            val currentDateInDays = currentDate.time / 86_400_000

            val diffDates = currentDateInDays - selectedDayInDays
            tvResults?.text = "${diffDates.toString()} days have passed"
        }, year, month, day).show()
    }
}