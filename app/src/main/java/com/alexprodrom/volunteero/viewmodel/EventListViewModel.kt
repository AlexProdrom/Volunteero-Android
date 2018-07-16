package com.alexprodrom.volunteero.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.alexprodrom.volunteero.data.remote.event.EventRepository
import com.alexprodrom.volunteero.model.Event

class EventListViewModel() : ViewModel() {

    private var mEvents: LiveData<List<Event>>

    init {
        val mEventRepository = EventRepository()
        mEvents = mEventRepository.getEvents()
    }

    fun getEvents(): LiveData<List<Event>> = mEvents
}
