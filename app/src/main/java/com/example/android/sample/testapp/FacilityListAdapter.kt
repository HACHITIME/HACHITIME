package com.example.android.sample.testapp

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import android.view.LayoutInflater
import android.util.Log
import android.R.drawable




class FacilityListAdapter(
    private val context: Context,
    private val name: ArrayList<String>,
    private val image: ArrayList<String>
) : BaseAdapter() {
    // val facilityName = arrayOf("研究棟Ｂ","片柳記念ホール","厚生棟","図書館")
    // val facilityImage = arrayOf("facilityList_bijyutukan","facilityList_bijyutukan","facilityList_bijyutukan","facilityList_bijyutukan")

    private class ViewHolder(view: View) {
        val facilityName = view.findViewById<TextView>(R.id.facilityName)
        val facilityImage = view.findViewById<ImageView>(R.id.facilityImage)
    }

    // 与えられた情報からViewを作成し返す
    private fun createView(parent: ViewGroup?) : View {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.rowdata_facility_list, parent, false)
        view.tag = ViewHolder(view)

        return view
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        // ビューの作成
        val view = convertView ?: createView(parent)
        val viewHolder = view.tag as ViewHolder
        // val drawable = getResources().getDrawable(image[position])
        // 施設名と施設画像を配置
        viewHolder.facilityName.text = name[position]
        viewHolder.facilityImage.setImageResource(R.drawable.facility_list_bijyutukan)
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