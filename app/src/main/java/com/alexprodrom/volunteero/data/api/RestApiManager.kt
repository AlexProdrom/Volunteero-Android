package com.alexprodrom.volunteero.data.api

import com.alexprodrom.volunteero.model.Event
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


class RestApiManager {

    private val redditApi: VolunteeroApi

    init {
        val retrofit = Retrofit.Builder()
                .baseUrl("https://volunteero-events.herokuapp.com")
                .addConverterFactory(MoshiConverterFactory.create())
                .build()

        redditApi = retrofit.create(VolunteeroApi::class.java)
    }

    fun getNews(): Call<List<Event>> {
        return redditApi.getEvents()
    }
}