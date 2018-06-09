package com.alexprodrom.volunteero.data.remote.login

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.alexprodrom.volunteero.model.ServerResponse
import retrofit2.Retrofit
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.converter.moshi.MoshiConverterFactory

class LoginRepository {

    private val loginApi: LoginApi

    init {
        // TODO: check what is the logging used for
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(logging)

        val retrofit = Retrofit.Builder()
                .client(httpClient.build())
                .addConverterFactory(MoshiConverterFactory.create())
                .baseUrl("https://volunteero-auth.herokuapp.com")
                .build()

        loginApi = retrofit.create(LoginApi::class.java)
    }

    fun loginPost(username: String, password: String): LiveData<ServerResponse> {
        val data = MutableLiveData<ServerResponse>()
        loginApi.post(username, password).enqueue(object : Callback<ServerResponse> {
            override fun onResponse(call: Call<ServerResponse>?, response: Response<ServerResponse>?) {
                if (response != null) {
                    data.value = response.body()
                }
            }

            override fun onFailure(call: Call<ServerResponse>?, t: Throwable?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })
        return data
    }
}