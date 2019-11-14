package com.example.android.sample.testapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridView



class FacilityListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_facility_list)
        // GridView「facilityList」のIDを取得
        val list = findViewById<GridView>(R.id.facilityList)
        // adapterを作成
        val adapter = FacilityListAdapter(this)
        // facilityListにadapterをセット
        list.adapter = adapter

    }
}
