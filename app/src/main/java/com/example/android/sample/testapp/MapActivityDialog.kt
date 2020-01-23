package com.example.android.sample.testapp
import android.app.Dialog
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

open class MapActivityDialog : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        // ダイアログの作成
        val dialog = Dialog(getActivity())
        dialog.setContentView(R.layout.map_hopup)
        //施設名取得
        dialog.findViewById<TextView>(R.id.Facility_Name).text = arguments!!.getString("marker_title")
        //スタンプボタン判定
        //val sFacility = listOf("片柳研究所","展示棟","図書館棟","講義棟A","体育館","片柳記念ホール","メディアホール")
        // ダイアログを閉じる
        when {
            arguments!!.getString("marker_title") == "研究棟A" ->{}
            arguments!!.getString("marker_title") == "研究棟B" ->{}
            arguments!!.getString("marker_title") == "研究棟C" ->{}
            arguments!!.getString("marker_title") == "講義棟B" ->{}
            arguments!!.getString("marker_title") == "講義棟C" ->{}
            arguments!!.getString("marker_title") == "講義棟D" ->{}
            arguments!!.getString("marker_title") == "講義棟E" ->{}
            arguments!!.getString("marker_title") == "講義実験棟" ->{}
            arguments!!.getString("marker_title") == "実験棟A" ->{}
            arguments!!.getString("marker_title") == "実験棟B" ->{}
            arguments!!.getString("marker_title") == "本部棟" ->{}
            arguments!!.getString("marker_title") == "厚生棟" ->{}
            arguments!!.getString("marker_title") == "ものづくり工房" ->{}
            arguments!!.getString("marker_title") == "片柳研究所" -> {
                dialog.findViewById<Button>(R.id.Hopup_tytle).text = "スタンプ取得"
                dialog.findViewById<Button>(R.id.Hopup_tytle).setOnClickListener{
                    if(arguments!!.getFloat("stamp_result") <= 100) {
                        Toast.makeText(context,"取得に成功しました", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(context,"取得に失敗しました", Toast.LENGTH_SHORT).show()
                    }
                }
            }
            arguments!!.getString("marker_title") == "展示棟" -> {
                dialog.findViewById<Button>(R.id.Hopup_tytle).text = "スタンプ取得"
                dialog.findViewById<Button>(R.id.Hopup_tytle).setOnClickListener{
                    if(arguments!!.getFloat("stamp_result") <= 100) {
                        Toast.makeText(context,"取得に成功しました", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(context,"取得に失敗しました", Toast.LENGTH_SHORT).show()
                    }
                }
            }
            arguments!!.getString("marker_title") == "図書館棟" -> {
                dialog.findViewById<Button>(R.id.Hopup_tytle).text = "スタンプ取得"
                dialog.findViewById<Button>(R.id.Hopup_tytle).setOnClickListener{
                    if(arguments!!.getFloat("stamp_result") <= 100) {
                        Toast.makeText(context,"取得に成功しました", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(context,"取得に失敗しました", Toast.LENGTH_SHORT).show()
                    }
                }
            }
            arguments!!.getString("marker_title") == "講義棟A" -> {
                dialog.findViewById<Button>(R.id.Hopup_tytle).text = "スタンプ取得"
                dialog.findViewById<Button>(R.id.Hopup_tytle).setOnClickListener{
                    if(arguments!!.getFloat("stamp_result") <= 100) {
                        Toast.makeText(context,"取得に成功しました", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(context,"取得に失敗しました", Toast.LENGTH_SHORT).show()
                    }
                }
            }
            arguments!!.getString("marker_title") == "体育館" -> {
                dialog.findViewById<Button>(R.id.Hopup_tytle).text = "スタンプ取得"
                dialog.findViewById<Button>(R.id.Hopup_tytle).setOnClickListener{
                    if(arguments!!.getFloat("stamp_result") <= 100) {
                        Toast.makeText(context,"取得に成功しました", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(context,"取得に失敗しました", Toast.LENGTH_SHORT).show()
                    }
                }
            }
            arguments!!.getString("marker_title") == "片柳記念ホール" -> {
                dialog.findViewById<Button>(R.id.Hopup_tytle).text = "スタンプ取得"
                dialog.findViewById<Button>(R.id.Hopup_tytle).setOnClickListener{
                    if(arguments!!.getFloat("stamp_result") <= 100) {
                        Toast.makeText(context,"取得に成功しました", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(context,"取得に失敗しました", Toast.LENGTH_SHORT).show()
                    }
                }
            }
            arguments!!.getString("marker_title") == "メディアホール" -> {
                dialog.findViewById<Button>(R.id.Hopup_tytle).text = "スタンプ取得"
                dialog.findViewById<Button>(R.id.Hopup_tytle).setOnClickListener{
                    if(arguments!!.getFloat("stamp_result") <= 100) {
                        Toast.makeText(context,"取得に成功しました。", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(context,"取得に失敗しました", Toast.LENGTH_SHORT).show()
                    }
                }
            }
            //画像取得
            //dialog.findViewById<ImageView>(R.id.ImageViewArea).setImageResource(arguments!!.getInt("stamp_image"))
            //獲得ID
            //dialog.findViewById<TextView>(R.id.HanteiArea).setText(arguments!!.getInt("hantei"))
            //dialog.findViewById<TextView>(R.id.Facility_Name).setText(arguments!!.getString("syutoku"))
            // 「X」ボタン投下時の処理
        }
        //画像取得
        //dialog.findViewById<ImageView>(R.id.ImageViewArea).setImageResource(arguments!!.getInt("stamp_image"))
        //獲得ID
        //dialog.findViewById<TextView>(R.id.HanteiArea).setText(arguments!!.getInt("hantei"))
        //dialog.findViewById<TextView>(R.id.Facility_Name).setText(arguments!!.getString("syutoku"))
        // 「X」ボタン投下時の処理
        dialog.findViewById<Button>(R.id.close_btn).setOnClickListener {
            // ダイアログを閉じる
            dismiss()
        }
        return dialog
    }
}