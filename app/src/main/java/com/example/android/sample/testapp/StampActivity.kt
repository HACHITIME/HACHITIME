package com.example.android.sample.testapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_stamp.*


open class StampActivity : AppCompatActivity() {
    var itcare = 0
    var desain =0
    var kanngo=0
    var kurieita=0
    var music =0
    var sports=0
    var technology =0
    // ifの普通の使い方



    val stampName = arrayListOf("展示棟","図書館棟","講義棟A","体育館","メディアホール","片柳記念ホール","片柳研究棟")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stamp)
        // ITぱっちぃの表示
        if (itcare==0){
            val imageView3 = findViewById<ImageView>(R.id.imageView3)
            imageView3.setImageResource(R.drawable.unknown_it)

 }else{

            imageView2.setImageResource(R.drawable.fukidasimusic)
        }

        //デザインぱっちぃの表示
        if ( desain==0){
            val imageView7 = findViewById<ImageView>(R.id.imageView7)
            imageView7.setImageResource(R.drawable.unknown_desain)
//半透明にする処理
        }else{
            //ちゃんと表示させる
            imageView2.setImageResource(R.drawable.fukidasi_desain)
        }
//看護ぱっちぃの表示
        if ( kanngo==0){
            val imageView6 = findViewById<ImageView>(R.id.imageView6)
            imageView6.setImageResource(R.drawable.unknown_iryou)

        }else{

            imageView6.setImageResource(R.drawable.fikidasai_iryou)
        }
        //クリエイティブぱっちぃの表示
        if ( kurieita==0){
            val imageView2 = findViewById<ImageView>(R.id.imageView2)
            imageView2.setImageResource(R.drawable.unknown_crepachii)

        }else{

            imageView2.setImageResource(R.drawable.fukidasi_crepachii)
        }
        //音楽ぱっちぃの表示
        if ( music==0){
            val imageView5 = findViewById<ImageView>(R.id.imageView5)
            imageView5.setImageResource(R.drawable.unknown_music)

        }else{

            imageView5.setImageResource(R.drawable.fukidasimusic)
        }
        //スポーツぱっちぃの表示
        if ( sports==0){
            val imageView4 = findViewById<ImageView>(R.id.imageView4)
            imageView4.setImageResource(R.drawable.unknown_sports)

        }else{

            imageView2.setImageResource(R.drawable.fukidasaisports)
        }
        //テクノロジーぱっちぃの表示
        if ( technology==0){
            val imageView = findViewById<ImageView>(R.id.imageView)
            imageView.setImageResource(R.drawable.unknown_tecno)

        }else{

            imageView.setImageResource(R.drawable.fukidasitecno)
        }





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
        button.setOnClickListener {
            // スタンプ詳細ダイアログをを表示
            desain =1
            if ( desain==0){
                val imageView7 = findViewById<ImageView>(R.id.imageView7)
                imageView7.setImageResource(R.drawable.unknown_desain)
//半透明にする処理
            }else{
                //ちゃんと表示させる
                imageView2.setImageResource(R.drawable.fukidasi_desain)
            }
            if(desain==0&&kanngo==0&&kurieita==0&&music==0&&sports==0&&technology==0){

//半透明にする処理
            }else{
                //ちゃんと表示させる
            }


        }
        imageView6.setOnClickListener {
            // スタンプ詳細ダイアログをを表示
            val dialog = HopupDialog()
            // スタンプ詳細を渡す
            val args = Bundle()
            dialog.setArguments(args)
            dialog.show(supportFragmentManager, "simple")

        }


        fun test(){


        }
                 //変数の作成
        fun ITpacchi(view: View){
            //Intentのインスタンスを作成
            val intent = Intent(this, MapActivity::class.java)
            //textは受け渡す変数
            val ITpacchi = 1
            //intent変数をつなげる(第一引数はキー，第二引数は渡したい変数)
            intent.putExtra("TEXT_KEY1",itcare)
                     intent.putExtra("TEXT_KEY2",itcare)
                     intent.putExtra("TEXT_KEY3",desain)
                     intent.putExtra("TEXT_KEY4",kanngo)
                     intent.putExtra("TEXT_KEY5",kurieita)
                     intent.putExtra("TEXT_KEY6",music)
                     intent.putExtra("TEXT_KEY7",technology)

        }
        //受け取った変数を入れる
        val ITpacchi = intent.getStringExtra("TEXT_KEY1")





    }




}