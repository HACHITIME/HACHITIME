package com.example.android.sample.testapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_calender.*

class DocumentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_document)

        webview.setWebViewClient(WebViewClient())
        webview.loadUrl("https://www.neec.ac.jp/cgi-bin/requests.php?type=0")


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
