package com.example.guilherme.coderswag.Adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.guilherme.coderswag.Model.Product
import com.example.guilherme.coderswag.R
import java.util.zip.Inflater

/**
 * Created by Guilherme on 31/10/2017.
 */
class ProductsAdapter(val context: Context, val products: List<Product>) : RecyclerView.Adapter<ProductsAdapter.ProductHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ProductHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.product_list_item, parent, false)
        return ProductHolder(view)
    }

    override fun onBindViewHolder(holder: ProductHolder?, position: Int) {
        holder?.bindProduct(products[position], context)
    }

    override fun getItemCount(): Int {
        return products.count()
    }

    inner class ProductHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        val productImage = itemView?.findViewById<ImageView>(R.id.product_image)
        val productName = itemView?.findViewById<TextView>(R.id.product_name)
        val productPrice = itemView?.findViewById<TextView>(R.id.product_price)

        fun bindProduct(product: Product, context: Context) {
            val resourceID = context.resources.getIdentifier(product.image, "drawable", context.packageName)
            productImage?.setImageResource(resourceID)
            productName?.text = product.title
            productPrice?.text = product.price
        }
    }
}