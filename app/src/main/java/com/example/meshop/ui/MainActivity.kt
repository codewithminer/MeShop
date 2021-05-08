package com.example.meshop.ui

import android.os.Build
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.meshop.R
import com.example.meshop.util.makeStatusBarTransparent
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpStatusBar()
        bottomNavigationView.setupWithNavController(navHostFragment.findNavController())

    }

    private fun setUpStatusBar(){
        val window: Window = this@MainActivity.window
        if(Build.VERSION.SDK_INT > 21){
            makeStatusBarTransparent()
        }
        else{
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.statusBarColor = ContextCompat.getColor(this@MainActivity, R.color.status_bar_color)
        }
    }
}