package com.example.android.sample.testapp

import android.app.ActivityOptions
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.nifcloud.mbaas.core.*
import kotlinx.android.synthetic.main.toolbar.*


class FacilityDetaileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_facility_detaile)

        // タイトルを指定
        tytle.text = "施設詳細"
        // 変数・配列の作成
        val facilityName = arrayListOf<String>() // 取得した施設名
        val facilityImg = arrayListOf<String>() // 取得した施設画像
        val facilityDetaile = arrayListOf<String>() // 取得した施設詳細
        val stampImage = arrayListOf<String>() // 取得したスタンプ画像
        val stampName = arrayListOf<String>() // 取得したスタンプ名
        // パーツ を取得
        val facilityImgView = findViewById<ImageView>(R.id.facilityImage) // 施設画像
        val facilityNameView = findViewById<TextView>(R.id.facilityName) // 施設名称
        val facilityDetaileView = findViewById<TextView>(R.id.facilityDetaile) // 施設詳細
        val mapMoveButton: Button = findViewById(R.id.mapMoveButton) // 「マップで見る」ボタン
        val paccieIcon = findViewById<ImageButton>(R.id.paccieIcon) // ぱっちぃアイコン

        // 初期化
        NCMB.initialize(
            applicationContext,
            "d08392d55ee52427791b8cf068a24b9d3e0beab2329496ffdd7a1f71b08e8155",
            "04cd049bf76af6543ddfcc9b879f42ab643d44b2a2100f75a2818e72c47c2f8f"
        )

        // FacilityMasterからスタンプ情報を取得する
        val query = NCMBQuery<NCMBObject>("FacilityMaster")
        // query.whereEqualTo(, )
        query.whereEqualTo("objectId", intent.getStringExtra("PICK_ID"))
        query.findInBackground { objects, e ->
            if (e != null) {
                // エラー
                Log.d("[Error]", e.toString())
            } else {
                // 成功
                for (obj in objects) {
                    // DBからの取得情報を配列へ
                    facilityName.add(obj.getString("facilityName"))
                    facilityImg.add(obj.getString("facilityImage"))
                    facilityDetaile.add(obj.getString("facilityDetaile"))
                    stampImage.add(obj.getString("stampImg"))
                    stampName.add(obj.getString("stampName"))
                }
                // 施設画像、施設名、施設詳細を表示
                val imgId = resources.getIdentifier(
                    "facility_list_" + facilityImg[0],
                    "drawable",
                    packageName
                )
                // facilityImage.setImageResource(imgId)
                // 画像をまる角にして配置
                Glide.with(facilityImgView)
                    .load(imgId)
                    .transform(CenterCrop(),RoundedCorners(50)) //←この一行追加
                    .into(facilityImgView)
                facilityNameView.setText(facilityName[0])
                facilityDetaileView.setText(facilityDetaile[0])
                // 獲得できるスタンプがあればアイコンを表示
                if (stampImage.size != 0)
                    paccieIcon.visibility = View.VISIBLE
            }
        }

        /*
        // StampMasterからスタンプ情報を取得する
        val query = NCMBQuery<NCMBObject>("StampMaster")
        // query.whereEqualTo(, )
        query.whereEqualTo("facilityObjectId", intent.getStringExtra("PICK_ID"))
        query.findInBackground { objects, e ->
            if (e != null) {
                // エラー
                Log.d("[Error]", e.toString())
            } else {
                // 成功
                for (obj in objects) {
                    // DBからの取得情報を配列へ
                    stampImage.add(obj.getString("stampImage"))
                    stampName.add(obj.getString("stampName"))
                }
                // 獲得できるスタンプがあればアイコンを表示
                if (objects.size != 0)
                    paccieIcon.visibility = View.VISIBLE
            }
        }
        */

        // 「マップで見る」ボタン投下時の処理
        mapMoveButton.setOnClickListener {
            // 「マップ画面」へ遷移
             val intent = Intent(application, MapActivity::class.java)
            // 同一アクティビティ開始時、古い方を終了させる
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }


        // ぱっちぃアイコンタップ時の処理
        paccieIcon.setOnClickListener {
            val imgId = resources.getIdentifier(
                "facility_detaile_" + stampImage[0],
                "drawable",
                packageName
            )
            // スタンプ詳細ダイアログをを表示
            val dialog = FacilityDetaileDialog()
            // スタンプ詳細を渡す
            val args = Bundle()
            args.putInt("stamp_image", imgId)
            args.putString("stamp_name", stampName[0])
            dialog.setArguments(args)
            dialog.show(supportFragmentManager, "simple")
        }

        // ツールバータップ時の処理
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
}


/*
// ポップアップウィンドウの作成
val popupWin =  PopupWindow(this)
// 表示するレイアウトファイルの読み込み
val popLayout = layoutInflater.inflate(R.layout.facility_detaile_dialog, null)
popupWin.setContentView(popLayout)
popupWin.width = ActionBar.LayoutParams.WRAP_CONTENT
popupWin.height = ActionBar.LayoutParams.WRAP_CONTENT
popupWin.showAtLocation(findViewById(R.id.paccieIcon), Gravity.CENTER, 0, 0);

//ポップアップメニューのインスタンスを生成し、context、ボタンのインスタンス(it)を渡す
PopupMenu(this, it).let { that ->
    //レイアウトファイルの読み込み
    that.inflate(R.menu.facility_detaile_dialog)
    //イベント発生時に実行するメソッドを登録
    that.setOnMenuItemClickListener(this::test)
    //ポップアップ表示
    that.show()
}
//trueでこのあと実行されるclickイベントを無効
true
*/
