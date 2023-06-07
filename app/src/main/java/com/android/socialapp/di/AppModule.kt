package com.android.socialapp.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.android.socialapp.Constants
import com.android.socialapp.models.Body
import com.android.socialapp.network.DataApi
import com.android.socialapp.repositories.CacheRepository.AppDatabase
import com.android.socialapp.repositories.CacheRepository.DataDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class AppModule {

    @Singleton
    @Provides
    fun provideRetrofitBuilder () : Retrofit.Builder{
        return Retrofit.Builder().baseUrl(Constants.BASE_URL).addConverterFactory(GsonConverterFactory.create())
    }

    @Singleton
    @Provides
    fun provideRetrofit (retrofitBuilder: Retrofit.Builder) : DataApi {
        return retrofitBuilder.build().create(DataApi::class.java)
    }


}