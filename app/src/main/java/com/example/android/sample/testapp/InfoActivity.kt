package com.example.android.sample.testapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class InfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.campasinfo)
        setContentView(R.layout.toolbar)
    }
}