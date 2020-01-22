
package com.example.android.sample.testapp

import android.app.Dialog
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.View
import android.widget.Button
import android.widget.ImageView



open class CompleteDialog : DialogFragment() {


override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        // ダイアログの作成
        val dialog = Dialog(getActivity())
        dialog.setContentView(R.layout.complete_hopup)

        //画像取得
        dialog.findViewById<ImageView>(R.id.ImageViewArea).setImageResource(R.drawable.godkamizeusu)

        // 「X」ボタン投下時の処理
        dialog.findViewById<Button>(R.id.close_btn).setOnClickListener(View.OnClickListener {
            // ダイアログを閉じる
            dismiss()
        })

        dialog.findViewById<Button>(R.id.dl_btn).setOnClickListener(View.OnClickListener {
            //onResume DL作業をしたい
            dismiss()
        })

        return dialog
    }




}



