package com.example.methodapi.login


import com.google.gson.annotations.SerializedName

data class Login(
    @SerializedName("data")
    val dataLogin: DataLogin?,
    @SerializedName("success")
    val success: Boolean?
)

data class DataLogin(
    @SerializedName("email")
    val email: String?,
    @SerializedName("_id")
    val id: String?,
    @SerializedName("token")
    val token: String?,
    @SerializedName("username")
    val username: String?
)