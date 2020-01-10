package com.example.android.sample.testapp

import android.app.ActivityOptions
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_calender.*
import kotlinx.android.synthetic.main.activity_calender.bus_btn
import kotlinx.android.synthetic.main.activity_calender.info_btn
import kotlinx.android.synthetic.main.activity_calender.map_btn
import kotlinx.android.synthetic.main.activity_calender.modol_btn
import kotlinx.android.synthetic.main.activity_calender.stamp_btn
import kotlinx.android.synthetic.main.activity_campusinfo.*

class DocumentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_document)

        webview.setWebViewClient(WebViewClient())
        webview.loadUrl("https://www.neec.ac.jp/cgi-bin/requests.php?type=0")

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

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        // 戻るボタンが押される かつ webviewで前に戻ることができるとき
        if (keyCode == KeyEvent.KEYCODE_BACK && webview.canGoBack()) {
            // 前のページに戻る
            webview.goBack()
            return true
        }

        return super.onKeyDown(keyCode, event)
    }
}
