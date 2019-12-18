package com.example.android.sample.testapp

import android.app.Dialog
import android.os.Bundle
import android.support.v4.app.DialogFragment


open class HopupDialog : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        // ダイアログの作成
        val dialog = Dialog(getActivity())
        dialog.setContentView(R.layout.stamp_hopup)

        return dialog
    }

}
