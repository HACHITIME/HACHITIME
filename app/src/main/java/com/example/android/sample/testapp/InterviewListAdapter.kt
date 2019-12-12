package com.example.android.sample.testapp

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView
import com.nifcloud.mbaas.core.NCMBObject
import com.nifcloud.mbaas.core.NCMBQuery


class InterviewListAdapter(
    private val context: Context,
    private val image: ArrayList<String>,
    private val name: ArrayList<String>,
    private val subject: ArrayList<String>
) : BaseAdapter() {
    val questionNo = arrayListOf<Int>()
    val question = arrayListOf<String>()
    val answer = arrayListOf<String>()

    // ビューホルダー
    private class ViewHolder(view: View) {
        val studentImage = view.findViewById<ImageView>(R.id.studentImage)
        val studentName = view.findViewById<TextView>(R.id.studentName)
        val studentSubject = view.findViewById<TextView>(R.id.studentSubject)
        val interviewDetaileList = view.findViewById<GridView>(R.id.interviewDetaileList)
    }


    // 与えられた情報からViewを作成し返す
    private fun createView(parent: ViewGroup?) : View {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.interview_list_view, parent, false)
        view.tag = ViewHolder(view)

        return view
    }


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        // ビューの作成
        val view = convertView ?: createView(parent)
        val viewHolder = view.tag as ViewHolder

        // 施設名と施設画像を配置
        val imgId = context.resources.getIdentifier("interview_list_" + image[position], "drawable", context.packageName) // 施設画像のIDを取得
        viewHolder.studentImage.setImageResource(imgId) // 施設画像を配置
        viewHolder.studentName.text = name[position] // 施設名を配置
        viewHolder.studentSubject.text = subject[position]

        // FacilityMasterから施設情報を取得する
        val queryInterviewDetaile = NCMBQuery<NCMBObject>("InterviewDetaile")
        queryInterviewDetaile.findInBackground { objects, e ->
            if (e != null) {
                // エラー
                Log.d("[Error]", e.toString())
            } else {
                // 成功
                for (obj in objects) {
                    // DBからの取得情報を配列へ追加
                    questionNo.add(obj.getInt("questionNo"))
                    question.add(obj.getString("question"))
                    answer.add(obj.getString("answer"))
                }
                // interviewDetaileListのadapterを作成
                val adapterInterviewDetaileList = InterviewListDetaileAdapter(context, questionNo, question, answer)
                // facilityDetaileListにadapterをセット
                viewHolder.interviewDetaileList.findViewById<GridView>(R.id.interviewDetaileList).adapter = adapterInterviewDetaileList
            }
        }

        return view
    }


    override fun getItem(position: Int): Any {
        return image[position]
    }


    override fun getItemId(position: Int): Long {
        return position.toLong()
    }


    override fun getCount(): Int {
        return image.size
    }

}