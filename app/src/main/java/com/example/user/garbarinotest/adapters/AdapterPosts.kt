package com.example.user.garbarinotest.adapters

import android.app.Activity
import android.content.Intent
import android.graphics.Paint
import android.os.Build
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.util.Pair
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.user.garbarinotest.R
import com.example.user.garbarinotest.details.views.DetailsActivity
import com.example.user.garbarinotest.models.PostItem
import kotlinx.android.synthetic.main.item_product.view.*

class AdapterPosts(private val data: List<PostItem?>?): RecyclerView.Adapter<AdapterPosts.Holder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder =
        Holder(LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false))

    override fun getItemCount() = data?.size ?: 0

    override fun onBindViewHolder(holder: Holder, position: Int) {

        data?.let {
            holder.bindView(it[position])
        }
    }

    class Holder(itemView:View):RecyclerView.ViewHolder(itemView){

        fun bindView(item: PostItem?){

            item?.let {
                with(it){
                    itemView.txtTitle.text = description
                    itemView.txtPrice.text = "$ $price"

                    Glide.with(itemView.context)
                        .load("https:${imageUrl}")
                        .into(itemView.imageHeader)

                    if (hasDiscount()){
                        itemView.txtOldPrice.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
                        itemView.txtOldPrice.text = "$ $listPrice"
                        itemView.txtDiscount.text = "${discount}% OFF"
                    }
                    else{
                        itemView.discountLayout.visibility = View.GONE
                    }

                    itemView.tagLayout.visibility = View.GONE

                    itemView.setOnClickListener {

                        val intent = Intent(itemView.context, DetailsActivity::class.java)
                        intent.putExtra("title", description)
                        intent.putExtra("price", price)
                        intent.putExtra("oldPrice", listPrice)
                        intent.putExtra("discount", discount)
                        intent.putExtra("hasDiscount", hasDiscount())
                        intent.putExtra("imageUrl", imageUrl)


                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {

                            val pImage:Pair<View, String> = Pair.create(itemView.imageHeader, "transitionHeader")
                            val pTitle:Pair<View, String> = Pair.create(itemView.txtTitle, "transitionTitle")
                            val pPrice:Pair<View, String> = Pair.create(itemView.txtPrice, "transitionPrice")
                            val pOldPrice:Pair<View, String> = Pair.create(itemView.txtOldPrice, "transitionOldPrice")
                            val pDiscount:Pair<View, String> = Pair.create(itemView.txtDiscount, "transitionDiscount")

                            val options:ActivityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(itemView.context as Activity, pImage,pTitle,pPrice,pOldPrice,pDiscount)

                            itemView.context.startActivity(intent, options.toBundle())
                        }
                        else{
                            itemView.context.startActivity(intent)
                        }
                    }


                }
            }
        }
    }
}