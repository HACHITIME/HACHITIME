package com.example.android.sample.testapp

import android.media.Image
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.GridView
import android.widget.TextView
import com.nifcloud.mbaas.core.*


class FacilityListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_facility_list)

        val facilityName = arrayListOf<String>()    // 施設名を入れる配列
        val facilityImage = arrayListOf<String>() // 施設画像名を入れる配列
        // val id = resources.getIdentifier("facility_list_bijyutukan", "drawable", packageName)

        // 初期化
        NCMB.initialize(applicationContext,
            "d08392d55ee52427791b8cf068a24b9d3e0beab2329496ffdd7a1f71b08e8155",
            "04cd049bf76af6543ddfcc9b879f42ab643d44b2a2100f75a2818e72c47c2f8f")
        // FacilityMasterから施設情報を取得する
        val query = NCMBQuery<NCMBObject>("FacilityMaster")
        query.findInBackground { objects, e ->
            if (e != null) {
                // エラー
                Log.d("[Error]", e.toString())
            } else {
                // 取得
                for (obj in objects) {
                    facilityName.add(obj.getString("facilityName"))
                    facilityImage.add(obj.getString("facilityImage"))
                }
                // GridView「facilityList」のIDを取得
                val list = findViewById<GridView>(R.id.facilityList)
                // adapterを作成
                val adapter = FacilityListAdapter(this, facilityName, facilityImage)
                // facilityListにadapterをセット
                list.adapter = adapter
            }
        }

    }
}
