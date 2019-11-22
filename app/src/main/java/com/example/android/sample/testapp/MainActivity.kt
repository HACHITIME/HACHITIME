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
            val uri = Uri.parse("https://www.neec.ac.jp/department/")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }

        interview_btn.setOnClickListener {
            val uri = Uri.parse("https://www.neec.ac.jp/contact/")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }

        document_btn.setOnClickListener {
            val uri = Uri.parse("https://www.neec.ac.jp/cgi-bin/requests.php?type=0")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }
    }
}
