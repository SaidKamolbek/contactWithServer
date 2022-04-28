package com.example.dependencyinjection.presenter

import androidx.lifecycle.LiveData
import com.example.dependencyinjection.data.model.request.RegisterUser
import com.example.dependencyinjection.data.model.request.VerifyCode
import com.example.dependencyinjection.data.model.responce.RegisterMessage
import com.example.dependencyinjection.data.model.responce.VerifyMessage

interface RegisterScreenViewModel {

    val registerMessage: LiveData<String>
    val verifyMessage: LiveData<VerifyMessage>
    val error: LiveData<String>
    fun registerUser(user: RegisterUser)

    fun verifyCode(code: VerifyCode)

}