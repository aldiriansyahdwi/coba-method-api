package com.example.methodapi.register


import com.google.gson.annotations.SerializedName

data class Register(
    @SerializedName("data")
    val dataRegister: DataRegister?,
    @SerializedName("success")
    val success: Boolean?
)

data class DataRegister(
    @SerializedName("email")
    val email: String?,
    @SerializedName("_id")
    val id: String?,
    @SerializedName("username")
    val username: String?
)