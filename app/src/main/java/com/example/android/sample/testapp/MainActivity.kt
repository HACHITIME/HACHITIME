package com.example.android.sample.testapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.KeyEvent
import kotlinx.android.synthetic.main.toolbar.*

open class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.toolbar)

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
            super.onBackPressed( )
        }







    }

}
