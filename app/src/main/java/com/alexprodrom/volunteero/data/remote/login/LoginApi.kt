package com.alexprodrom.volunteero.data.remote.login

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.POST
import retrofit2.http.FormUrlEncoded

interface LoginApi {

    @FormUrlEncoded
    @POST("https://volunteero-auth.herokuapp.com/auth")
    fun post(@Field("username") username: String,
             @Field("password") password: String
    ): Call<ServerResponse>
}