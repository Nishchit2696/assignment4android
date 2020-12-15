package com.example.assignment5

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.abs
class MainActivity : AppCompatActivity() {
    private lateinit var btnLoadCalendar: Button
    private lateinit var tvDate: EditText
    private lateinit var btnLoadTime: Button
    private lateinit var tvTime: EditText
    private lateinit var tvDob: TextView;
    private lateinit var tvJoinedDate: TextView;
    var final: String = "";

    //    var year:Int = 0;
//    var month:Int = 0;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnLoadCalendar = findViewById(R.id.btnLoadCalendar)
        tvDate = findViewById(R.id.tvDate)
        btnLoadTime = findViewById(R.id.btnLoadTime)
        tvTime = findViewById(R.id.tvTime);
        //Today date...........
        val c = Calendar.getInstance()
        var year = c.get(Calendar.YEAR)
        var month = c.get(Calendar.MONTH) + 1;
        val day = c.get(Calendar.DAY_OF_MONTH)
        final = "$day/$month/$year";

        //Result seciton............
        tvDob = findViewById(R.id.tvDob);
        tvJoinedDate = findViewById(R.id.tvJoinedDate);

        btnLoadCalendar.setOnClickListener {
            loadCalendar()
        }
        btnLoadTime.setOnClickListener {
            loadTime()
        }
    }

    private fun loadCalendar() {
        val c = Calendar.getInstance()
        var yearr = c.get(Calendar.YEAR)
        var monthh = c.get(Calendar.MONTH)
        val dayy = c.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener { view, yearThis, monthThis, dayOfMonth ->
                var date = "$dayOfMonth/${monthThis + 1}/ $yearThis";
                tvDate.setText(date)
                val f = SimpleDateFormat("MM/dd/YYYY")
                val d1 = f.parse(final);
                val d2 = f.parse(date);
                val diff: Long = abs(d1.time - d2.time);
                val diffDate = diff / (24 * 60 * 60 * 1000);
                val yearDiff = diffDate / 365;
                val r = diffDate % 365;
                val month = r / 30;
                val rest = "$yearDiff yr $month month";
                tvJoinedDate.setText(rest.toString());
            },
            yearr,
            monthh,
            dayy
        )
        datePickerDialog.show()
    }

    private fun loadTime() {
        val c = Calendar.getInstance()
        val yearr = c.get(Calendar.YEAR)
        val monthh = c.get(Calendar.MONTH)
        val dayy = c.get(Calendar.DAY_OF_MONTH)
        val datePickerDialog = DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener { view, yearThis, monthThis, dayOfMonth ->
                var date = "$dayOfMonth/${monthThis + 1}/ $yearThis";
                tvTime.setText(date)
                val f = SimpleDateFormat("MM/dd/YYYY")
                val d1 = f.parse(final);
                val d2 = f.parse(date);
                val diff: Long = abs(d1.time - d2.time);
                val diffDate = diff / (24 * 60 * 60 * 1000);
                val yearDiff = diffDate / 365;
                val r = diffDate % 365;
                val month = r / 30;
                val rest = "$yearDiff yr $month month";
                tvDob.setText(rest.toString());
            },
            yearr,
            monthh,
            dayy
        )
        datePickerDialog.show()
    }
}