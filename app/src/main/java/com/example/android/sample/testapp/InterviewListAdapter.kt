package com.example.android.sample.testapp

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.nifcloud.mbaas.core.NCMBObject
import com.nifcloud.mbaas.core.NCMBQuery


class InterviewListAdapter(
    private val context: Context,
    private val image: ArrayList<String>,
    private val name: ArrayList<String>,
    private val subject: ArrayList<String>,
    private val id: ArrayList<String>

) : BaseAdapter() {
    val question = arrayListOf<String>()
    val answer = arrayListOf<String>()

    // ビューホルダー
    private class ViewHolder(view: View) {
        val studentImage = view.findViewById<ImageView>(R.id.studentImage)
        val studentName = view.findViewById<TextView>(R.id.studentName)
        val studentSubject = view.findViewById<TextView>(R.id.studentSubject)
        val interviewDetaileList = view.findViewById<ListView>(R.id.interviewDetaileList)
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
        viewHolder.studentImage.setImageResource(imgId) // 質問Noを配置
        viewHolder.studentName.text = name[position] // 質問内容を配置
        viewHolder.studentSubject.text = subject[position] // 回答内容を表示

        // FacilityMasterから施設情報を取得する
        val queryInterviewDetaile = NCMBQuery<NCMBObject>("InterviewDetaile")
        queryInterviewDetaile.whereEqualTo("studentObjectId", id[position]) // 条件：対象学生のインタビュー詳細を指定
        queryInterviewDetaile.addOrderByAscending("questionNo") // 質問Noの昇順
        queryInterviewDetaile.findInBackground { objects, e ->
            if (e != null) {
                // エラー
                Log.d("[Error]", e.toString())
            } else {
                // 成功
                for (obj in objects) {
                    // DBからの取得情報を配列へ追加
                    question.add(obj.getString("question"))
                    answer.add(obj.getString("answer"))
                }
                // interviewDetaileListのadapterを作成
                val adapterInterviewDetaileList = InterviewListDetaileAdapter(context, question, answer)
                // facilityDetaileListにadapterをセット
                viewHolder.interviewDetaileList.adapter = adapterInterviewDetaileList
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