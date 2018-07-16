package com.alexprodrom.volunteero.data.remote.login

import com.alexprodrom.volunteero.model.ServerResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface LoginApi {

    @FormUrlEncoded
    @POST("/auth/login")
    fun post(@Field("username") username: String,
             @Field("password") password: String
    ): Call<ServerResponse>
}