package com.example.dependencyinjection.domain.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.dependencyinjection.data.model.request.RegisterUser
import com.example.dependencyinjection.data.model.request.VerifyCode
import com.example.dependencyinjection.data.model.responce.RegisterMessage
import com.example.dependencyinjection.data.model.responce.VerifyMessage
import com.example.dependencyinjection.data.source.remote.NewsApi
import com.example.dependencyinjection.domain.RegisterRepository
import com.google.android.material.snackbar.Snackbar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class RegisterRepositoryImpl @Inject constructor(
    private val newsApi: NewsApi
) : RegisterRepository {

    private val registerMessage: MutableLiveData<String> = MutableLiveData()
    val error: MutableLiveData<String> = MutableLiveData()
    private val verifyMessage: MutableLiveData<VerifyMessage> = MutableLiveData()

    override suspend fun registerUser(user: RegisterUser): LiveData<String> {
        newsApi.registerUser(user).enqueue(object : Callback<RegisterUser> {
            override fun onResponse(
                call: Call<RegisterUser>,
                response: Response<RegisterUser>
            ) {
                if (response.isSuccessful) {
                    registerMessage.value = response.body()?.phone
                } else {
                    error.value = response.message()
                }
            }

            override fun onFailure(call: Call<RegisterUser>, t: Throwable) {
                error.value = t.message
            }
        })
        return registerMessage
    }


    override suspend fun verifyCode(code: VerifyCode): LiveData<VerifyMessage> {
        newsApi.verifyCode(code).enqueue(object : Callback<VerifyMessage> {
            override fun onResponse(call: Call<VerifyMessage>, response: Response<VerifyMessage>) {
                if (response.isSuccessful) {
                    verifyMessage.value = response.body()
                } else error.value = response.message()
            }

            override fun onFailure(call: Call<VerifyMessage>, t: Throwable) {
                error.value = t.message
            }
        })
        return verifyMessage
    }


}