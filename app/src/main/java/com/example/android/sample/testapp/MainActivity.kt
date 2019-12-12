package com.example.android.sample.testapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_stamp.*


open class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stamp)

        imageView7.setOnClickListener {
            // スタンプ詳細ダイアログをを表示
            val dialog = HopupDialog()
            dialog.show(supportFragmentManager, "simple")

        }




    }

}
