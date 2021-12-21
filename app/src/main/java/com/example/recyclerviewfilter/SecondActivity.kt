package com.example.recyclerviewfilter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    private lateinit var text: TextView
    private var value: String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        text = findViewById(R.id.text_view)
        var intent = intent

        value = intent.getStringExtra("position")!!
        text.text = value.toString()

    }
}