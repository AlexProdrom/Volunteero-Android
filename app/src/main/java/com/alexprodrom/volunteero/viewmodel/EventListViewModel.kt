package com.alexprodrom.volunteero.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.alexprodrom.volunteero.data.api.EventRepository
import com.alexprodrom.volunteero.model.Event
import javax.inject.Inject

class EventListViewModel() : ViewModel() {

    private var mEvents: LiveData<List<Event>>

    init {
        val mEventRepository = EventRepository()
        mEvents = mEventRepository.getEvents()
    }

    fun getEvents(): LiveData<List<Event>> = mEvents
}
