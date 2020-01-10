package com.example.android.sample.testapp

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView


class FacilityDetaileDialog : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        // ダイアログの作成
        val dialog = Dialog(getActivity())
        dialog.setContentView(R.layout.facility_detaile_dialog)
        // スタンプ画像を表示
        dialog.findViewById<ImageView>(R.id.stampImage).setImageResource(arguments!!.getInt("stamp_image"))
        // スタンプ名を表示
        dialog.findViewById<TextView>(R.id.stampName).setText(arguments!!.getString("stamp_name"))
        // ダイアログの背景を透明化
        dialog.window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        // ダイアログの幅を指定
        dialog.window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)


        /* ---ボタン投下時の処理-- */
        // 「マップ」ボタン投下時の処理
        dialog.findViewById<Button>(R.id.mapButton).setOnClickListener(View.OnClickListener {
            // マップ画面へ遷移
            val intent = Intent(context, FacilityListActivity::class.java)
            // 同一アクティビティ開始時、古い方を終了させる
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        })

        // 「スタンプ一覧」ボタン投下時の処理
        dialog.findViewById<Button>(R.id.stampButton).setOnClickListener(View.OnClickListener {
            /** 「スタンプ画面」完成後に実装 **/
            // スタンプ画面へ遷移
            val intent = Intent(context, StampActivity::class.java)
            // 同一アクティビティ開始時、古い方を終了させる
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        })

        // 「X」ボタン投下時の処理
        dialog.findViewById<Button>(R.id.closeButton).setOnClickListener(View.OnClickListener {
            // ダイアログを閉じる
            dismiss()
        })
        /* -------------------- */

        return dialog
    }
}