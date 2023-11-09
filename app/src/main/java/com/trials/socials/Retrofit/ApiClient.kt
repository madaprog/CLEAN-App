package com.trials.socials.Retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ApiClient {
    companion object{
        val BASE_URL = "http://127.0.0.1:8000/api/";

        fun getRetrofit(): Retrofit{
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        }

        fun getService() : UserService{
            val service: UserService = getRetrofit().create(UserService::class.java);
            return service;
        }
    }
}