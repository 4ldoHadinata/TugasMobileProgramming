package com.example.kalkulatorkelasb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        jumlah.setOnClickListener() {
            tambah()
        }

        pengurangan.setOnClickListener {
            kurang()
        }

        perkalian.setOnClickListener {
            kali()
        }

        pembagian.setOnClickListener {
            bagi()
        }

    }

    fun tambah() {
        var a:Int = (bilangan1.text.toString()).toInt()
        var b:Int = (bilangan2.text.toString()).toInt()
        hasil.setText((a+b).toString())
    }

    fun kurang() {
        var a:Int = (bilangan1.text.toString()).toInt()
        var b:Int = (bilangan2.text.toString()).toInt()
        hasil.setText((a-b).toString())
    }

    fun kali() {
        var a:Int = (bilangan1.text.toString()).toInt()
        var b:Int = (bilangan2.text.toString()).toInt()
        hasil.setText((a*b).toString())
    }

    fun bagi() {
        var a:Int = (bilangan1.text.toString()).toInt()
        var b:Int = (bilangan2.text.toString()).toInt()
        hasil.setText((a/b).toString())
    }

}
