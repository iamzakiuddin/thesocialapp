package com.android.socialapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.socialapp.models.Body
import com.android.socialapp.network.NetworkResponse
import com.android.socialapp.repositories.DataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.reflect.Constructor
import javax.inject.Inject

@HiltViewModel
class DataViewModel @Inject constructor(private val repository: DataRepository) : ViewModel() {
    val uiData: LiveData<NetworkResponse<Body>>
        get() = repository.repoData


    fun getUIData() {
        repository.repoData.postValue(NetworkResponse.Loading())
        viewModelScope.launch {
            repository.getDataFromRepo()
        }
    }

    fun getFreshUIData() {
        repository.repoData.postValue(NetworkResponse.Loading())
        viewModelScope.launch{
            repository.getDataFromRemote()
        }
    }
}