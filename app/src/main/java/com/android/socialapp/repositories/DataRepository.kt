package com.android.socialapp.repositories

import androidx.lifecycle.MutableLiveData
import com.android.socialapp.models.Body
import com.android.socialapp.models.Data
import com.android.socialapp.network.DataApi
import com.android.socialapp.repositories.CacheRepository.DataDao
import retrofit2.Response
import javax.inject.Inject


class DataRepository @Inject constructor (private val dataApi: DataApi){

    var remoteData = MutableLiveData<Body>()

   /* suspend fun getData(){
        var data = db.getData()
        if (data!=null){
            if (data.isNotEmpty()){
                val data = data[0]
                remoteData.postValue(data)
            }
        }else{
            getDataFromRemote()
        }
    }*/
     suspend fun getDataFromRemote (){
        var response = dataApi.getUIData()
         handleResponse(response)
    }


    private suspend fun handleResponse(response: Response<Data>) {
        if (response.isSuccessful && response.body()!=null){
            if (response.body()?.body!=null){
                remoteData.postValue(response.body()?.body)
                //storingInLocalDB(response.body()?.body)
            }
        }
    }

  /*  private suspend fun storingInLocalDB(body: Body?) {
        if (body!=null){
            db.insertData(body)
            getData()
        }
    }*/

}