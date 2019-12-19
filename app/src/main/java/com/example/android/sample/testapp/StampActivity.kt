package com.example.android.sample.testapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_stamp.*


open class StampActivity : AppCompatActivity() {

    val stampName = arrayListOf<String>("展示棟","図書館棟","講義棟A","体育館","メディアホール","片柳記念ホール","片柳研究棟")
    val stampImage= arrayListOf<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stamp)

        imageView.setOnClickListener {
            // スタンプ詳細ダイアログをを表示
            val dialog = HopupDialog()
            // スタンプ詳細を渡す
            val args = Bundle(0)
            dialog.setArguments(args)
            args.putString("stamp_name", stampName[0])
            args.putString("stamp_image", stampImage[0])
            dialog.show(supportFragmentManager, "simple")

        }

        imageView2.setOnClickListener {
            // スタンプ詳細ダイアログをを表示
            val dialog = HopupDialog()
            // スタンプ詳細を渡す
            val args = Bundle()
            dialog.setArguments(args)
            args.putString("stamp_name", stampName[1])
            args.putString("stamp_image", stampImage[1])
            dialog.show(supportFragmentManager, "simple")

        }

        imageView3.setOnClickListener {
            // スタンプ詳細ダイアログをを表示
            val dialog = HopupDialog()
            // スタンプ詳細を渡す
            val args = Bundle()
            dialog.setArguments(args)
            args.putString("stamp_name", stampName[2])
            args.putString("stamp_image", stampImage[2])
            dialog.show(supportFragmentManager, "simple")

        }

        imageView4.setOnClickListener {
            // スタンプ詳細ダイアログをを表示
            val dialog = HopupDialog()
            // スタンプ詳細を渡す
            val args = Bundle()
            dialog.setArguments(args)
            args.putString("stamp_name", stampName[3])
            args.putString("stamp_image", stampImage[3])
            dialog.show(supportFragmentManager, "simple")

        }

        imageView5.setOnClickListener {
            // スタンプ詳細ダイアログをを表示
            val dialog = HopupDialog()
            // スタンプ詳細を渡す
            val args = Bundle()
            dialog.setArguments(args)
            args.putString("stamp_name", stampName[4])
            args.putString("stamp_image", stampImage[4])
            dialog.show(supportFragmentManager, "simple")

        }

        imageView6.setOnClickListener {
            // スタンプ詳細ダイアログをを表示
            val dialog = HopupDialog()
            // スタンプ詳細を渡す
            val args = Bundle()
            dialog.setArguments(args)
            args.putString("stamp_name", stampName[5])
            args.putString("stamp_image", stampImage[5])
            dialog.show(supportFragmentManager, "simple")

        }

        imageView7.setOnClickListener {
            // スタンプ詳細ダイアログをを表示
            val dialog = HopupDialog()
            // スタンプ詳細を渡す
            val args = Bundle()
            args.putString("stamp_name", stampName[6])
            args.putString("stamp_image", stampImage[6])
            dialog.setArguments(args)
            dialog.show(supportFragmentManager, "simple")

        }






    }

}