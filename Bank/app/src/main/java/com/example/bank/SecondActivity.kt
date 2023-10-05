package com.example.bank

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val resultTextView = findViewById<TextView>(R.id.resultTextView)
        val result = intent.getDoubleExtra("result", 0.0)

        resultTextView.text = "Получить = $result рублей."
    }
}