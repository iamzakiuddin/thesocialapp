package com.android.socialapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.socialapp.models.Body
import com.android.socialapp.repositories.DataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.reflect.Constructor
import javax.inject.Inject

@HiltViewModel
class DataViewModel @Inject constructor(private val repository: DataRepository) : ViewModel() {

    val uiData : LiveData<Body>
        get() = repository.remoteData

    fun getUIData() {
        viewModelScope.launch {
            repository.getDataFromRemote()
        }
    }

}