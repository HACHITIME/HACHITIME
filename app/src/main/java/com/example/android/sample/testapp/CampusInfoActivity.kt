package com.example.android.sample.testapp

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_campusinfo.*

class CampusInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_campusinfo)
        tytle.text = "Information"

        //各ボタンの遷移
        ivent_btn.setOnClickListener {
            val intent = Intent(this, CalenderActivity::class.java)
            startActivity(intent)
        }

        subject_btn.setOnClickListener {
            val intent = Intent(this, SubjectActivity::class.java)
            startActivity(intent)
        }

        interview_btn.setOnClickListener {
            val intent = Intent(this, InterviewActivity::class.java)
            startActivity(intent)
        }

        document_btn.setOnClickListener {
            val intent = Intent(this, DocumentActivity::class.java)
            startActivity(intent)
        }

        school_btn.setOnClickListener {
            val intent = Intent(this, FacilityListActivity::class.java)
            // 同一アクティビティ開始時、古い方を終了させる
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent,
                ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }

        //ツールバー
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
}