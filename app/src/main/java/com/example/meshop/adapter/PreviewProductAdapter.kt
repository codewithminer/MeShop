package com.example.meshop.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.meshop.R
import com.example.meshop.model.PreviewProductItems
import kotlinx.android.synthetic.main.preview_product_design.view.*


class PreviewProductAdapter: RecyclerView.Adapter<PreviewProductAdapter.ProductViewHolder>() {

    inner class ProductViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    private val differCallback = object : DiffUtil.ItemCallback<PreviewProductItems>() {
        override fun areItemsTheSame(oldItem: PreviewProductItems, newItem: PreviewProductItems): Boolean {
            return oldItem.id == newItem.id
        }


        override fun areContentsTheSame(oldItem: PreviewProductItems, newItem: PreviewProductItems): Boolean {
            return oldItem == newItem
        }
    }

     val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder(
                LayoutInflater.from(parent.context).inflate(
                        R.layout.preview_product_design,
                        parent,
                        false
                )
        )
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = differ.currentList[position]
        holder.itemView.apply {
            tv_prev_product_title.text = product.title
            tv_prev_product_shop_name.text = product.shop
            tv_prev_product_shop_city.text = product.city
            tv_prev_product_price.text = "${product.price}"

//            Picasso.get().load("http://site/${product.urlImage}").into(iv_product)

        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }
}