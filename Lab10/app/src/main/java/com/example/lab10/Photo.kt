package com.example.lab10

import com.google.gson.annotations.SerializedName

data class Photo (
    @SerializedName("id")
    var id: Int,
    @SerializedName("albumId")
    var albumId: Int,
    @SerializedName("title")
    var title: String,
    @SerializedName("url")
    var url: String,
    @SerializedName("thumbnailUrl")
    var thumbnailUrl: String,
)