package com.example.android.sample.testapp

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.nifcloud.mbaas.core.NCMBObject
import kotlinx.android.synthetic.main.interview_list_view.view.*
import org.w3c.dom.Text
import kotlin.collections.ArrayList


class InterviewListAdapter(
    private val context: Context,
    private val objects: List<NCMBObject>, // 選択カレッジのインタビュー情報
    private val studentIds: ArrayList<String>, // 対象の学生ID
    private val questions: ArrayList<String>, // 質問内容
    private val answers: ArrayList<String> // 回答内容
) : BaseAdapter() {
    // 変数・配列の作成

    // ビューホルダー
    private class ViewHolder(view: View) {
        val studentImage = view.findViewById<ImageView>(R.id.studentImage)
        val studentName = view.findViewById<TextView>(R.id.studentName)
        val studentSubject = view.findViewById<TextView>(R.id.studentSubject)
        val interviewDetaileList = view.findViewById<LinearLayout>(R.id.interviewDetaileList)
    }


    // 与えられた情報からViewを作成し返す
    private fun createView(parent: ViewGroup?, position: Int) : View {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.interview_list_view, parent, false)
        view.tag = ViewHolder(view)

        return view
    }


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        // ビューの作成
        val view = convertView ?: createView(parent, position)
        val viewHolder = view.tag as ViewHolder

        // 学生画像・氏名・学科を配置
        val studentImage = "interview_list_" + objects[position].getString("studentImage")
        val studentName = objects[position].getString("studentName")
        val studentSubject = objects[position].getString("subject")

        // viewの初期化
        viewHolder.interviewDetaileList.removeAllViews()

        for (i in 0..studentIds.size-1) {
            if (studentIds[i] == objects[position].getString("objectId")) {
                // インタビュー内容を表示するためのViewを作成
                val inflater = LayoutInflater.from(context)
                val interviewDetaile = inflater.inflate(R.layout.interview_list_detaile_view, parent, false)
                interviewDetaile.findViewById<TextView>(R.id.question).text = questions[i]
                interviewDetaile.findViewById<TextView>(R.id.answer).text = answers[i]
                viewHolder.interviewDetaileList.addView(interviewDetaile)

            }
        }

        // 学生画像・氏名・学科を配置
        val imgId = context.resources.getIdentifier(studentImage, "drawable", context.packageName) // 施設画像のIDを取得
        viewHolder.studentImage.setImageResource(imgId) // 画像を配置
        viewHolder.studentName.text = studentName // 氏名を配置
        viewHolder.studentSubject.text = studentSubject // 学科名を配置

        return view
    }


    override fun getItem(position: Int): Any {
        return objects[position]
    }


    override fun getItemId(position: Int): Long {
        return position.toLong()
    }


    override fun getCount(): Int {
        return objects.size
    }

    override fun isEnabled(position: Int): Boolean {
        return false
    }

}
