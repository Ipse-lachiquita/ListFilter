package com.example.recyclerviewfilter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    private lateinit var text: TextView
    private var value: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        text = findViewById(R.id.text_view)
        var intent = intent

        value = intent.getIntExtra("position", 0)
        text.text = value.toString()

    }
}