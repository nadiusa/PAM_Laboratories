package com.sample.app.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Client {

    val BASE_URL = "https://api.themoviedb.org/3/"
    lateinit var retrofit : Retrofit

    fun getClient(): Retrofit{
        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit
    }
}