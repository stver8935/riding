package com.stver8935.riding.data.remote.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class LoginRequest(
    @Expose(serialize = true, deserialize = false) @SerializedName("id") val id: String,
    @Expose(serialize = true, deserialize = false) @SerializedName("password") val password: String
)