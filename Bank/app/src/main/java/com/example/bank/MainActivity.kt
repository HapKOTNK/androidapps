package com.example.bank

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val depositAmount = findViewById<EditText>(R.id.depositAmount)
        val threeMonths = findViewById<RadioButton>(R.id.threeMonths)
        val sixMonths = findViewById<RadioButton>(R.id.sixMonths)
        val yearMonths = findViewById<RadioButton>(R.id.yearMonths)
        val okButton = findViewById<Button>(R.id.okButton)

        okButton.setOnClickListener {
            val amount = depositAmount.text.toString().toDoubleOrNull()
            val interestRate = when {
                threeMonths.isChecked -> 0.03
                sixMonths.isChecked -> 0.05
                yearMonths.isChecked -> 0.09
                else -> 0.0
            }

            if (amount != null) {
                val result = amount + (amount * interestRate)
                val intent = Intent(this, SecondActivity::class.java).apply {
                    putExtra("result", result)
                }
                startActivity(intent)
            }
        }
    }
}
