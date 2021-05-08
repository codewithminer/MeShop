package com.example.meshop.ui.fragment

import android.annotation.SuppressLint
import android.graphics.*
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.denzcoskun.imageslider.constants.ActionTypes
import com.denzcoskun.imageslider.interfaces.ItemChangeListener
import com.denzcoskun.imageslider.interfaces.ItemClickListener
import com.denzcoskun.imageslider.interfaces.TouchListener
import com.denzcoskun.imageslider.models.SlideModel
import com.example.meshop.R
import com.example.meshop.adapter.ProductAdapter
import com.example.meshop.model.MinimalProductItems
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.product_design.*

class HomeFragment: Fragment(R.layout.fragment_home) {

    lateinit var productAdapter: ProductAdapter

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpSlider()
        setUpRecyclerView()



        val array = arrayListOf<MinimalProductItems>(MinimalProductItems(1,"one","shop1","1000","https"),
                MinimalProductItems(2,"two","shop2","2000","https"),
                MinimalProductItems(3,"three","shop3","3000","https"))
        productAdapter.differ.submitList(array.toList())
    }

    private fun setUpSlider(){

        val imageList = ArrayList<SlideModel>() // Create image list
        imageList.add(SlideModel(R.drawable.test_image))
        imageList.add(SlideModel(R.drawable.test_image_two))

        image_slider.setImageList(imageList)

        image_slider.setItemClickListener(object : ItemClickListener {
            override fun onItemSelected(position: Int) {
                // You can listen here.
            }
        })

        image_slider.setItemChangeListener(object : ItemChangeListener {
            override fun onItemChanged(position: Int) {
                //println("Pos: " + position)
            }
        })

        image_slider.setTouchListener(object : TouchListener {
            override fun onTouched(touched: ActionTypes) {
                if (touched == ActionTypes.DOWN){
                    image_slider.stopSliding()
                } else if (touched == ActionTypes.UP ) {
                    image_slider.startSliding(1000)
                }
            }
        })
    }

    private fun setUpRecyclerView(){
        productAdapter = ProductAdapter()
        rv_home_row_one.apply {
            adapter = productAdapter
            layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        }
    }

}