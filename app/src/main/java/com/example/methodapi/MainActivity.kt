package com.example.methodapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.methodapi.databinding.ActivityMainBinding
import com.example.methodapi.login.Login
import com.example.methodapi.login.LoginRequest
import com.example.methodapi.register.Register
import com.example.methodapi.register.RegisterRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val email = binding.etEmail.text.toString()
        val username = binding.etUsername.text.toString()
        val password = binding.etPassword.text.toString()
        binding.btnRegister.setOnClickListener {
            val registerData = RegisterRequest(email, password, username)
            tryRegister(registerData)
        }
        binding.btnLogin.setOnClickListener {
            val loginData = LoginRequest(email, password)
            tryLogin(loginData)
        }
    }
    private fun tryLogin(loginData: LoginRequest){
        ApiClient.instance.tryLogin(loginData)
            .enqueue(object: Callback<Login>{
                override fun onResponse(call: Call<Login>, response: Response<Login>) {
                    val code = response.code()
                    if (code == 200){
                        Log.d("response-login", code.toString())
                    }
                    else {
                        Log.d("response-login", code.toString())
                    }
                }

                override fun onFailure(call: Call<Login>, t: Throwable) {
                    Log.d("response-login", "login error")
                }

            })
    }
    private fun tryRegister(registerData: RegisterRequest){
        ApiClient.instance.tryRegister(registerData)
            .enqueue(object : Callback<Register>{
                override fun onResponse(call: Call<Register>, response: Response<Register>) {
                    val code = response.code()
                    if(code == 201){
                        Log.d("response-register", code.toString())
                    }
                    else{
                        Log.d("response-register", code.toString())
                    }
                }

                override fun onFailure(call: Call<Register>, t: Throwable) {
                    Log.d("response-register", "register error")
                }

            })
    }
}