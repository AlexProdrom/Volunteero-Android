package com.alexprodrom.volunteero.data.remote.event

import com.alexprodrom.volunteero.model.Event
import retrofit2.Call
import retrofit2.http.GET


interface EventApi {

    @GET("/events")
    fun getEvents(): Call<List<Event>>
}