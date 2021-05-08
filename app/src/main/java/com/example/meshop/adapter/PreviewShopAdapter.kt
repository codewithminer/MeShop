package com.example.meshop.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.meshop.R
import com.example.meshop.model.PreviewShopItems
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.preview_shop_design.view.*

class PreviewShopAdapter: RecyclerView.Adapter<PreviewShopAdapter.ShopViewHolder>(){

    inner class ShopViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    private val differCallBack = object : DiffUtil.ItemCallback<PreviewShopItems>(){
        override fun areItemsTheSame(oldItem: PreviewShopItems, newItem: PreviewShopItems): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: PreviewShopItems, newItem: PreviewShopItems): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallBack)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopViewHolder {
        return ShopViewHolder(
                LayoutInflater.from(parent.context).inflate(
                        R.layout.preview_shop_design,
                        parent,
                        false
                )
        )
    }

    override fun onBindViewHolder(holder: ShopViewHolder, position: Int) {
        val shop = differ.currentList[position]
        holder.itemView.apply {
            tv_prev_shop_title.text = shop.name
            shop.star?.let { rb_prev_shop.rating = it }
//            Picasso.get().load(shop.urlImage).into(iv_prev_shop_design)
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }
}