package com.example.assignment1.Data

import com.google.gson.annotations.SerializedName

data class RequestLoginData(
    @SerializedName("email")
    val email: String,
    val password: String
)

data class RequestSignUpData(
    @SerializedName("email")
    val email: String,
    val name: String,
    val password: String
)
