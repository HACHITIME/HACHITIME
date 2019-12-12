package com.example.android.sample.testapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class CollegeListAdapter(
    private val context: Context,
    private val name: ArrayList<String>
) : BaseAdapter() {

    // ビューホルダー
    private class ViewHolder(view: View) {
        val collegeName = view.findViewById<TextView>(R.id.collegeName)
    }


    // 与えられた情報からViewを作成し返す
    private fun createView(parent: ViewGroup?) : View {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.college_list_view, parent, false)
        view.tag = ViewHolder(view)

        return view
    }


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        // ビューの作成
        val view = convertView ?: createView(parent)
        val viewHolder = view.tag as ViewHolder

        // 施設名を指定
        viewHolder.collegeName.text = name[position]
        viewHolder.collegeName.setBackgroundResource(R.drawable.interview_list_listitem)
        // viewHolder.collegeName.setBackgroundColor(Color.parseColor("RED"))

        return view
    }


    override fun getItem(position: Int): Any {
        return name[position]
    }


    override fun getItemId(position: Int): Long {
        return position.toLong()
    }


    override fun getCount(): Int {
        return name.size
    }
}