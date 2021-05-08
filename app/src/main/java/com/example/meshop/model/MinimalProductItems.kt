package com.example.meshop.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


data class MinimalProductItems(
        @PrimaryKey(autoGenerate = true)
        var id: Int? = null,
        val title: String?,
        val shop: String?,
        val price: String?,
        val urlImage: String?
)