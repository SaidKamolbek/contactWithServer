package com.example.dependencyinjection.domain.impl

import android.util.Log
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

    private val registerMessage: MutableLiveData<RegisterMessage> = MutableLiveData()
    val error: MutableLiveData<String> = MutableLiveData()
    private val verifyMessage: MutableLiveData<VerifyMessage> = MutableLiveData()

    override fun registerUser(user: RegisterUser): LiveData<RegisterMessage> {
        newsApi.registerUser(user).enqueue(object : Callback<RegisterMessage> {
            override fun onResponse(
                call: Call<RegisterMessage>,
                response: Response<RegisterMessage>
            ) {
                if (response.isSuccessful) {
                    when (response.code()) {
                        in 200..299 -> {
                            registerMessage.value = response.body()
                            Log.d("TTT", response.body()!!.message)
                        }
                        in 400..499 -> error.value = response.message()

                    }
                    Log.d("TTT", response.message())

                } else {
                    error.value = response.message()
                    Log.d("TTT", response.message())
                }
            }

            override fun onFailure(call: Call<RegisterMessage>, t: Throwable) {
                error.value = t.message
                Log.d("TTT", t.message.toString())
            }
        })
        return registerMessage
    }


    override fun verifyCode(code: VerifyCode): LiveData<VerifyMessage> {
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