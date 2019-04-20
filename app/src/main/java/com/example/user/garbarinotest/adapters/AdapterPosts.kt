package com.example.user.garbarinotest.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.user.garbarinotest.R
import com.example.user.garbarinotest.models.PostItem
import kotlinx.android.synthetic.main.item_product.view.*

class AdapterPosts(private val data: List<PostItem>): RecyclerView.Adapter<AdapterPosts.Holder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder =
        Holder(LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false))

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bindView(data[position])
    }

    class Holder(itemView:View):RecyclerView.ViewHolder(itemView){

        fun bindView(item: PostItem){

            with(item){
                itemView.txtTitle.text = description
                itemView.txtPrice.text = "$ ${String.format("%.2f", price)}"
                itemView.txtOldPrice.text = "$ $list_price"
                itemView.txtDiscount.text = "$discount %"
            }

        }
    }
}