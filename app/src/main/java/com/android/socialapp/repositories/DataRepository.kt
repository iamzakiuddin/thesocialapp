package com.android.socialapp.repositories

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.android.socialapp.models.Body
import com.android.socialapp.models.Data
import com.android.socialapp.network.DataApi
import com.android.socialapp.network.NetworkResponse
import com.android.socialapp.repositories.CacheRepository.DataDao
import retrofit2.Response
import java.lang.Exception
import javax.inject.Inject


class DataRepository @Inject constructor (private val dataApi: DataApi, private val dataDao: DataDao){

    var repoData = MutableLiveData<NetworkResponse<Body>>()

    suspend fun getDataFromRepo () {
        var list = dataDao.getData()
        if (!list.isNullOrEmpty()){
            repoData.value = NetworkResponse.Success(list[0])
        }else{
            getDataFromRemote()
        }
    }
     suspend fun getDataFromRemote (){
         try {
             var response = dataApi.getUIData()
             handleResponse(response)
         }catch (ex: Exception){
            repoData.value = NetworkResponse.Error("Something went wrong",null)
         }
    }


    private suspend fun handleResponse(response: Response<Data>) {
        if (response.isSuccessful && response.body()!=null){
            if (response.body()?.body!=null){
                storingInLocalDB(response.body()?.body)
            }
        }else if (response.errorBody()!=null){
            repoData.value = NetworkResponse.Error(response.message(),null)
        }
    }

    private suspend fun storingInLocalDB(body: Body?) {
        if (body!=null){
            dataDao.insertData(body)
            getDataFromRepo()
        }
    }

}