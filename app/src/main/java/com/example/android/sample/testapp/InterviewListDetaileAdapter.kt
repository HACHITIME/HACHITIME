package com.example.android.sample.testapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class InterviewListDetaileAdapter(
    private val context: Context,
    private val qes: ArrayList<String>,
    private val ans: ArrayList<String>
) : BaseAdapter() {
    // ビューホルダー
    private class ViewHolder(view: View) {
        val question = view.findViewById<TextView>(R.id.question)
        val answer = view.findViewById<TextView>(R.id.answer)
    }


    // 与えられた情報からViewを作成し返す
    private fun createView(parent: ViewGroup?) : View {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.interview_list_detaile_view, parent, false)
        view.tag = ViewHolder(view)

        return view
    }


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        // ビューの作成
        val view = convertView ?: createView(parent)
        val viewHolder = view.tag as ViewHolder

        // 質問内容と回答内容を配置
        viewHolder.question.text = qes[position] // 質問内容を配置
        viewHolder.answer.text = ans[position] // 回答内容を配置

        return view
    }


    override fun getItem(position: Int): Any {
        return qes[position]
    }


    override fun getItemId(position: Int): Long {
        return position.toLong()
    }


    override fun getCount(): Int {
        return qes.size
    }

}