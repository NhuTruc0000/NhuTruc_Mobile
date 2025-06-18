package com.example.myapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val nameInput = findViewById<EditText>(R.id.nameInput)
        val ageInput = findViewById<EditText>(R.id.ageInput)
        val resultText = findViewById<TextView>(R.id.resultText)
        val checkButton = findViewById<Button>(R.id.checkButton)

        checkButton.setOnClickListener {
            val name = nameInput.text.toString().trim()
            val ageStr = ageInput.text.toString().trim()

            if (name.isEmpty() || ageStr.isEmpty()) {
                resultText.text = "Vui lòng nhập đầy đủ họ tên và tuổi."
                return@setOnClickListener
            }

            val age = ageStr.toIntOrNull()
            if (age == null || age < 0) {
                resultText.text = "Tuổi không hợp lệ."
                return@setOnClickListener
            }

            val group = when {
                age > 65 -> "Người già"
                age in 6..65 -> "Người lớn"
                age in 2..5 -> "Trẻ em"
                age <= 2 -> "Em bé"
                else -> "Không xác định"
            }

            resultText.text = "$name thuộc nhóm: $group"


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}}