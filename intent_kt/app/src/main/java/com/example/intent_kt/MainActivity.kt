package com.example.intent_kt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnIntent1.setOnClickListener {
            val intentPlusData = Intent(this, activity1::class.java)
            val data:String = inputText1.text.toString()
            intentPlusData.putExtra("ekspor", data)
            startActivity(intentPlusData)
            finish()
        }

        btnIntent2.setOnClickListener {
            val intent = Intent(this, activity2::class.java)
            startActivity(intent)
            finish()
        }
    }
}
