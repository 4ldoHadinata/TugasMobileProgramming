package com.example.aldominggu1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var kota : String = "Medan"
        kota = "Malang"

        var jam = 12

        if (jam <= 12)
        {
            Log.i("Hasil", "Selamat Pagi")
        }
        else
        {
            Log.i("Hasil", "Selamat Petang")
        }

        /*
        var nilai = 70

        if (nilai <= 100 && nilai >= 90)
        {
            Log.i("Hasil","Nilai Anda A")
        }
        else if (nilai < 90 && nilai >= 80)
        {
            Log.i("Hasil","Nilai Anda AB")
        }
        else if (nilai < 80 && nilai >= 70)
        {
            tampil.text = "Nilai Anda B"
        }
        else if (nilai < 70 && nilai >= 60)
        {
            Log.i("Hasil","Nilai Anda BC")
        }
        else if (nilai < 60)
        {
            Log.i("Hasil","Nilai Anda C")
        }
        */

        /*
        for (x in 0..10)
            Log.i("Hasil", "$x")

         */

        /*
        var i =1
        while (i <= 5) {
            Log.i("Hasil","$i")
            ++i
        }

         */

        /*
        var num = 2
        var i = 1
        do {
            Log.i("Hasil","2 * $i = " + num * i)
            i++
        } while

         */

        penjumlahan(7,5)

        var a = 5
        var b = 6
        var c = 10
        hitung(a,b,c)
    }

    fun penjumlahan(a:Int, b:Int)
    {
        var c = a + b
        Log.i("Hasil","$c")
    }

    fun hitung(a:Int,b:Int,c:Int){
        var d = (a * b - 10) / c
        Log.i("Hasil","$d")
    }

}
