package com.example.dependencyinjection.data.model.request

data class RegisterUser(
    val firstName: String,
    val lastName: String,
    val phone: String,
    val password: String
)
