package com.example.android.sample.testapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.net.Uri
import kotlinx.android.synthetic.main.activity_campusinfo.*




class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_campusinfo)

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
    }
}
