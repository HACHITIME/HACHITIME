package com.example.android.sample.testapp

import android.app.ActivityOptions
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.GridView
import com.nifcloud.mbaas.core.*
import kotlinx.android.synthetic.main.toolbar.*


class FacilityListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_facility_list)

        // タイトルを指定
        tytle.text = "施設一覧"
        // 変数・配列の作成
        val facilityId = arrayListOf<String>() // 施設ID
        val facilityName = arrayListOf<String>() // 施設名
        val facilityImage = arrayListOf<String>() // 施設画像名
        val facilityDetaile = arrayListOf<String>() // 施設詳細
        // パーツを取得
        val list = findViewById<GridView>(R.id.facilityList) // GridView「facilityList」のIDを取得

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
                // 成功
                for (obj in objects) {
                    // DBからの取得情報を配列へ追加
                    facilityId.add(obj.getString("objectId"))
                    facilityName.add(obj.getString("facilityName"))
                    facilityImage.add(obj.getString("facilityImage"))
                    facilityDetaile.add(obj.getString("facilityDetaile"))
                }
                // adapterを作成
                val adapter = FacilityListAdapter(this, facilityName, facilityImage)
                // facilityListにadapterをセット
                list.adapter = adapter
            }
        }

        // facilityListの要素取選択時の処理
        list.setOnItemClickListener { _, _, position, _ ->
            val intent = Intent(application, FacilityDetaileActivity::class.java)
            // 同一アクティビティ開始時、古い方を終了させる
            intent.flags = FLAG_ACTIVITY_CLEAR_TOP
            // 施設情報を渡す
            intent.putExtra("PICK_ID", facilityId[position])
            intent.putExtra("PICK_NAME", facilityName[position])
            intent.putExtra("PICK_IMAGE", facilityImage[position])
            intent.putExtra("PICK_DETAILE", facilityDetaile[position])
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }

        // ツールバータップ時の処理
        school_btn.setOnClickListener {
            val intent = Intent(this, FacilityListActivity::class.java)
            // 同一アクティビティ開始時、古い方を終了させる
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent,
                ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }

        map_btn.setOnClickListener {
            val intent = Intent(this, MapActivity::class.java)
            // 同一アクティビティ開始時、古い方を終了させる
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent,
                ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }

        stamp_btn.setOnClickListener {
            val intent = Intent(this, StampActivity::class.java)
            // 同一アクティビティ開始時、古い方を終了させる
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent,
                ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }

        info_btn.setOnClickListener {
            val intent = Intent(this, CampusInfoActivity::class.java)
            // 同一アクティビティ開始時、古い方を終了させる
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent,
                ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }

        bus_btn.setOnClickListener {
            val intent = Intent(this, BustimeActivity::class.java)
            // 同一アクティビティ開始時、古い方を終了させる
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent,
                ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }

        modol_btn.setOnClickListener {
            super.onBackPressed()
        }
    }
}
