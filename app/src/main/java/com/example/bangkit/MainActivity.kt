package com.example.bangkit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rv_hotel: RecyclerView
    private val list = ArrayList<Hotel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_hotel = findViewById(R.id.rv_Hotel)
        rv_hotel.setHasFixedSize(true)

        list.addAll(getListHotel())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == R.id.action_list) {
            val intent = Intent(
                this, about::class.java)
            startActivity (intent)
        }
        return true
    }

    private fun getListHotel(): ArrayList<Hotel> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val hotedesc = resources.getStringArray(R.array.hotel_description)
        val listHotel = ArrayList<Hotel>()
        for (i in dataName.indices) {
            val hotel = Hotel(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1), hotedesc[i] )
            listHotel.add(hotel)
        }
        return listHotel
    }
    private fun showRecyclerList() {
        rv_hotel.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListHotelAdapter(list)
        rv_hotel.adapter = listHeroAdapter

        listHeroAdapter.setOnItemClickCallback(object : ListHotelAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Hotel) {
                val intentToDetail = Intent(this@MainActivity, detail::class.java)
                intentToDetail.putExtra("DATA", data)
                startActivity(intentToDetail)
            }
        })
    }
}