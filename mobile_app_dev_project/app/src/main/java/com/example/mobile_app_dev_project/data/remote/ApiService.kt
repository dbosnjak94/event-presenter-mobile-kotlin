package com.example.mobile_app_dev_project.data.remote

import com.example.mobile_app_dev_project.data.model.Event
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {
    @GET("event")
    suspend fun getEvents(): List<Event>

    companion object {
        private val baseUrl = "https://demo8138856.mockable.io/"
        val client: ApiService = Retrofit
            .Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

}