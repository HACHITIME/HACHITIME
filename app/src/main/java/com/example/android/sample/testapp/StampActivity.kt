package com.example.android.sample.testapp


import android.Manifest
import android.app.ActivityOptions
import android.content.ContentValues
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.view.View
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_stamp.*
import java.io.File
import java.io.FileOutputStream


open class StampActivity : AppCompatActivity() {
    var itcare = 0
    var desain =0
    var kanngo=0
    var kurieita=0
    var music =0
    var sports=0
    var technology =0
    var goukei = 7-itcare-desain-kanngo-kurieita-music-sports-technology
    val stampName = arrayListOf("展示棟","図書館棟","講義棟A","体育館","メディアホール","片柳記念ホール","片柳研究棟","")
    val syutoku= arrayListOf("獲得状況：未取得","取得状況：取得済み")
    /*interview(1)~(7)
    var syutoku_id=0
    var syutoku_id7=0
     */







    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stamp)
        tytle.text = "スタンプラリー"

        //下のツールバー処理・戻るボタン処理
        school_btn.setOnClickListener {
            val intent = Intent(this, FacilityListActivity::class.java)
            // 同一アクティビティ開始時、古い方を終了させる
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent,
                ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }
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
            //intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
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

        //スタンプ７個を押した時のアクション
        imageView.setOnClickListener {
            // スタンプ詳細ダイアログをを表示
            val dialog = HopupDialog()
            // 画像をidに変換
            val imgId = resources.getIdentifier(
                "namami_unknown_tecnoo",
                "drawable",
                packageName
            )

            val imgId2 = resources.getIdentifier(
                "tecnoroji",
                "drawable",
                packageName
            )
            // スタンプ詳細を渡す
            val args = Bundle(0)
            dialog.setArguments(args)
            args.putString("stamp_name", stampName[0])
            //取得状況を渡す
            args.putString("syutoku", syutoku[technology])

            //取得id判定　1なら明るい画像を出す
            if(technology==1) {
                args.putInt("stamp_image", imgId2)
            }else{
                args.putInt("stamp_image", imgId)
            }
            dialog.show(supportFragmentManager, "simple")
        }
        imageView2.setOnClickListener {
            // スタンプ詳細ダイアログをを表示
            val dialog = HopupDialog()
            // 画像をidに変換
            val imgId = resources.getIdentifier(
                "namami_unknown_cre",
                "drawable",
                packageName)

            val imgId2 = resources.getIdentifier(
                "curieita",
                "drawable",
                packageName)

            // スタンプ詳細を渡す
            val args = Bundle()
            dialog.setArguments(args)
            args.putString("stamp_name", stampName[1])
            //取得状況を渡す
            args.putString("syutoku", syutoku[kurieita])

            //取得id判定　1なら明るい画像を出す
            if(kurieita==1) {
                args.putInt("stamp_image", imgId2)
            }else{
                args.putInt("stamp_image", imgId)
            }
            dialog.show(supportFragmentManager, "simple")
        }
        imageView3.setOnClickListener {
            // スタンプ詳細ダイアログをを表示
            val dialog = HopupDialog()
            // 画像をidに変換
            val imgId = resources.getIdentifier(
                "namami_unknown_it",
                "drawable",
                packageName
            )

            val imgId2 = resources.getIdentifier(
                "it",
                "drawable",
                packageName
            )
            // スタンプ詳細を渡す
            val args = Bundle()
            dialog.setArguments(args)
            args.putString("stamp_name", stampName[2])
            //取得状況を渡す
            args.putString("syutoku", syutoku[itcare])
            //取得id判定　1なら明るい画像を出す
            if(itcare==1) {
                args.putInt("stamp_image", imgId2)
            }else{
                args.putInt("stamp_image", imgId)
            }
            dialog.show(supportFragmentManager, "simple")
        }
        imageView4.setOnClickListener {
            // スタンプ詳細ダイアログをを表示
            val dialog = HopupDialog()
            // 画像をidに変換
            val imgId = resources.getIdentifier(
                "namami_unknown_sports",
                "drawable",
                packageName
            )

            val imgId2 = resources.getIdentifier(
                "sports",
                "drawable",
                packageName
            )
            // スタンプ詳細を渡す
            val args = Bundle()
            dialog.setArguments(args)
            args.putString("stamp_name", stampName[3])
            //取得状況を渡す
            args.putString("syutoku", syutoku[sports])
            //取得id判定　1なら明るい画像を出す
            if(sports==1) {
                args.putInt("stamp_image", imgId2)
            }else{
                args.putInt("stamp_image", imgId)
            }
            dialog.show(supportFragmentManager, "simple")
        }
        imageView5.setOnClickListener {
            // スタンプ詳細ダイアログをを表示
            val dialog = HopupDialog()
            // 画像をidに変換
            val imgId = resources.getIdentifier(
                "namami_unknown_music",
                "drawable",
                packageName
            )

            val imgId2 = resources.getIdentifier(
                "music",
                "drawable",
                packageName
            )
            // スタンプ詳細を渡す
            val args = Bundle()
            dialog.setArguments(args)
            args.putString("stamp_name", stampName[4])
            //取得状況を渡す
            args.putString("syutoku", syutoku[music])
            //取得id判定　1なら明るい画像を出す
            if(music==1) {
                args.putInt("stamp_image", imgId2)
            }else{
                args.putInt("stamp_image", imgId)
            }
            dialog.show(supportFragmentManager, "simple")
        }
        imageView6.setOnClickListener {
            // スタンプ詳細ダイアログをを表示
            val dialog = HopupDialog()
            // 画像をidに変換
            val imgId = resources.getIdentifier(
                "namami_unknown_iryou",
                "drawable",
                packageName
            )

            val imgId2 = resources.getIdentifier(
                "iryou",
                "drawable",
                packageName
            )
            // スタンプ詳細を渡す
            val args = Bundle()
            dialog.setArguments(args)
            args.putString("stamp_name", stampName[5])
            //取得状況を渡す
            args.putString("syutoku", syutoku[kanngo])
            //取得id判定　1なら明るい画像を出す
            if(kanngo==1) {
                args.putInt("stamp_image", imgId2)
            }else{
                args.putInt("stamp_image", imgId)
            }
            dialog.show(supportFragmentManager, "simple")
        }
        imageView7.setOnClickListener {
            // スタンプ詳細ダイアログをを表示
            val dialog = HopupDialog()
            // 画像をidに変換
            val imgId = resources.getIdentifier(
            "namami_unknown_desain",
            "drawable",
            packageName
        )
            val imgId2 = resources.getIdentifier(
                "desain",
                "drawable",
                packageName
            )
            // スタンプ詳細を渡す
            val args = Bundle()
            dialog.setArguments(args)
            args.putString("stamp_name", stampName[6])
            args.putInt("stamp_image", imgId)
            //取得状況を渡す
            args.putString("syutoku", syutoku[desain])
            //取得id判定　1なら明るい画像を出す
            if(desain==1) {
                args.putInt("stamp_image", imgId2)
            }else{
                args.putInt("stamp_image", imgId)
            }
            dialog.show(supportFragmentManager, "simple")
        }

        // ITぱっちぃの表示
        if (itcare==0){
            val imageView3 = findViewById<ImageView>(R.id.imageView3)
            imageView3.setImageResource(R.drawable.unknown_it)

 }else{

            imageView2.setImageResource(R.drawable.fukidasi_music)
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

            imageView6.setImageResource(R.drawable.fukidasi_iryou)
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

            imageView5.setImageResource(R.drawable.fukidasi_music)
        }
        //スポーツぱっちぃの表示
        if ( sports==0){
            val imageView4 = findViewById<ImageView>(R.id.imageView4)
            imageView4.setImageResource(R.drawable.unknown_sports)

        }else{

            imageView2.setImageResource(R.drawable.fukidasisports)
        }
        //テクノロジーぱっちぃの表示
        if ( technology==0){
            val imageView = findViewById<ImageView>(R.id.imageView)
            imageView.setImageResource(R.drawable.unknown_tecno)

        }else{

            imageView.setImageResource(R.drawable.fukidasi_tecno)
        }






        button.setOnClickListener {
            // スタンプ詳細ダイアログをを表示
            kurieita = 1
            if ( kurieita==1){
                //ちゃんと表示させる
                imageView2.setImageResource(R.drawable.fukidasi_crepachii)
                //合計値の更新
                goukei = 7-itcare-desain-kanngo-kurieita-music-sports-technology
                textView2.setText("あとスタンプを"+goukei+"個ゲット")
                //
                //取得IDを１にする（未取得から取得済み状態にする）それぞれに適応したsyutoku_idを入れる
                //syutoku_id2=1
//半透明にする処理
            }else{
                val imageView2 = findViewById<ImageView>(R.id.imageView2)
                imageView2.setImageResource(R.drawable.unknown_crepachii)

            }



        }

        button2.setOnClickListener {
            itcare = 1
            desain =1
            kanngo=1
            kurieita=1
            music =1
            sports=1
            technology =1
            goukei =0

            textView2.setText("特典画像をGET!!")

            /*
            val dialog = CompleteDialog()
            val args = Bundle()
            dialog.setArguments(args)
            args.putString("stamp_name", stampName[7])
            dialog.show(supportFragmentManager, "simple")
             */

            imageView.setImageResource(R.drawable.fukidasi_tecno)
            imageView2.setImageResource(R.drawable.fukidasi_crepachii)
            imageView3.setImageResource(R.drawable.fukidasi_it)
            imageView4.setImageResource(R.drawable.fukidasisports)
            imageView5.setImageResource(R.drawable.fukidasi_music)
            imageView6.setImageResource(R.drawable.fukidasi_iryou)
            imageView7.setImageResource(R.drawable.fukidasi_desain)


        }

        button3.setOnClickListener {
            itcare = 0
            desain =0
            kanngo=0
            kurieita=0
            music =0
            sports=0
            technology =0
            goukei=7

            textView2.setText("あとスタンプを"+goukei+"個ゲット")

            imageView.setImageResource(R.drawable.unknown_tecno)
            imageView2.setImageResource(R.drawable.unknown_crepachii)
            imageView3.setImageResource(R.drawable.unknown_it)
            imageView4.setImageResource(R.drawable.unknown_sports)
            imageView5.setImageResource(R.drawable.unknown_music)
            imageView6.setImageResource(R.drawable.unknown_iryou)
            imageView7.setImageResource(R.drawable.unknown_desain)
        }

        textView2.setOnClickListener {
            if(goukei==0){
                /*
                val dialog = CompleteDialog()
                val args = Bundle()
                dialog.setArguments(args)
                args.putString("stamp_name", stampName[7])
                dialog.show(supportFragmentManager, "simple")*/

                val intent = Intent(this, CompleteActivity::class.java)
                startActivity(intent,
                    ActivityOptions.makeSceneTransitionAnimation(this).toBundle())


            }else{

            }
        }

        if(goukei==0){
            textView2.setText("特典画像をGET!!")
            val dialog = CompleteDialog()
            dialog.show(supportFragmentManager, "simple")
            //半透明にする処理
        }else{
            //ちゃんと表示させる
            textView2.setText("あとスタンプを"+goukei+"個ゲット")
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






