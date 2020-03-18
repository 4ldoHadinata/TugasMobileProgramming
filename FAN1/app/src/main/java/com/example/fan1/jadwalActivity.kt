package com.example.fan1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import kotlinx.android.synthetic.main.activity_jadwal.*
import org.json.JSONArray
import org.json.JSONObject

class jadwalActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jadwal)

        button.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
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

                        txtShubuh.setText(jsonObject.optString("shubuh"))
                        txtDhuhur.setText(jsonObject.optString("dhuhur"))
                        txtAshar.setText(jsonObject.optString("ashar"))
                        txtMaghrib.setText(jsonObject.optString("maghrib"))
                        txtIsha.setText(jsonObject.optString("isha"))
                        txtDhuha.setText(jsonObject.optString("dhuha"))
                    }
                }

                override fun onError(anError: ANError?) {
                    Log.i("_err", anError.toString())
                }
            })
    }
}
