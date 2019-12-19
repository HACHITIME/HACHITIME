package com.example.android.sample.testapp

import android.app.Dialog
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_stamp.*


open class HopupDialog : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        // ダイアログの作成
        val dialog = Dialog(getActivity())
        dialog.setContentView(R.layout.stamp_hopup)
        //施設名取得
        dialog.findViewById<TextView>(R.id.Facility_Name).setText(arguments!!.getString("stamp_name"))
        //画像取得
        dialog.findViewById<ImageView>(R.id.ImageViewArea).setImageResource(arguments!!.getInt("stamp_image"))


        // 「X」ボタン投下時の処理
        dialog.findViewById<Button>(R.id.close_btn).setOnClickListener(View.OnClickListener {
            // ダイアログを閉じる
            dismiss()
        })

        return dialog
    }

}
