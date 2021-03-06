package com.example.android.sample.testapp

import android.app.ActivityOptions
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_bustime2.*

import java.util.*
import kotlin.concurrent.schedule


class BustimeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bustime2)
        //
        tytle.text="バスの時刻表"
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

        //

        setDateTime()
        var b0 = findViewById<Button>(R.id.b0)
        var b1 = findViewById<Button>(R.id.b1)
        var b2 = findViewById<Button>(R.id.b2)
        var b3 = findViewById<Button>(R.id.b3)
        // TextView の設定
        var image = findViewById<ImageView>(R.id.image);

        b0.setOnClickListener {
            image.setImageResource(R.drawable.bustime_minamino_school)
        }
        b1.setOnClickListener {
            image.setImageResource(R.drawable.bustime_hachiouji_school)
        }
        b2.setOnClickListener {
            image.setImageResource(R.drawable.bustime_school_minamino)
        }
        b3.setOnClickListener {
            image.setImageResource(R.drawable.bustime_school_hachiouji)
        }




    }






//時刻取得
    fun setDateTime() {
        Timer().schedule(0, 100) {
            //UI変更
            runOnUiThread {
                //曜日の配列
                // var week = arrayOf("", "日", "月", "火", "水", "木", "金", "土")
                //時間
                var calender = Calendar.getInstance()
                time_textview.text =
                    "${calender.get(Calendar.HOUR_OF_DAY)}時 ${calender.get(Calendar.MINUTE)}分 ${calender.get(
                        Calendar.SECOND
                    )}秒"


            }

        }


    }
}
