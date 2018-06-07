package com.alexprodrom.volunteero.data.remote.login

import retrofit2.Retrofit
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.converter.moshi.MoshiConverterFactory


class LoginRepository {

    fun loginPost(username: String, password: String) {

        //Here a logging interceptor is created
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

        //The logging interceptor will be added to the http client
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(logging)

        //The Retrofit builder will have the client attached, in order to get connection logs
        val retrofit = Retrofit.Builder()
                .client(httpClient.build())
                .addConverterFactory(MoshiConverterFactory.create())
                .baseUrl("https://volunteero-events.herokuapp.com")
                .build()
        val service = retrofit.create(Interface::class.java!!)

        val call = service.post("login", username, password)

        call.enqueue(object : Callback<ServerResponse>() {
            fun onResponse(call: Call<ServerResponse>, response: Response<ServerResponse>) {
                BusProvider.getInstance().post(ServerEvent(response.body()))
                Log.e(TAG, "Success")
            }

            fun onFailure(call: Call<ServerResponse>, t: Throwable) {
                // handle execution failures like no internet connectivity
                BusProvider.getInstance().post(ErrorEvent(-2, t.message))
            }
        })
    }
}