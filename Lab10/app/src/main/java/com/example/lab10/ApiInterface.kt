package com.example.lab10

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiInterface {
    @GET("/photos/{id}")
    suspend fun getPhotoById(@Path("id") id: Int) : Response<Photo>

    @POST("/photos/")
    suspend fun addPhoto(@Body photo: Photo) : Response<AddPhotoResponse>
}