package com.alexprodrom.volunteero.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.alexprodrom.volunteero.model.Event

class EventListViewModel: ViewModel() {

    private val mEvents: MutableLiveData<List<Event>> = MutableLiveData()

    fun getEvents(): LiveData<List<Event>> = mEvents

}
