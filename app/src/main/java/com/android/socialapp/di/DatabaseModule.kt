package com.android.socialapp.di

import android.content.Context
import androidx.room.Room
import com.android.socialapp.repositories.CacheRepository.AppDatabase
import com.android.socialapp.repositories.CacheRepository.DataDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDb (@ApplicationContext context: Context) : AppDatabase{
        return Room.databaseBuilder(context,AppDatabase::class.java,"localdb").build()
    }

    @Provides
    fun provideDataDao (appDatabase: AppDatabase) : DataDao{
        return appDatabase.dataDao()
    }
}