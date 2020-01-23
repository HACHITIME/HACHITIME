package com.example.android.sample.testapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.content.Intent
import com.twitter.sdk.android.core.TwitterException
import com.twitter.sdk.android.core.TwitterSession
import com.twitter.sdk.android.core.identity.TwitterLoginButton
import com.twitter.sdk.android.core.Callback
import com.twitter.sdk.android.core.Result


class SchooltwitterLogin : AppCompatActivity() {

    val loginButtons = arrayListOf<TwitterLoginButton>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_schooltwitter_login)

        loginButtons.add(findViewById<TwitterLoginButton>(R.id.login_button))
        loginButtons[0].setCallback(object : Callback<TwitterSession>() {
            override fun success(result: Result<TwitterSession>) {
                // Do something with result, which provides a TwitterSession for making API calls

                val toast = Toast.makeText(this@SchooltwitterLogin, "ログイン成功", Toast.LENGTH_LONG)
                toast.show()
            }

            override fun failure(exception: TwitterException) {
                // Do something on failure

                val toast = Toast.makeText(this@SchooltwitterLogin, "ログイン失敗", Toast.LENGTH_LONG)
                toast.show()
            }
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Pass the activity result to the login button.
        loginButtons[0].onActivityResult(requestCode, resultCode, data)
    }
}
