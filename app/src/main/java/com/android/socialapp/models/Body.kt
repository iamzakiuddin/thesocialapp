package com.android.socialapp.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity
@TypeConverters(ChannelTypeConverter::class,SocialTypeConverter::class)
data class Body(
    @ColumnInfo(name = "channels")
    @SerializedName("channels")
    var channels: List<Channels> = arrayListOf(),

    @ColumnInfo(name = "socials")
    @SerializedName("socials")
    var socials: List<Socials> = arrayListOf()
): Serializable{
    @PrimaryKey(autoGenerate = true)
    var id : Int = 0
}
