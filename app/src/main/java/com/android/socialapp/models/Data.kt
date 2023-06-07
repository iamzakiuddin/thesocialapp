package com.android.socialapp.models

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("header")
    var header: Header,

    @SerializedName("body")
    var body: Body
)
