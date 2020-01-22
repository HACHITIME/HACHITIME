package com.example.android.sample.testapp

import android.Manifest
import android.content.ContentValues
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_complete.*
import java.io.File
import java.io.FileOutputStream

open class CompleteActivity : AppCompatActivity() {

    var message="画像をダウンロードしています"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_complete)
        tytle.text ="Stamp"

        //☓ボタン
        close_comp_btn.setOnClickListener{
            super.onBackPressed()
        }

    }

    override fun onResume() {
        super.onResume()


        //DLボタン処理
        download_btn.setOnClickListener{

            Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()


            if (ContextCompat.checkSelfPermission(applicationContext, Manifest.permission.CAMERA) == PackageManager.PERMISSION_DENIED) {
                ActivityCompat.requestPermissions(this,
                    arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                    1)
            } else {
                saveFile(createFile())
            }
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        // 絶対に許可される前提で記述
        saveFile(createFile())
    }

    private fun createFile(): File {
        val dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM)

        return File(dir, "godkamizeusu.jpg")
    }

    private fun saveFile(f: File) {

        val bit = BitmapFactory.decodeResource(resources, R.drawable.godkamizeusu)

        val ops = FileOutputStream(f)

        bit.compress(Bitmap.CompressFormat.PNG, 100, ops)

        ops.close()

        val contentValues = ContentValues().apply {
            put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg")
            put("_data", f.absolutePath)
        }

        contentResolver.insert(
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues)

    }


}