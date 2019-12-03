package com.example.android.sample.testapp

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import android.view.LayoutInflater


class FacilityListAdapter(
    private val context: Context,
    private val name: ArrayList<String>,
    private val image: ArrayList<String>
) : BaseAdapter() {
    // ビューホルダー
    private class ViewHolder(view: View) {
        val facilityName = view.findViewById<TextView>(R.id.facilityName)
        val facilityImage = view.findViewById<ImageView>(R.id.facilityImage)
    }


    // 与えられた情報からViewを作成し返す
    private fun createView(parent: ViewGroup?) : View {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.facility_list_view, parent, false)
        view.tag = ViewHolder(view)

        return view
    }


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        // ビューの作成
        val view = convertView ?: createView(parent)
        val viewHolder = view.tag as ViewHolder

        // 施設名と施設画像を配置
        viewHolder.facilityName.text = name[position] // 施設名を配置
        val imgId = context.resources.getIdentifier("facility_list_" + image[position], "drawable", context.packageName) // 施設画像のIDを取得
        viewHolder.facilityImage.setImageResource(imgId) // 施設画像を配置

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