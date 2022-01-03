package com.example.mobile_app_dev_project.data.repository

import com.example.mobile_app_dev_project.data.remote.ApiService

class EventRepository (
    private val apiService: ApiService = ApiService.client
        ){
    suspend fun getEvents() = apiService.getEvents()
}