package com.example.android.sample.testapp

import android.app.ActivityOptions
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import com.twitter.sdk.android.core.*
import com.twitter.sdk.android.core.models.Tweet
import com.twitter.sdk.android.tweetui.SearchTimeline
import com.twitter.sdk.android.tweetui.TweetTimelineListAdapter
import kotlinx.android.synthetic.main.activity_schooletwitter_timeline.bus_btn
import kotlinx.android.synthetic.main.activity_schooletwitter_timeline.info_btn
import kotlinx.android.synthetic.main.activity_schooletwitter_timeline.map_btn
import kotlinx.android.synthetic.main.activity_schooletwitter_timeline.modol_btn
import kotlinx.android.synthetic.main.activity_schooletwitter_timeline.school_btn
import kotlinx.android.synthetic.main.activity_schooletwitter_timeline.stamp_btn
import kotlinx.android.synthetic.main.activity_schooletwitter_timeline.tytle
import com.twitter.sdk.android.core.TwitterException



class SchooletwitterTimelineActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_schooletwitter_timeline)
        tytle.text = "関連Tweet"

        // 変数・配列の作成

        // パーツを取得
        val timelineList = findViewById<ListView>(R.id.timelineList) // GridView「facilityList」のIDを取得

        /*
        // このファクトリインスタンスは再利用可能でスレッドセーフです
        val twitter = TwitterFactory.getSingleton()
        val statuses = twitter.getHomeTimeline()
        println("Showing home timeline.")
            for (status in statuses) {
                println(status.getUser().getName() + ":" + status.getText()
            )
        }
        */
        

        /*
        val myLayout = findViewById<LinearLayout>(R.id.test)

        val tweetIds = Arrays.asList(510908133917487104L, 20L)

        TweetUtils.loadTweets(tweetIds, Load//LoadCallback<Tweet> {
            override fun success(tweet: Tweet) {

                myLayout.addView(
                    CompactTweetView(
                        this@SchooletwitterTimelineActivity,
                        tweet
                    )
                )

            }

            override fun failure(exception: TwitterException) {
                // Toast.makeText(...).show();
            }
        })
        */



        val searchTimeline = SearchTimeline.Builder()
            .query("#日本工学院")
            .build()
        val adapter = TweetTimelineListAdapter.Builder(this)
            .setTimeline(searchTimeline)
            .build()
        timelineList.adapter = adapter


        // getHomeTimeline(timelineList)


        // ツールバータップ時の処理
        school_btn.setOnClickListener {
            val intent = Intent(this, FacilityListActivity::class.java)
            // 同一アクティビティ開始時、古い方を終了させる
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent,
                ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }

        map_btn.setOnClickListener {
            val intent = Intent(this, MapActivity::class.java)
            // 同一アクティビティ開始時、古い方を終了させる
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent,
                ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }

        stamp_btn.setOnClickListener {
            val intent = Intent(this, StampActivity::class.java)
            // 同一アクティビティ開始時、古い方を終了させる
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent,
                ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }

        info_btn.setOnClickListener {
            val intent = Intent(this, CampusInfoActivity::class.java)
            // 同一アクティビティ開始時、古い方を終了させる
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent,
                ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }

        bus_btn.setOnClickListener {
            val intent = Intent(this, BustimeActivity::class.java)
            // 同一アクティビティ開始時、古い方を終了させる
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent,
                ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }

        modol_btn.setOnClickListener {
            super.onBackPressed()
        }
    }


    private fun getHomeTimeline(list: ListView) {
        val twitteDatas = arrayListOf<String>()
        val twitterApiClient = TwitterCore.getInstance().apiClient
        val statusesService = twitterApiClient.statusesService

        val call = statusesService.homeTimeline(50, null, null, false, false, false, false)
        call.enqueue(object : Callback<List<Tweet>>() {
            override fun success(result: Result<List<Tweet>>?) { // 成功時の処理


                /*
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

                /*val adapter = TweetViewFetchAdapter<CompactTweetView>(
                    this@SchooletwitterTimelineActivity
                )

                val searchTimeline = SearchTimeline.Builder()
                    .query("#日本工学院")
                    .build()

                val adapter = TweetTimelineListAdapter.Builder(this@SchooletwitterTimelineActivity)
                    .setTimeline(searchTimeline)
                    .build()
                timelineList.adapter = adapter*/

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
