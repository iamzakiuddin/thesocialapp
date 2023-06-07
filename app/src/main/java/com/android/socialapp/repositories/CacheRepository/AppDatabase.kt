package com.android.socialapp.repositories.CacheRepository

import androidx.room.Database
import androidx.room.RoomDatabase
import com.android.socialapp.models.Body

@Database(entities = [Body::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun dataDao() : DataDao
}