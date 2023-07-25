package com.example.bangkit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView

class detail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar!!.setDisplayShowHomeEnabled(true)

        val data = intent.getParcelableExtra<Hotel>("DATA")

        var img :ImageView = findViewById(R.id.imgHtl)
        var texet : TextView = findViewById(R.id.tvlokasi)
        var texet2 : TextView = findViewById(R.id.tvdesc)

        if (data != null) {
            img.setImageResource(data.photo)
            texet.text = data.name
            texet2.text = data.dataHotel
        }





    }
}