package com.example.dobcalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.util.*;
import android.app.DatePickerDialog;
import java.text.SimpleDateFormat

class MainActivity : AppCompatActivity() {
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

        DatePickerDialog( this, DatePickerDialog.OnDateSetListener{ _, y, m, d ->
            var dateString = "$d/${m+1}/$y"
            val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
            val date = sdf.parse(dateString)
            tvDate.text = dateString

            calculateMinutes(date);

        }, year, month,dayOfMonth).show();

    }

    private fun calculateMinutes(date: Date?) {
        //TODO: Calculate ages in minutes
    }


}