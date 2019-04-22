package com.example.user.garbarinotest.details.views

import android.graphics.Paint
import android.nfc.FormatException
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.example.user.garbarinotest.R
import com.example.user.garbarinotest.home.presenter.DetailsActivityPresenter
import com.example.user.garbarinotest.models.products.ResponsePost
import com.example.user.garbarinotest.models.reviews.ResponseReviewsItems
import com.example.user.garbarinotest.models.reviews.ReviewStatistics
import com.example.user.garbarinotest.models.reviews.ReviewsItem
import com.example.user.garbarinotest.utils.createNewView
import kotlinx.android.synthetic.main.chip_text.*
import kotlinx.android.synthetic.main.details_description_layout.*
import kotlinx.android.synthetic.main.details_main_layout.*
import kotlinx.android.synthetic.main.rating_reviews.*
import kotlinx.android.synthetic.main.text_divider.view.*

class DetailsActivity : AppCompatActivity() {

    private var presenter:DetailsActivityPresenter? = null

    private var Post: ResponsePost? = null

    var Reviews: ResponseReviewsItems? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        presenter = DetailsActivityPresenter(this)

        val actionbar = supportActionBar

        actionbar?.let {
            it.title = "Detalles del producto"
            it.setDisplayHomeAsUpEnabled(true)
        }


        intent?.extras?.let {

            val imageUrl:String? = it.getString("imageUrl")
            val description:String? = it.getString("title")
            val price:Int = it.getInt("price", 0)
            val hasDiscount:Boolean = it.getBoolean("hasDiscount", false)
            val oldPrice:Int = it.getInt("oldPrice", 0)
            val discount:Int = it.getInt("discount",0)


            txtDetailTitle.text =description
            txtDetailPrice.text = "$$price"

            Glide.with(this)
                .load("https:${imageUrl}")
                .into(imageDetailHeader)



            if (hasDiscount){
                txtDetailOldPrice.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
                txtDetailOldPrice.text = "$$oldPrice"
                txtDetailDiscount.text = "${discount}% OFF"
            }
            else{
                detailDiscountLayout.visibility = View.GONE
            }

            detailTagLayout.visibility = View.GONE
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onResume() {
        super.onResume()

        if (Post == null){

            intent?.extras?.let {

                val id:String = it.getString("id")

                presenter?.getPostData(id)
            }
        }

    }

    fun fillPostData(post: ResponsePost?){

        post?.let {

            it.mainImage?.let { image ->
                Glide.with(this)
                    .load("https:${image.url}")
                    .into(imageDetailHeader)
            }

            presenter?.divideSummary(it.summary)

            it.resources?.let {res ->

                chipContainer.visibility = View.VISIBLE

                if (res.images?.any() == true){

                    txtChip.text = "${res.images.count()} Fotos"
                }

                if (res.videos?.any() == true){

                    txtChip.text = "${txtChip.text} | ${res.videos.count()} Videos"

                }
            }

            presenter?.getPostReviews(it.xid)

        }

    }

    fun addDescriptionDividerView(text:String){

        try {
            //var dividerView = descriptionDataLayout.inflate(R.layout.text_divider)
            var dividerView = this.createNewView(R.layout.text_divider)//LayoutInflater.from(this).inflate(R.layout.text_divider, null)

            dividerView.txtData.text = text

            descriptionDataLayout.addView(dividerView)
        }
        catch (e:FormatException){
            println(e)
        }
    }

    fun addReviewsStars(statistics: ReviewStatistics?) {

        statistics?.let {stats ->
            ratingBar.rating = (stats.averageOverallRating ?: 0.0).toFloat()

            txtRatingBar.text = "${stats.ratingDistribution?.count()} opiniones"

        }

    }

    fun addReviews(reviews: List<ReviewsItem?>?) {



    }

}
