package com.example.android.sample.testapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import com.twitter.sdk.android.core.*
import com.twitter.sdk.android.core.models.Tweet
import com.twitter.sdk.android.tweetui.SearchTimeline
import com.twitter.sdk.android.tweetui.Timeline
import com.twitter.sdk.android.tweetui.TweetTimelineListAdapter


class SchooletwitterTimelineActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_schooletwitter_timeline)

        // 変数・配列の作成

        // パーツを取得
        val timelineList = findViewById<ListView>(R.id.timelineList) // GridView「facilityList」のIDを取得

        val searchTimeline = SearchTimeline.Builder()
            .query("#猫")
            .build()
        val adapter = TweetTimelineListAdapter.Builder(this)
            .setTimeline(searchTimeline)
            .build()
        timelineList.adapter = adapter


        // getHomeTimeline(timelineList)

    }


    private fun getHomeTimeline(list: ListView) {
        val twitteDatas = arrayListOf<String>()
        val twitterApiClient = TwitterCore.getInstance().apiClient
        val statusesService = twitterApiClient.statusesService

        val call = statusesService.homeTimeline(50, null, null, false, false, false, false)
        call.enqueue(object : Callback<List<Tweet>>() {
            override fun success(result: Result<List<Tweet>>?) { // 成功時の処理

                /*val timeline = arrayListOf<Timeline<Tweet>>()
                if (result != null) {
                    timeline..add(result.data[0])
                }

                val adapter = TweetTimelineListAdapter.Builder(this)
                    .setTimeline(timeline)
                    .build()
                /* if (result != null) {
                    val datas = result.data
                    for (data in datas) {
                        twitteDatas.add(data.text)
                    }
                }*/
                val adapter = ArrayAdapter<String>(this@SchooletwitterTimelineActivity, android.R.layout.simple_list_item_1, twitteDatas)
                list.adapter = adapter*/

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
