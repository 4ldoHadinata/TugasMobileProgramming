package com.example.fan1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnIdentitas.setOnClickListener {
            val intent = Intent(this, identitasActivity::class.java)
            startActivity(intent)
            finish()
        }

        btnJadwal.setOnClickListener {
            val intent = Intent(this, jadwalActivity::class.java)
            startActivity(intent)
            finish()
        }

        getdariserver()
    }

    fun getdariserver(){
        AndroidNetworking.get("http://10.39.129.162/coba/contoh_jadwal_json.php")
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject) {
                    Log.e("kotlinResponse", response.toString())

                    val jsonArray : JSONArray = response.getJSONArray("result")
                    for (i in 0 until jsonArray.length()){
                        val jsonObject = jsonArray.getJSONObject(i)
                        Log.e("kotlinTitle",jsonObject.optString("shubuh"))

                        txt1.setText(jsonObject.optString("shubuh"))
                    }
                }

                override fun onError(anError: ANError?) {
                    Log.i("_err", anError.toString())
                }
            })
    }
}
