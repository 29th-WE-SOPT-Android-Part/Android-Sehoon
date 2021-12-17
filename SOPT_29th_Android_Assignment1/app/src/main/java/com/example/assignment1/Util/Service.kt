package com.example.assignment1.Util

import com.example.assignment1.Data.RequestLoginData
import com.example.assignment1.Data.RequestSignUpData
import com.example.assignment1.Data.ResponseLoginData
import com.example.assignment1.Data.ResponseSignUpData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface Service {

    @Headers("Content-Type: application/json")
    @POST("user/login")
    fun postLogin(
        @Body requestLoginData: RequestLoginData
    ) : Call<ResponseLoginData>
}

interface Service2 {

    @Headers("Content-Type: application/json")
    @POST("user/signup")
    fun postSignUp(
        @Body requestSignUpData: RequestSignUpData
    ) : Call<ResponseSignUpData>
}