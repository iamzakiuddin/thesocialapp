package com.android.socialapp.models

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.Exception

class ChannelTypeConverter {

    @TypeConverter
    fun toString(value: List<Channels>) : String {
        return Gson().toJson(value)
    }

    @TypeConverter
    fun fromString (value: String) : List<Channels>{
        var typeToken = object : TypeToken<List<Channels>>(){}.type
        return Gson().fromJson(value,typeToken)
    }
}