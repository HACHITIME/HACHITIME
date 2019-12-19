package com.example.android.sample.testapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_stamp.*


open class StampActivity : AppCompatActivity() {

    val stampName = arrayListOf("展示棟","図書館棟","講義棟A","体育館","メディアホール","片柳記念ホール","片柳研究棟")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stamp)


        //スタンプ７個を押した時のアクション
        imageView.setOnClickListener {
            // スタンプ詳細ダイアログをを表示
            val dialog = HopupDialog()
            // 画像をidに変換
            val imgId = resources.getIdentifier(
                "tecnoroji",
                "drawable",
                packageName
            )

            // スタンプ詳細を渡す
            val args = Bundle(0)
            dialog.setArguments(args)
            args.putString("stamp_name", stampName[0])
            args.putInt("stamp_image", imgId)
            dialog.show(supportFragmentManager, "simple")

        }

        imageView2.setOnClickListener {
            // スタンプ詳細ダイアログをを表示
            val dialog = HopupDialog()
            // 画像をidに変換
            val imgId = resources.getIdentifier(
                "curieita",
                "drawable",
                packageName
            )
            // スタンプ詳細を渡す
            val args = Bundle()
            dialog.setArguments(args)
            args.putString("stamp_name", stampName[1])
            args.putInt("stamp_image", imgId)
            dialog.show(supportFragmentManager, "simple")

        }

        imageView3.setOnClickListener {
            // スタンプ詳細ダイアログをを表示
            val dialog = HopupDialog()
            // 画像をidに変換
            val imgId = resources.getIdentifier(
                "it",
                "drawable",
                packageName
            )
            // スタンプ詳細を渡す
            val args = Bundle()
            dialog.setArguments(args)
            args.putString("stamp_name", stampName[2])
            args.putInt("stamp_image", imgId)
            dialog.show(supportFragmentManager, "simple")

        }

        imageView4.setOnClickListener {
            // スタンプ詳細ダイアログをを表示
            val dialog = HopupDialog()
            // 画像をidに変換
            val imgId = resources.getIdentifier(
                "sports",
                "drawable",
                packageName
            )
            // スタンプ詳細を渡す
            val args = Bundle()
            dialog.setArguments(args)
            args.putString("stamp_name", stampName[3])
            args.putInt("stamp_image", imgId)
            dialog.show(supportFragmentManager, "simple")

        }

        imageView5.setOnClickListener {
            // スタンプ詳細ダイアログをを表示
            val dialog = HopupDialog()
            // 画像をidに変換
            val imgId = resources.getIdentifier(
                "music",
                "drawable",
                packageName
            )
            // スタンプ詳細を渡す
            val args = Bundle()
            dialog.setArguments(args)
            args.putString("stamp_name", stampName[4])
            args.putInt("stamp_image", imgId)
            dialog.show(supportFragmentManager, "simple")

        }

        imageView6.setOnClickListener {
            // スタンプ詳細ダイアログをを表示
            val dialog = HopupDialog()
            // 画像をidに変換
            val imgId = resources.getIdentifier(
                "iryou",
                "drawable",
                packageName
            )
            // スタンプ詳細を渡す
            val args = Bundle()
            dialog.setArguments(args)
            args.putString("stamp_name", stampName[5])
            args.putInt("stamp_image", imgId)
            dialog.show(supportFragmentManager, "simple")

        }

        imageView7.setOnClickListener {
            // スタンプ詳細ダイアログをを表示
            val dialog = HopupDialog()
            // 画像をidに変換
            val imgId = resources.getIdentifier(
                "desain",
                "drawable",
                packageName
            )
            // スタンプ詳細を渡す
            val args = Bundle()
            args.putString("stamp_name", stampName[6])
            args.putInt("stamp_image", imgId)
            dialog.setArguments(args)
            dialog.show(supportFragmentManager, "simple")

        }






    }

}