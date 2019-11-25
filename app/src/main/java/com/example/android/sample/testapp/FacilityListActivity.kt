package com.example.android.sample.testapp

import android.app.ActivityOptions
import android.content.Intent
import android.media.Image
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.GridView
import android.widget.TextView
import android.widget.Toast
import com.nifcloud.mbaas.core.*
import kotlinx.android.synthetic.main.activity_facility_list.*
import java.util.*


class FacilityListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_facility_list)

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
        list.setOnItemClickListener { adapterView, _, position, _ ->
            /* テスト用
             Toast.makeText(this, "${adapterView.getItemAtPosition(position)} が選択されました", Toast.LENGTH_SHORT).show()
             */
            // 「facilityDetaile」へ遷移、施設情報を渡す
            val intent = Intent(application, FacilityDetaileActivity::class.java)
            intent.putExtra("PICK_ID", facilityId[position])
            intent.putExtra("PICK_NAME", facilityName[position])
            intent.putExtra("PICK_IMAGE", facilityImage[position])
            intent.putExtra("PICK_DETAILE", facilityDetaile[position])
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }
    }
}
