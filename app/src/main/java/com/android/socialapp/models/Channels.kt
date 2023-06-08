package com.android.socialapp.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Channels (
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("url")
    val url : String? = null,
    @SerializedName("icon_url")
    var icon: String? = null,
    @SerializedName("package_name_android")
    var packagedNameAndroid: String? = null
        ) : Serializable