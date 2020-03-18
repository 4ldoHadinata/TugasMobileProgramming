package com.example.fan1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONArrayRequestListener
import com.androidnetworking.interfaces.JSONObjectRequestListener
import kotlinx.android.synthetic.main.activity_identitas.*
import org.json.JSONArray
import org.json.JSONObject

class identitasActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_identitas)

        getIdentitas()

        btnUpdate.setOnClickListener {
            update()
        }

    }

    fun getIdentitas(){
        AndroidNetworking.get("http://10.39.129.162/coba/nama_masjid_json.php")
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject?) {
                    Log.e("_kotlinResponse", response.toString())

                    val jsonArray : JSONArray = response!!.getJSONArray("result")
                    for (i in 0 until jsonArray.length()){
                        val jsonObject = jsonArray.getJSONObject(i)

                        txtNama.setText(jsonObject.optString("Nama"))
                        txtAlamat.setText(jsonObject.optString("Alamat"))
                    }
                }

                override fun onError(anError: ANError?) {
                    Log.i("_err", anError.toString())
                }
            })
    }

    fun postkeserver(data1:String, data2:String)
    {
        AndroidNetworking.post("http://10.39.129.162/coba/proses-identitas.php")
            .addBodyParameter("nama_masjid", data1)
            .addBodyParameter("alamat_masjid", data2)
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONArray(object : JSONArrayRequestListener {
                override fun onResponse(response: JSONArray) {
                    // do anything with error
                }

                override fun onError(anError: ANError?) {
                    // handle error
                }
            })
    }

    fun update(){
        postkeserver(editNama.text.toString(), editAlamat.text.toString())

        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

}
