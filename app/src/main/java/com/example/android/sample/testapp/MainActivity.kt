package com.example.android.sample.testapp

import android.app.ActivityOptions
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.twitter.sdk.android.core.TwitterCore
import kotlinx.android.synthetic.main.activity_main.*



open class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (TwitterCore.getInstance().sessionManager.activeSession == null) {
            val intent = Intent(this, SchooltwitterLogin::class.java)
            startActivity(intent)
        } else {
            // val toast = Toast.makeText(this, "ログイン中", Toast.LENGTH_LONG)
            // toast.show()

            val intent = Intent(this@MainActivity, SchooletwitterTimelineActivity::class.java)
            startActivity(intent)
        }

        // if (isValid){
        //文字列を整数形ｎ変換
        //val price = Integer.parseInt(priceText)
        //val discount = Integer.parseInt(discountText)

        // ここで画面遷移を行う
        //val intent = intent(this, ResultActivity::class.java)
        //intent.putExtra("price",price)
        //intent.putExtra("discount", discount)
        //startActivity(intent)

        home_schoolbtn.setOnClickListener {
            val intent = Intent(this, FacilityListActivity::class.java)
            // val intent = Intent(this, SchooletwitterTimelineActivity::class.java)
            startActivity(intent,
                ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }
        home_mapbtn.setOnClickListener {
            val intent = Intent(this, MapActivity::class.java)
            startActivity(intent,
                ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }
        home_stampbtn.setOnClickListener {
            val intent = Intent(this, StampActivity::class.java)
            startActivity(intent,
                ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }
        home_infobtn.setOnClickListener {
            val intent = Intent(this, CampusInfoActivity::class.java)
            startActivity(intent,
                ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }
        home_busbtn.setOnClickListener {
            val intent = Intent(this, BustimeActivity::class.java)
            startActivity(intent,
                ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }
    }
}
