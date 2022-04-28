package com.example.dependencyinjection.data.source.remote

import androidx.lifecycle.LiveData
import com.example.dependencyinjection.data.model.request.RegisterUser
import com.example.dependencyinjection.data.model.request.VerifyCode
import com.example.dependencyinjection.data.model.responce.BaseResponse
import com.example.dependencyinjection.data.model.responce.RegisterMessage
import com.example.dependencyinjection.data.model.responce.VerifyMessage
import com.example.dependencyinjection.data.source.local.dao.BaseDao
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface NewsApi {
    @GET
    fun getNewsByCategory(@Query("category") category: String): Call<BaseResponse>

    // register user
    @POST("register")
    suspend fun registerUser(@Body user: RegisterUser): Call<RegisterUser>

    @POST("verify")
    suspend fun verifyCode(@Body code: VerifyCode): Call<VerifyMessage>



}