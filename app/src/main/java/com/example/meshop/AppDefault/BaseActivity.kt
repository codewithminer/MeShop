package com.example.meshop.AppDefault

import android.os.Bundle
import android.util.Log
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.meshop.R

abstract class BaseActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(contentViewLayoutRes())
        setUpInitialFragment(savedInstanceState)
    }

    private fun setUpInitialFragment(savedInstanceState: Bundle?){
        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.frameLayout_main, createInitialFragment())
                .commit();
        }
    }

    @LayoutRes
    protected abstract fun contentViewLayoutRes(): Int

    protected abstract fun createInitialFragment(): Fragment
}