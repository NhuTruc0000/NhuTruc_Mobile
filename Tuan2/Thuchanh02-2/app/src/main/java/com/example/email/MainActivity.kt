package com.example.email

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
        val emailInput = findViewById<EditText>(R.id.emailInput)
        val checkButton = findViewById<Button>(R.id.checkButton)
        val messageText = findViewById<TextView>(R.id.messageText)

        checkButton.setOnClickListener {
            val email = emailInput.text.toString().trim()

            val message = when {
                email.isEmpty() -> "Email không hợp lệ"
                !email.contains("@") -> "Email không đúng định dạng"
                else -> "Bạn đã nhập email hợp lệ"
            }

            messageText.text = message
            messageText.setTextColor(
                if (message.contains("hợp lệ")) getColor(android.R.color.holo_green_dark)
                else getColor(android.R.color.holo_red_dark)
            )

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}}