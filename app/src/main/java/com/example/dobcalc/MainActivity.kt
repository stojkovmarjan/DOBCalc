package com.example.dobcalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.util.*;
import android.app.DatePickerDialog;
import java.text.SimpleDateFormat

class MainActivity : AppCompatActivity() {

    private val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnSelectDate = findViewById<Button>(R.id.btnSelectDate);

        btnSelectDate.setOnClickListener{
            clickDatePicker()
        }

    }

    private fun clickDatePicker() {

        val tvDate = findViewById<TextView>(R.id.tvDate);
        val tvMinutes = findViewById<TextView>(R.id.tvMinutes);

        val calendar = Calendar.getInstance();

        val year = calendar.get(Calendar.YEAR);
        val month = calendar.get(Calendar.MONTH);
        val dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

        val dp = DatePickerDialog( this, DatePickerDialog.OnDateSetListener{ _, y, m, d ->
            val dateString = "$d/${m+1}/$y"

            val date = sdf.parse(dateString)
            tvDate.text = dateString

            val ageInMinutes = calculateMinutes(date);

            tvMinutes.text = "$ageInMinutes"

        }, year, month,dayOfMonth)

        dp.datePicker.maxDate = System.currentTimeMillis() - 86400000

        dp.show()

    }

    private fun calculateMinutes(date: Date): Long {

        val selectedDateInMinutes = date.time.div(60000)
        val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))
        var currentDateInMinutes: Long = 0
        currentDate?.let {
            currentDateInMinutes = currentDate.time / 60000
        }

        return currentDateInMinutes - selectedDateInMinutes
    }


}