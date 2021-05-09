package com.example.meshop.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


data class PreviewProductItems(

        val id: Int?,
        val title: String?,
        val shop: String?,
        val city: String?,
        val price: String?,
        val urlImage: String?
)