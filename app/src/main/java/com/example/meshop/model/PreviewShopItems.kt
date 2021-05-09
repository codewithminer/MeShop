package com.example.meshop.model

import androidx.room.PrimaryKey

data class PreviewShopItems(
        val id: Int?,
        val name: String?,
        val city: String?,
        val star: Float?,
        val urlImage: String?
)