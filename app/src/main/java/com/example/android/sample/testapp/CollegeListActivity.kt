package com.example.android.sample.testapp

import android.app.ActivityOptions
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.GridView
import com.nifcloud.mbaas.core.NCMB
import com.nifcloud.mbaas.core.NCMBObject
import com.nifcloud.mbaas.core.NCMBQuery

class CollegeListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_college_list_activity)

        /** 変数・配列の作成 **/
        val collegeId = arrayListOf<String>()
        val collegeName = arrayListOf<String>()

        /** パーツの取得 **/
        val collegeList = findViewById<GridView>(R.id.collegeList) // カレッジ名

        /** カレッジ情報をDBから取得 **/
        // 初期化
        NCMB.initialize(applicationContext,
            "d08392d55ee52427791b8cf068a24b9d3e0beab2329496ffdd7a1f71b08e8155",
            "04cd049bf76af6543ddfcc9b879f42ab643d44b2a2100f75a2818e72c47c2f8f")
        // CollegeMasterから施設情報を取得する
        val query = NCMBQuery<NCMBObject>("CollegeMaster")
        query.findInBackground { objects, e ->
            if (e != null) {
                // エラー
                Log.d("[Error]", e.toString())
            } else {
                // 成功
                for (obj in objects) {
                    // DBからの取得情報を配列へ追加
                    collegeId.add(obj.getString("objectId"))
                    collegeName.add(obj.getString("collegeName") + "\nカレッジ")
                }
                // adapterを作成
                val adapter = CollegeListAdapter(this, collegeName)
                // facilityListにadapterをセット
                collegeList.adapter = adapter
            }
        }

        // collegeListの要素取選択時の処理
        collegeList.setOnItemClickListener { adapterView, _, position, _ ->
            val intent = Intent(application, InterviewListActivity::class.java)
            // 同一アクティビティ開始時、古い方を終了させる
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            // 施設情報を渡す
            intent.putExtra("PICK_ID", collegeId[position])
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }
    }
}
