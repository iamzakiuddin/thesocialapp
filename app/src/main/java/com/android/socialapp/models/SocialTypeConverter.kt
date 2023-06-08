package com.android.socialapp.models

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class SocialTypeConverter {

    @TypeConverter
    fun toString(value: List<Socials>) : String{
        return Gson().toJson(value)
    }

    @TypeConverter
    fun fromString(value: String) : List<Socials>{
        val typetoken = object: TypeToken<List<Socials>>(){}.type
        return Gson().fromJson(value,typetoken)
    }
}