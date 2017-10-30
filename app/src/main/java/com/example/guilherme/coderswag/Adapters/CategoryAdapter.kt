package com.example.guilherme.coderswag.Adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.guilherme.coderswag.Model.Category
import com.example.guilherme.coderswag.R

/**
 * Created by guilherme on 29/10/17.
 */
class CategoryAdapter(context: Context, categories: List<Category>) : BaseAdapter() {

    val categories = categories
    val context = context

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val categoryView: View
        val holder: ViewHolder

        if(convertView == null){
            categoryView = LayoutInflater.from(context).inflate(R.layout.category_list_item, null)

            holder = ViewHolder()
            holder.categoryImageView = categoryView.findViewById(R.id.category_image)
            holder.categoryName = categoryView.findViewById(R.id.category_name)
            categoryView.tag = holder
            Log.d("Debuging", "heavy computing")
        }else{
            holder = convertView.tag as ViewHolder
            categoryView = convertView
        }

        val category = categories[position]
        val imageResourceId = context.resources.getIdentifier(category.image, "drawable", context.packageName)

        holder.categoryName?.text = category.title
        holder.categoryImageView?.setImageResource(imageResourceId)

        return categoryView
    }

    override fun getItem(position: Int): Any {
        return categories[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return categories.count()
    }

    private class ViewHolder() {
        var categoryImageView: ImageView? = null
        var categoryName: TextView? = null
    }
}