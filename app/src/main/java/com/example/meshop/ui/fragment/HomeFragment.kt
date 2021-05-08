package com.example.meshop.ui.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
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

class HomeFragment: Fragment(R.layout.fragment_home) {

    lateinit var productAdapter: ProductAdapter

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpSlider()
        setUpRecyclerView()



        val array = arrayListOf<MinimalProductItems>(
                MinimalProductItems(1,"iphone X2211","losAngles Apple Store  ","50,000,000","https"),
                MinimalProductItems(2,"samsung S20 forSell","samsung store in kore,Iran,china,japan,afghanistan","20,000,000","https"),
                MinimalProductItems(3,"laptop asus FX553VD GL553VD FX553Vd","shop3","25,000,000","https"))
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