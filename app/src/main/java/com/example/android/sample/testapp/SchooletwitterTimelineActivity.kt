package com.example.android.sample.testapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import com.twitter.sdk.android.core.*
import com.twitter.sdk.android.core.models.Tweet


class SchooletwitterTimelineActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_schooletwitter_timeline)

        // 変数・配列の作成

        // パーツを取得
        val timelineList = findViewById<ListView>(R.id.timelineList) // GridView「facilityList」のIDを取得


        getHomeTimeline(timelineList)
        /*
         val fab = findViewById(R.id.fab) as FloatingActionButton

        fab.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
            }
        })
        */
    }


    private fun getHomeTimeline(list: ListView) {
        val twitteDatas = arrayListOf<String>()
        val twitterApiClient = TwitterCore.getInstance().apiClient
        val statusesService = twitterApiClient.statusesService

        val call = statusesService.homeTimeline(50, null, null, false, false, false, false)
        call.enqueue(object : Callback<List<Tweet>>() {
            override fun success(result: Result<List<Tweet>>?) { // 成功時の処理
                if (result != null) {
                    val datas = result.data
                    for (data in datas) {
                        twitteDatas.add(data.text)
                    }
                }
                val adapter = ArrayAdapter<String>(this@SchooletwitterTimelineActivity, android.R.layout.simple_list_item_1, twitteDatas)
                list.adapter = adapter

                val toast = Toast.makeText(this@SchooletwitterTimelineActivity, "タイムライン取得成功", Toast.LENGTH_LONG)
                toast.show()
            }

            override fun failure(exception: TwitterException) { // 失敗時の処理
                val toast = Toast.makeText(this@SchooletwitterTimelineActivity, "タイムライン取得エラー", Toast.LENGTH_LONG)
                toast.show()
            }
        })
    }
}
