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

    lateinit var previewShopAdapter: PreviewShopAdapter
    lateinit var previewProductAdapterMen: PreviewProductAdapter
    lateinit var previewProductAdapterWomen: PreviewProductAdapter
    lateinit var previewProductAdapterBoy: PreviewProductAdapter
    lateinit var previewProductAdapterGirl: PreviewProductAdapter

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpSlider()
        setUpRecyclerView()


        val array1 = arrayListOf<PreviewShopItems>(
            PreviewShopItems(1,"shop 1 this is in isfahan city",2.5f,"image"),
            PreviewShopItems(2,"shop 2 places in tehran city",3.5f,"image"),
            PreviewShopItems(3,"shop 3 place in shiraz city",5.0f,"image"))
        previewShopAdapter.differ.submitList(array1.toList())

        val array2 = arrayListOf<PreviewProductItems>(
                PreviewProductItems(1,"men product 1","losAngles Apple Store  ","50,000,000","https"),
                PreviewProductItems(2,"men product 2","samsung store in kore,Iran,china,japan,afghanistan","20,000,000","https"),
                PreviewProductItems(3,"men product 3","shop3","25,000,000","https"))
        previewProductAdapterMen.differ.submitList(array2.toList())

        val array3 = arrayListOf<PreviewProductItems>(
                PreviewProductItems(1,"women product 1","losAngles Apple Store  ","50,000,000","https"),
                PreviewProductItems(2,"women product 2","samsung store in kore,Iran,china,japan,afghanistan","20,000,000","https"),
                PreviewProductItems(3,"women product 3","shop3","25,000,000","https"))
        previewProductAdapterWomen.differ.submitList(array3.toList())

        val array4 = arrayListOf<PreviewProductItems>(
                PreviewProductItems(1,"boy product 1","losAngles Apple Store  ","50,000,000","https"),
                PreviewProductItems(2,"boy product 2","samsung store in kore,Iran,china,japan,afghanistan","20,000,000","https"),
                PreviewProductItems(3,"boy product 3","shop3","25,000,000","https"))
        previewProductAdapterBoy.differ.submitList(array4.toList())

        val array5 = arrayListOf<PreviewProductItems>(
                PreviewProductItems(1,"girl product 1","losAngles Apple Store  ","50,000,000","https"),
                PreviewProductItems(2,"girl product 2","samsung store in kore,Iran,china,japan,afghanistan","20,000,000","https"),
                PreviewProductItems(3,"girl product 3","shop3","25,000,000","https"))
        previewProductAdapterGirl.differ.submitList(array5.toList())
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

        previewShopAdapter = PreviewShopAdapter()
        rv_home_row_shop.apply {
            adapter = previewShopAdapter
            layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        }

        previewProductAdapterMen = PreviewProductAdapter()
        rv_home_row_men.apply {
            adapter = previewProductAdapterMen
            layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        }

        previewProductAdapterWomen = PreviewProductAdapter()
        rv_home_row_women.apply {
            adapter = previewProductAdapterWomen
            layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        }

        previewProductAdapterBoy = PreviewProductAdapter()
        rv_home_row_boy.apply {
            adapter = previewProductAdapterBoy
            layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        }

        previewProductAdapterGirl = PreviewProductAdapter()
        rv_home_row_girl.apply {
            adapter = previewProductAdapterGirl
            layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        }
    }

}