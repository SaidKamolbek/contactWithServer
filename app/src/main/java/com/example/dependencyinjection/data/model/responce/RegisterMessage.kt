package com.example.dependencyinjection.data.model.responce

import android.os.Parcelable
import androidx.versionedparcelable.ParcelField
import com.google.gson.annotations.SerializedName


data class RegisterMessage(
    @SerializedName("message")
    val message: String
)