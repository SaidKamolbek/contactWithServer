package com.example.dependencyinjection.presenter.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dependencyinjection.data.model.request.RegisterUser
import com.example.dependencyinjection.data.model.request.VerifyCode
import com.example.dependencyinjection.data.model.responce.RegisterMessage
import com.example.dependencyinjection.data.model.responce.VerifyMessage
import com.example.dependencyinjection.domain.RegisterRepository
import com.example.dependencyinjection.domain.impl.RegisterRepositoryImpl
import com.example.dependencyinjection.presenter.RegisterScreenViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterScreenViewModelImpl @Inject constructor(
    private val registerRepository: RegisterRepositoryImpl,
) : ViewModel(), RegisterScreenViewModel {

    override var registerMessage: LiveData<String> = MutableLiveData()
    override var verifyMessage: LiveData<VerifyMessage> = MutableLiveData()
    override val error: LiveData<String> = registerRepository.error

    override fun registerUser(user: RegisterUser) {
        viewModelScope.launch {
            registerMessage = registerRepository.registerUser(user)
        }
    }


    override fun verifyCode(code: VerifyCode) {
        viewModelScope.launch {
            verifyMessage = registerRepository.verifyCode(code)
        }
    }
}