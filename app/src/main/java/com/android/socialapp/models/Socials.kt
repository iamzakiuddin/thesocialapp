package com.android.socialapp.models

import com.google.gson.annotations.SerializedName

data class Socials(
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("url")
    val url : String? = null,
    @SerializedName("icon")
    var icon: String? = null,
    @SerializedName("packagedNameAndroid")
    var packagedNameAndroid: String? = null
)
