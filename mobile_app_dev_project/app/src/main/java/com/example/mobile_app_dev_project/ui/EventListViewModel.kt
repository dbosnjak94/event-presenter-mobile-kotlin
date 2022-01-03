package com.example.mobile_app_dev_project.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobile_app_dev_project.data.model.Event
import com.example.mobile_app_dev_project.data.repository.EventRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EventListViewModel (
    private val repository: EventRepository = EventRepository()
): ViewModel() {

    val eventData: MutableLiveData<List<Event>> = MutableLiveData()

    fun getData() {
        viewModelScope.launch(Dispatchers.IO) {
            val data = repository.getEvents()
            eventData.postValue(data)
        }
    }

}