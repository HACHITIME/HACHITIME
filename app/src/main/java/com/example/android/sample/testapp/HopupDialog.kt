package com.example.android.sample.testapp

import android.app.Dialog
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.View
import android.widget.Button


open class HopupDialog : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        // ダイアログの作成
        val dialog = Dialog(getActivity())
        dialog.setContentView(R.layout.stamp_hopup)

        // 「X」ボタン投下時の処理
        dialog.findViewById<Button>(R.id.close_btn).setOnClickListener(View.OnClickListener {
            // ダイアログを閉じる
            dismiss()
        })

        return dialog
    }

}
