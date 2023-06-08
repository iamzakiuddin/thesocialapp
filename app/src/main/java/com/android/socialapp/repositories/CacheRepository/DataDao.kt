package com.android.socialapp.repositories.CacheRepository

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.android.socialapp.models.Body

@Dao
interface DataDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertData (bodyData: Body)

    @Query("SELECT * FROM Body")
    suspend fun getData () : List<Body>
}