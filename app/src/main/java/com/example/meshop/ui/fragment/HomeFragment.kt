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
import com.example.meshop.adapter.PreviewProductAdapter
import com.example.meshop.adapter.PreviewShopAdapter
import com.example.meshop.model.PreviewProductItems
import com.example.meshop.model.PreviewShopItems
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment: Fragment(R.layout.fragment_home) {

    lateinit var previewProductAdapter: PreviewProductAdapter
    lateinit var previewShopAdapter: PreviewShopAdapter

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpSlider()
        setUpRecyclerView()



        val array = arrayListOf<PreviewProductItems>(
                PreviewProductItems(1,"iphone X2211","losAngles Apple Store  ","50,000,000","https"),
                PreviewProductItems(2,"samsung S20 forSell","samsung store in kore,Iran,china,japan,afghanistan","20,000,000","https"),
                PreviewProductItems(3,"laptop asus FX553VD GL553VD FX553Vd","shop3","25,000,000","https"))
        previewProductAdapter.differ.submitList(array.toList())

        val array2 = arrayListOf<PreviewShopItems>(
            PreviewShopItems(1,"shop 1 this is in isfahan city",2.5f,"image"),
            PreviewShopItems(2,"shop 2 places in tehran city",3.5f,"image"),
            PreviewShopItems(3,"shop 33 place in shiraz city",5.0f,"image"))
        previewShopAdapter.differ.submitList(array2.toList())
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
        previewProductAdapter = PreviewProductAdapter()
        rv_home_row_one.apply {
            adapter = previewProductAdapter
            layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        }

        previewShopAdapter = PreviewShopAdapter()
        rv_home_row_shop.apply {
            adapter = previewShopAdapter
            layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        }
    }

}