package com.example.meshop.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.meshop.R
import com.example.meshop.model.MinimalProductItems
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.product_design.view.*


class ProductAdapter: RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    inner class ProductViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    private val differCallback = object : DiffUtil.ItemCallback<MinimalProductItems>() {
        override fun areItemsTheSame(oldItem: MinimalProductItems, newItem: MinimalProductItems): Boolean {
            return oldItem.id == newItem.id
        }


        override fun areContentsTheSame(oldItem: MinimalProductItems, newItem: MinimalProductItems): Boolean {
            return oldItem == newItem
        }
    }

     val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder(
                LayoutInflater.from(parent.context).inflate(
                        R.layout.product_design,
                        parent,
                        false
                )
        )
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = differ.currentList[position]
        holder.itemView.apply {
            tv_title_product.text = product.title
            tv_shop_product.text = product.shop
            tv_price_product.text = "${product.price} R"

//            Picasso.get().load("http://site/${product.urlImage}").into(iv_product)

        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }
}