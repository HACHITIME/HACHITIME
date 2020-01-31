package com.example.android.sample.testapp
import android.app.Dialog
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

open class MapActivityDialog : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        // ダイアログの作成
        val dialog = Dialog(activity)
        dialog.setContentView(R.layout.map_hopup)
        //施設名取得
        dialog.findViewById<TextView>(R.id.Facility_Name).text = arguments!!.getString("marker_title")
        when {
            arguments!!.getString("marker_title") == "研究棟A" -> {
                dialog.findViewById<ImageView>(R.id.ImageViewArea).setImageResource(R.drawable.facility_list_kenkyuto_a)
                dialog.findViewById<Button>(R.id.facilityDetail_btn).setOnClickListener{
                    var intent = Intent(context, FacilityDetaileActivity::class.java)
                    // 同一アクティビティ開始時、古い方を終了させる
                    intent.flags = FLAG_ACTIVITY_CLEAR_TOP
                    // 施設情報を渡す
                    intent.putExtra("PICK_ID", "v4TFZW4AKhndmHiX")
                    intent.putExtra("PICK_NAME", "研究棟A")
                    startActivity(intent)
                }
            }
            arguments!!.getString("marker_title") == "研究棟B" ->{
                dialog.findViewById<ImageView>(R.id.ImageViewArea).setImageResource(R.drawable.facility_list_kenkyuto_b)
                dialog.findViewById<Button>(R.id.facilityDetail_btn).setOnClickListener{
                    var intent = Intent(context, FacilityDetaileActivity::class.java)
                    // 同一アクティビティ開始時、古い方を終了させる
                    intent.flags = FLAG_ACTIVITY_CLEAR_TOP
                    // 施設情報を渡す
                    intent.putExtra("PICK_ID", "pxYfmnDVQaS4Epye")
                    intent.putExtra("PICK_NAME", "研究棟B")
                    startActivity(intent)
                }
            }
            arguments!!.getString("marker_title") == "研究棟C" ->{
                dialog.findViewById<ImageView>(R.id.ImageViewArea).setImageResource(R.drawable.facility_list_kenkyuto_c)
                dialog.findViewById<Button>(R.id.facilityDetail_btn).setOnClickListener{
                    var intent = Intent(context, FacilityDetaileActivity::class.java)
                    // 同一アクティビティ開始時、古い方を終了させる
                    intent.flags = FLAG_ACTIVITY_CLEAR_TOP
                    // 施設情報を渡す
                    intent.putExtra("PICK_ID", "3JqunRKgWNimdMhP")
                    intent.putExtra("PICK_NAME", "研究棟C")
                    startActivity(intent)
                }
            }
            arguments!!.getString("marker_title") == "講義棟B" ->{
                dialog.findViewById<ImageView>(R.id.ImageViewArea).setImageResource(R.drawable.facility_list_kogito_b)
                dialog.findViewById<Button>(R.id.facilityDetail_btn).setOnClickListener{
                    var intent = Intent(context, FacilityDetaileActivity::class.java)
                    // 同一アクティビティ開始時、古い方を終了させる
                    intent.flags = FLAG_ACTIVITY_CLEAR_TOP
                    // 施設情報を渡す
                    intent.putExtra("PICK_ID", "7zw3IJAfPYDWxvoi")
                    intent.putExtra("PICK_NAME", "講義棟B")
                    startActivity(intent)
                }
            }
            arguments!!.getString("marker_title") == "講義棟C" ->{
                dialog.findViewById<ImageView>(R.id.ImageViewArea).setImageResource(R.drawable.facility_list_kogito_c)
                dialog.findViewById<Button>(R.id.facilityDetail_btn).setOnClickListener{
                    var intent = Intent(context, FacilityDetaileActivity::class.java)
                    // 同一アクティビティ開始時、古い方を終了させる
                    intent.flags = FLAG_ACTIVITY_CLEAR_TOP
                    // 施設情報を渡す
                    intent.putExtra("PICK_ID", "VxfsMDRtNUUTcOEo")
                    intent.putExtra("PICK_NAME", "講義棟C")
                    startActivity(intent)
                }
            }
            arguments!!.getString("marker_title") == "講義棟D" ->{
                dialog.findViewById<ImageView>(R.id.ImageViewArea).setImageResource(R.drawable.facility_list_kogito_d)
                dialog.findViewById<Button>(R.id.facilityDetail_btn).setOnClickListener{
                    var intent = Intent(context, FacilityDetaileActivity::class.java)
                    // 同一アクティビティ開始時、古い方を終了させる
                    intent.flags = FLAG_ACTIVITY_CLEAR_TOP
                    // 施設情報を渡す
                    intent.putExtra("PICK_ID", "N9YOLyU6O5j4daDe")
                    intent.putExtra("PICK_NAME", "講義棟D")
                    startActivity(intent)
                }
            }
            arguments!!.getString("marker_title") == "講義棟E" ->{
                dialog.findViewById<ImageView>(R.id.ImageViewArea).setImageResource(R.drawable.facility_list_kogito_e)
                dialog.findViewById<Button>(R.id.facilityDetail_btn).setOnClickListener{
                    var intent = Intent(context, FacilityDetaileActivity::class.java)
                    // 同一アクティビティ開始時、古い方を終了させる
                    intent.flags = FLAG_ACTIVITY_CLEAR_TOP
                    // 施設情報を渡す
                    intent.putExtra("PICK_ID", "tQwddOEtd2j5t4J3 ")
                    intent.putExtra("PICK_NAME", "講義棟E")
                    startActivity(intent)
                }
            }
            arguments!!.getString("marker_title") == "講義実験棟" ->{
                dialog.findViewById<ImageView>(R.id.ImageViewArea).setImageResource(R.drawable.facility_list_kogijikkento)
                dialog.findViewById<Button>(R.id.facilityDetail_btn).setOnClickListener{
                    var intent = Intent(context, FacilityDetaileActivity::class.java)
                    // 同一アクティビティ開始時、古い方を終了させる
                    intent.flags = FLAG_ACTIVITY_CLEAR_TOP
                    // 施設情報を渡す
                    intent.putExtra("PICK_ID", "xgxAog5LsJwIIit7")
                    intent.putExtra("PICK_NAME", "講義実験棟")
                    startActivity(intent)
                }
            }
            arguments!!.getString("marker_title") == "実験棟A" ->{
                dialog.findViewById<ImageView>(R.id.ImageViewArea).setImageResource(R.drawable.facility_list_jikkento_a)
                dialog.findViewById<Button>(R.id.facilityDetail_btn).setOnClickListener{
                    var intent = Intent(context, FacilityDetaileActivity::class.java)
                    // 同一アクティビティ開始時、古い方を終了させる
                    intent.flags = FLAG_ACTIVITY_CLEAR_TOP
                    // 施設情報を渡す
                    intent.putExtra("PICK_ID", "jJjrD4gAd0AsaPR")
                    intent.putExtra("PICK_NAME", "実験棟A")
                    startActivity(intent)
                }
            }
            arguments!!.getString("marker_title") == "実験棟B" ->{
                dialog.findViewById<ImageView>(R.id.ImageViewArea).setImageResource(R.drawable.facility_list_jikkento_b)
                dialog.findViewById<Button>(R.id.facilityDetail_btn).setOnClickListener{
                    var intent = Intent(context, FacilityDetaileActivity::class.java)
                    // 同一アクティビティ開始時、古い方を終了させる
                    intent.flags = FLAG_ACTIVITY_CLEAR_TOP
                    // 施設情報を渡す
                    intent.putExtra("PICK_ID", "dxd8DcwSniUAraM")
                    intent.putExtra("PICK_NAME", "実験棟B")
                    startActivity(intent)
                }
            }
            arguments!!.getString("marker_title") == "本部棟" ->{
                dialog.findViewById<ImageView>(R.id.ImageViewArea).setImageResource(R.drawable.facility_list_honbuto)
                dialog.findViewById<Button>(R.id.facilityDetail_btn).setOnClickListener{
                var intent = Intent(context, FacilityDetaileActivity::class.java)
                // 同一アクティビティ開始時、古い方を終了させる
                intent.flags = FLAG_ACTIVITY_CLEAR_TOP
                // 施設情報を渡す
                intent.putExtra("PICK_ID", "3UvDK5LC5s0yKvNc")
                    intent.putExtra("PICK_NAME", "本部棟")
                startActivity(intent)
            } }
            arguments!!.getString("marker_title") == "厚生棟" -> {
                dialog.findViewById<ImageView>(R.id.ImageViewArea).setImageResource(R.drawable.facility_list_koseto)
                dialog.findViewById<Button>(R.id.facilityDetail_btn).setOnClickListener{
                    var intent = Intent(context, FacilityDetaileActivity::class.java)
                // 同一アクティビティ開始時、古い方を終了させる
                intent.flags = FLAG_ACTIVITY_CLEAR_TOP
                // 施設情報を渡す
                intent.putExtra("PICK_ID", "1KjejoAC9MEOsg9j")
                intent.putExtra("PICK_NAME", "厚生棟")
                startActivity(intent)
            } }
            arguments!!.getString("marker_title") == "ものづくり工房" ->{
                dialog.findViewById<ImageView>(R.id.ImageViewArea).setImageResource(R.drawable.facility_list_monozukuri_kobo)
                dialog.findViewById<Button>(R.id.facilityDetail_btn).setOnClickListener{
                var intent = Intent(context, FacilityDetaileActivity::class.java)
                // 同一アクティビティ開始時、古い方を終了させる
                intent.flags = FLAG_ACTIVITY_CLEAR_TOP
                // 施設情報を渡す
                intent.putExtra("PICK_ID", "dc43FFLGa6nr5JBc")
                intent.putExtra("PICK_NAME", "ものづくり工房")
                startActivity(intent)
            } }
            arguments!!.getString("marker_title") == "片柳研究所" -> {
                dialog.findViewById<Button>(R.id.Hopup_tytle).text = "スタンプ取得する"
                dialog.findViewById<Button>(R.id.Hopup_tytle).visibility = View.VISIBLE
                dialog.findViewById<ImageView>(R.id.ImageViewArea).setImageResource(R.drawable.facility_list_katayanagi_kenkyujo)
                dialog.findViewById<Button>(R.id.Hopup_tytle).setOnClickListener{
                    if(arguments!!.getFloat("stamp_result") <= 100) {
                        Toast.makeText(context,"取得に成功しました", Toast.LENGTH_SHORT).show()
                        /*val editor: SharedPreferences.Editor = PreferenceManager.getDefaultSharedPreferences(context).edit()
                        editor.apply {
                            //設定した名前に対して数値を保存する
                            putInt("PREV_HEIGHT",height)
                            putInt("PREV_WIDTH", width)
                            //最後にコミットすると内容が決定されて保存される
                            commit()
                        }*/

                    }else{
                        Toast.makeText(context,"取得に失敗しました", Toast.LENGTH_SHORT).show()
                    }
                }
                dialog.findViewById<Button>(R.id.facilityDetail_btn).setOnClickListener{
                    var intent = Intent(context, FacilityDetaileActivity::class.java)
                    // 同一アクティビティ開始時、古い方を終了させる
                    intent.flags = FLAG_ACTIVITY_CLEAR_TOP
                    // 施設情報を渡す
                    intent.putExtra("PICK_ID", "NiLUAhniq38XSfL5")
                    intent.putExtra("PICK_NAME","片柳研究所")
                    startActivity(intent)
                }
            }
            arguments!!.getString("marker_title") == "鴻稜美術館" -> {
                dialog.findViewById<Button>(R.id.Hopup_tytle).text = "スタンプ取得する"
                dialog.findViewById<Button>(R.id.Hopup_tytle).visibility = View.VISIBLE
                dialog.findViewById<ImageView>(R.id.ImageViewArea).setImageResource(R.drawable.facility_list_bijyutukan)
                dialog.findViewById<Button>(R.id.Hopup_tytle).setOnClickListener{
                    if(arguments!!.getFloat("stamp_result") <= 100) {
                        Toast.makeText(context,"取得に成功しました", Toast.LENGTH_SHORT).show()

                    }else{
                        Toast.makeText(context,"取得に失敗しました", Toast.LENGTH_SHORT).show()
                    }
                    dialog.findViewById<Button>(R.id.facilityDetail_btn).setOnClickListener{
                        var intent = Intent(context, FacilityDetaileActivity::class.java)
                        // 同一アクティビティ開始時、古い方を終了させる
                        intent.flags = FLAG_ACTIVITY_CLEAR_TOP
                        // 施設情報を渡す
                        intent.putExtra("PICK_ID", "pxYfmnDVQaS4Epye")
                        intent.putExtra("PICK_NAME", "研究棟B")
                        startActivity(intent)
                    }
                }
                dialog.findViewById<Button>(R.id.facilityDetail_btn).setOnClickListener{
                    var intent = Intent(context, FacilityDetaileActivity::class.java)
                    // 同一アクティビティ開始時、古い方を終了させる
                    intent.flags = FLAG_ACTIVITY_CLEAR_TOP
                    // 施設情報を渡す
                    intent.putExtra("PICK_ID", "P4hAb3UDYIjKFfbA ")
                    intent.putExtra("PICK_NAME", "鴻稜美術館")
                    startActivity(intent)
                }
            }
            arguments!!.getString("marker_title") == "図書館棟" -> {
                dialog.findViewById<Button>(R.id.Hopup_tytle).text = "スタンプ取得する"
                dialog.findViewById<Button>(R.id.Hopup_tytle).visibility = View.VISIBLE
                dialog.findViewById<ImageView>(R.id.ImageViewArea).setImageResource(R.drawable.facility_list_tosyokanto)
                dialog.findViewById<Button>(R.id.Hopup_tytle).setOnClickListener{
                    if(arguments!!.getFloat("stamp_result") <= 100) {
                        Toast.makeText(context,"取得に成功しました", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(context,"取得に失敗しました", Toast.LENGTH_SHORT).show()
                    }
                }
                dialog.findViewById<Button>(R.id.facilityDetail_btn).setOnClickListener{
                    var intent = Intent(context, FacilityDetaileActivity::class.java)
                    // 同一アクティビティ開始時、古い方を終了させる
                    intent.flags = FLAG_ACTIVITY_CLEAR_TOP
                    // 施設情報を渡す
                    intent.putExtra("PICK_ID", "tt3XNpZO3JylBCqC")
                    intent.putExtra("PICK_NAME", "図書館棟")
                    startActivity(intent)
                }
            }
            arguments!!.getString("marker_title") == "講義棟A" -> {
                dialog.findViewById<Button>(R.id.Hopup_tytle).text = "スタンプ取得する"
                dialog.findViewById<Button>(R.id.Hopup_tytle).visibility = View.VISIBLE
                dialog.findViewById<ImageView>(R.id.ImageViewArea).setImageResource(R.drawable.facility_list_kogito_a)
                dialog.findViewById<Button>(R.id.Hopup_tytle).setOnClickListener{
                    if(arguments!!.getFloat("stamp_result") <= 100) {
                        Toast.makeText(context,"取得に成功しました", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(context,"取得に失敗しました", Toast.LENGTH_SHORT).show()
                    }
                }
                dialog.findViewById<Button>(R.id.facilityDetail_btn).setOnClickListener{
                    var intent = Intent(context, FacilityDetaileActivity::class.java)
                    // 同一アクティビティ開始時、古い方を終了させる
                    intent.flags = FLAG_ACTIVITY_CLEAR_TOP
                    // 施設情報を渡す
                    intent.putExtra("PICK_ID", "HaHObMQICo1pBiPl")
                    intent.putExtra("PICK_NAME", "講義棟A")
                    startActivity(intent)
                }
            }
            arguments!!.getString("marker_title") == "体育館" -> {
                dialog.findViewById<Button>(R.id.Hopup_tytle).text = "スタンプ取得する"
                dialog.findViewById<Button>(R.id.Hopup_tytle).visibility = View.VISIBLE
                dialog.findViewById<ImageView>(R.id.ImageViewArea).setImageResource(R.drawable.facility_list_taiikukan)
                dialog.findViewById<Button>(R.id.Hopup_tytle).setOnClickListener{
                    if(arguments!!.getFloat("stamp_result") <= 100) {
                        Toast.makeText(context,"取得に成功しました", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(context,"取得に失敗しました", Toast.LENGTH_SHORT).show()
                    }
                }
                dialog.findViewById<Button>(R.id.facilityDetail_btn).setOnClickListener{
                    var intent = Intent(context, FacilityDetaileActivity::class.java)
                    // 同一アクティビティ開始時、古い方を終了させる
                    intent.flags = FLAG_ACTIVITY_CLEAR_TOP
                    // 施設情報を渡す
                    intent.putExtra("PICK_ID", "DvUuJrivVCmuBOWS")
                    intent.putExtra("PICK_NAME", "体育館")
                    startActivity(intent)
                }
            }
            arguments!!.getString("marker_title") == "片柳記念ホール" -> {
                dialog.findViewById<Button>(R.id.Hopup_tytle).text = "スタンプ取得する"
                dialog.findViewById<Button>(R.id.Hopup_tytle).visibility = View.VISIBLE
                dialog.findViewById<ImageView>(R.id.ImageViewArea).setImageResource(R.drawable.facility_list_katayanagi_kinenhall)
                dialog.findViewById<Button>(R.id.Hopup_tytle).setOnClickListener{
                    if(arguments!!.getFloat("stamp_result") <= 100) {
                        Toast.makeText(context,"取得に成功しました", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(context,"取得に失敗しました", Toast.LENGTH_SHORT).show()
                    }
                }
                dialog.findViewById<Button>(R.id.facilityDetail_btn).setOnClickListener{
                    var intent = Intent(context, FacilityDetaileActivity::class.java)
                    // 同一アクティビティ開始時、古い方を終了させる
                    intent.flags = FLAG_ACTIVITY_CLEAR_TOP
                    // 施設情報を渡す
                    intent.putExtra("PICK_ID", "1qhddjmRklcPP0Nd")
                    intent.putExtra("PICK_NAME", "片柳記念ホール")
                    startActivity(intent)
                }
            }
            arguments!!.getString("marker_title") == "メディアホール" -> {
                dialog.findViewById<Button>(R.id.Hopup_tytle).text = "スタンプ取得する"
                dialog.findViewById<Button>(R.id.Hopup_tytle).visibility = View.VISIBLE
                dialog.findViewById<ImageView>(R.id.ImageViewArea).setImageResource(R.drawable.facility_list_mediahall)
                dialog.findViewById<Button>(R.id.Hopup_tytle).setOnClickListener{
                    if(arguments!!.getFloat("stamp_result") <= 100) {
                        Toast.makeText(context,"取得に成功しました。", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(context,"取得に失敗しました", Toast.LENGTH_SHORT).show()
                    }
                }
                dialog.findViewById<Button>(R.id.facilityDetail_btn).setOnClickListener {
                    var intent = Intent(context, FacilityDetaileActivity::class.java)
                    // 同一アクティビティ開始時、古い方を終了させる
                    intent.flags = FLAG_ACTIVITY_CLEAR_TOP
                    // 施設情報を渡す
                    intent.putExtra("PICK_ID", "vebWc4W4HMVOFbzg")
                    intent.putExtra("PICK_NAME", "メディアホール")
                    startActivity(intent)
                }
            }
        }
        // 「X」ボタン投下時の処理
        dialog.findViewById<Button>(R.id.close_btn).setOnClickListener {
            // ダイアログを閉じる
            dismiss()
        }
        return dialog
    }
}