package com.android.socialapp.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity
data class Body(
    @ColumnInfo(name = "channels")
    @SerializedName("channels")
    var channels: ArrayList<Channels> = arrayListOf(),

    @ColumnInfo(name = "socials")
    @SerializedName("socials")
    var socials: ArrayList<Socials> = arrayListOf()
): Serializable{
    @PrimaryKey(autoGenerate = true)
    var id = 0
}
