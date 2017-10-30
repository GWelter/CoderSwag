package com.example.guilherme.coderswag.Adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.guilherme.coderswag.Model.Category
import com.example.guilherme.coderswag.R

/**
 * Created by guilhermewelter on 30/10/17.
 */
class CategoryRecycleAdapter (val context: Context, val categories: List<Category>) : RecyclerView.Adapter<CategoryRecycleAdapter.Holder>() {

    override fun getItemCount(): Int {
        return categories.count()
    }

    override fun onBindViewHolder(holder: Holder?, position: Int) {
        holder?.bindCategory(categories[position], context)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.category_list_item, parent, false) as View
        return Holder(view)
    }

    inner class Holder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        val categoryImage = itemView?.findViewById<ImageView>(R.id.category_image)
        val categoryName = itemView?.findViewById<TextView>(R.id.category_name)

        fun bindCategory(category: Category, context: Context) {
            val resourceID = context.resources.getIdentifier(category.image, "drawable", context.packageName)

            categoryImage?.setImageResource(resourceID)
            categoryName?.text = category.title
        }
    }
}