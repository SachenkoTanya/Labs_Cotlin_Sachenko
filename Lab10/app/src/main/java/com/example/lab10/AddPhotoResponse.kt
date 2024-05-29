package com.example.lab10

import com.google.gson.annotations.SerializedName

data class AddPhotoResponse (
    @SerializedName("id")
    var id: Int,
)