package com.android.socialapp.models

import com.google.gson.annotations.SerializedName

data class Header(
    @SerializedName("code")
    var code: Int? = null,
    @SerializedName("message")
    var message: String? = null
)
