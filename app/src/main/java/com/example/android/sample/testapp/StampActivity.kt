package com.example.android.sample.testapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_stamp.*


open class StampActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stamp)

        imageView.setOnClickListener {
            // スタンプ詳細ダイアログをを表示
            val dialog = HopupDialog()
            // スタンプ詳細を渡す
            val args = Bundle(0)
            dialog.setArguments(args)
            dialog.show(supportFragmentManager, "simple")

        }

        imageView2.setOnClickListener {
            // スタンプ詳細ダイアログをを表示
            val dialog = HopupDialog()
            // スタンプ詳細を渡す
            val args = Bundle()
            dialog.setArguments(args)
            dialog.show(supportFragmentManager, "simple")

        }

        imageView3.setOnClickListener {
            // スタンプ詳細ダイアログをを表示
            val dialog = HopupDialog()
            // スタンプ詳細を渡す
            val args = Bundle()
            dialog.setArguments(args)
            dialog.show(supportFragmentManager, "simple")

        }

        imageView4.setOnClickListener {
            // スタンプ詳細ダイアログをを表示
            val dialog = HopupDialog()
            // スタンプ詳細を渡す
            val args = Bundle()
            dialog.setArguments(args)
            dialog.show(supportFragmentManager, "simple")

        }

        imageView5.setOnClickListener {
            // スタンプ詳細ダイアログをを表示
            val dialog = HopupDialog()
            // スタンプ詳細を渡す
            val args = Bundle()
            dialog.setArguments(args)
            dialog.show(supportFragmentManager, "simple")

        }

        imageView6.setOnClickListener {
            // スタンプ詳細ダイアログをを表示
            val dialog = HopupDialog()
            // スタンプ詳細を渡す
            val args = Bundle()
            dialog.setArguments(args)
            dialog.show(supportFragmentManager, "simple")

        }

        imageView7.setOnClickListener {
            // スタンプ詳細ダイアログをを表示
            val dialog = HopupDialog()
            // スタンプ詳細を渡す
            val args = Bundle()
            dialog.setArguments(args)
            dialog.show(supportFragmentManager, "simple")

        }






    }

}