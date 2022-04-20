package com.example.methodapi

import com.example.methodapi.login.Login
import com.example.methodapi.login.LoginRequest
import com.example.methodapi.register.Register
import com.example.methodapi.register.RegisterRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {
//    @FormUrlEncoded
//    @POST("auth/register")
//    fun postRegister(@Field("email") email: String?, @Field("username") username: String?, @Field("password") password: String?): Call<Register>
//
//    @FormUrlEncoded
//    @POST("auth/login")
//    fun postLogin(@Field("email") email: String, @Field("password") password: String): Call<Login>

    @POST("auth/register")
    fun tryRegister(@Body requestBody: RegisterRequest): Call<Register>

    @POST("auth/login")
    fun tryLogin(@Body requestBody: LoginRequest): Call<Login>
}