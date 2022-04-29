package com.example.dependencyinjection.ui.sceens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.dependencyinjection.R
import com.example.dependencyinjection.data.model.request.RegisterUser
import com.example.dependencyinjection.databinding.RegisterScreenBinding
import com.example.dependencyinjection.domain.impl.RegisterRepositoryImpl
import com.example.dependencyinjection.presenter.RegisterScreenViewModel
import com.example.dependencyinjection.presenter.impl.RegisterScreenViewModelImpl
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class RegisterScreen : Fragment(R.layout.register_screen) {

    private val viewModel: RegisterScreenViewModel by viewModels<RegisterScreenViewModelImpl>()
    private val binding by viewBinding(RegisterScreenBinding::bind)
    private val navController by lazy(LazyThreadSafetyMode.NONE) { findNavController() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        viewModel.registerMessage.observe(viewLifecycleOwner) {
            Snackbar.make(binding.root, it.message, Snackbar.LENGTH_SHORT).show()
        }
//        viewModel.verifyMessage.observe(viewLifecycleOwner) {
//            Snackbar.make(binding.root, it.token, Snackbar.LENGTH_SHORT).show()
//        }
        viewModel.error.observe(viewLifecycleOwner) {
            Snackbar.make(binding.root, it, Snackbar.LENGTH_SHORT).show()
        }


        binding.registerButton.setOnClickListener {
            val name = binding.registerName.text.toString()
            val surname = binding.registerLastName.text.toString()
            val phone = binding.registerPhone.text.toString()
            val password = binding.registerPassword.text.toString()
            viewModel.registerUser(RegisterUser(name, surname, phone, password))
        }
    }


}