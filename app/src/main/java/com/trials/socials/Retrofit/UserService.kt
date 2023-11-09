package com.trials.socials.Retrofit

import com.trials.socials.Model.User.UserRequest
import com.trials.socials.Model.User.UserResponse
import com.trials.socials.data.model.LoggedInUser
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET

interface UserService {
    @GET("user/login")
    fun login(@Body user: UserRequest): Call<UserResponse>
}