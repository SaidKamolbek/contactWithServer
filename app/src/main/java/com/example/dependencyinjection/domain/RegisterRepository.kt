package com.example.dependencyinjection.domain

import androidx.lifecycle.LiveData
import com.example.dependencyinjection.data.model.request.RegisterUser
import com.example.dependencyinjection.data.model.request.VerifyCode
import com.example.dependencyinjection.data.model.responce.RegisterMessage
import com.example.dependencyinjection.data.model.responce.VerifyMessage

interface RegisterRepository {

    fun registerUser(user: RegisterUser): LiveData<RegisterMessage>

    fun verifyCode(code: VerifyCode): LiveData<VerifyMessage>
}