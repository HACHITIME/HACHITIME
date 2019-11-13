package com.example.android.sample.testapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.toolbar.*

class FacilityListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_facility_list)
        setContentView(R.layout.toolbar)
        tytle.text = "施設一覧"

        school_btn.setOnClickListener {
            val intent = Intent(this, FacilityListActivity::class.java)
            startActivity(intent)
        }

        map_btn.setOnClickListener {
            val intent = Intent(this, MapActivity::class.java)
            startActivity(intent)
        }

        stamp_btn.setOnClickListener {
            val intent = Intent(this, StampActivity::class.java)
            startActivity(intent)
        }

        info_btn.setOnClickListener {
            val intent = Intent(this, InfoActivity::class.java)
            startActivity(intent)
        }

        bus_btn.setOnClickListener {
            val intent = Intent(this, BustimeActivity::class.java)
            startActivity(intent)
        }

        modol_btn.setOnClickListener {
            super.onBackPressed()
        }

    }


}
