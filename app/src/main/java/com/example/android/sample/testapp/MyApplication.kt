package com.example.android.sample.testapp

import android.app.Application
import android.util.Log
import com.twitter.sdk.android.core.Twitter
import com.twitter.sdk.android.core.TwitterAuthConfig
import com.twitter.sdk.android.core.DefaultLogger
import com.twitter.sdk.android.core.TwitterConfig


class MyApplication : Application() {
    private val CONSUMER_KEY = "vxkH7CilxucpjxYVJrOranmZh"
    private val CONSUMER_SECRET = "j5uRZ5u8Rtye4ows1tix07gWlXDigqkzhckMmgm5EAIFI7h0aZ"

    override fun onCreate() {
        super.onCreate()

        val config = TwitterConfig.Builder(this)
            .logger(DefaultLogger(Log.DEBUG))
            .twitterAuthConfig(TwitterAuthConfig(CONSUMER_KEY, CONSUMER_SECRET))
            .debug(true)
            .build()
        Twitter.initialize(config)
    }
}