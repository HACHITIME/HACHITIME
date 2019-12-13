package com.example.android.sample.testapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.GridView
import android.widget.ListView
import com.nifcloud.mbaas.core.NCMB
import com.nifcloud.mbaas.core.NCMBObject
import com.nifcloud.mbaas.core.NCMBQuery

class InterviewListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_interview_list)

        // 変数・配列の作成
        val studentImage = arrayListOf<String>() // 施設画像名
        val studentName = arrayListOf<String>() // 施設名
        val studentSubject = arrayListOf<String>() // 施設詳細
        val objectId = arrayListOf<String>() // 学生ID
        // パーツを取得
        val list = findViewById<ListView>(R.id.interviewList) // GridView「facilityList」のIDを取得

        // 初期化
        NCMB.initialize(applicationContext,
            "d08392d55ee52427791b8cf068a24b9d3e0beab2329496ffdd7a1f71b08e8155",
            "04cd049bf76af6543ddfcc9b879f42ab643d44b2a2100f75a2818e72c47c2f8f")

        // FacilityMasterから施設情報を取得する
        val queryInterviewData = NCMBQuery<NCMBObject>("InterviewData")
        queryInterviewData.whereEqualTo("collegeId", intent.getStringExtra("PICK_ID"))
        queryInterviewData.findInBackground { objects, e ->
            if (e != null) {
                // エラー
                Log.d("[Error]", e.toString())
            } else {
                // 成功
                for (obj in objects) {
                    // DBからの取得情報を配列へ追加
                    studentImage.add(obj.getString("studentImage"))
                    studentName.add(obj.getString("studentName"))
                    studentSubject.add(obj.getString("subject"))
                    objectId.add(obj.getString("objectId"))
                }
                // interviewListのadapterを作成
                val adapterInterviewList = InterviewListAdapter(this, studentImage, studentName, studentSubject, objectId)
                // facilityListにadapterをセット
                list.adapter = adapterInterviewList
            }
        }
    }
}
