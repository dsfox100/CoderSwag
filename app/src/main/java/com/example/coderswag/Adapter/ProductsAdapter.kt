package com.example.coderswag.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.coderswag.Model.Product
import com.example.coderswag.R
import kotlinx.android.synthetic.main.product_layout_item.view.*

    class ProductsAdapter(val context:Context,val products:List<Product>):RecyclerView.Adapter<ProductsAdapter.ProductHolder>() {

        override fun getItemCount(): Int {
            return products.count()
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder {
            val view =
                LayoutInflater.from(context).inflate(R.layout.product_layout_item, parent, false)
            return ProductHolder(view)
        }


        override fun onBindViewHolder(holder: ProductHolder, position: Int) {
            holder.bindProduct(products[position], context)
        }

        inner class ProductHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

            val productImage = itemView.findViewById<ImageView>(R.id.productImage)
            val productName = itemView.findViewById<TextView>(R.id.productName)
            val productPrice = itemView.findViewById<TextView>(R.id.productPrice)

            fun bindProduct(product: Product, context: Context) {
                val resourceId =
                    context.resources.getIdentifier(product.image, "drawable", context.packageName)
                productImage.setImageResource(resourceId)
                productName.text = product.title
                productPrice.text = product.price
            }

    }
}