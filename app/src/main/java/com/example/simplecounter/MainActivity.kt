package com.example.simplecounter

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.button)
        val txtView = findViewById<TextView>(R.id.textView)
        val buttonUpgrade = findViewById<Button>(R.id.button2)
        var count = 0
        var incrementBy =1
        txtView.text = count.toString()
        button.setOnClickListener {
            Toast.makeText(it.context, "Clicked Button!", Toast.LENGTH_SHORT).show()
            count += incrementBy
            txtView.text = count.toString()


            if (count >= 10) {
                buttonUpgrade.visibility = View.VISIBLE

                buttonUpgrade.setOnClickListener {
                    incrementBy = 2
                    button.text = "ADD ${incrementBy.toString()}"
                    buttonUpgrade.visibility = View.INVISIBLE
                }
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}