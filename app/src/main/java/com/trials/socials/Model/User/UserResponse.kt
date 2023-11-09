package com.trials.socials.Model.User

import com.google.gson.annotations.SerializedName

data class UserResponse(
    @SerializedName("firstname") val firstname: String,
    @SerializedName("surname") val surname: String,
    @SerializedName("username") val username: String,
    @SerializedName("token") val token: String,
);
