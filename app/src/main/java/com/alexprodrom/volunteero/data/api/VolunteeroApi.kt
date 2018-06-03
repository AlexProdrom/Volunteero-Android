package com.alexprodrom.volunteero.data.api

import com.alexprodrom.volunteero.model.Event
import retrofit2.Call
import retrofit2.http.GET


interface VolunteeroApi {

    @GET("/events")
    fun getEvents(): Call<List<Event>>
}