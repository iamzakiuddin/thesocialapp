package com.android.socialapp.network

sealed class NetworkResponse<T> (val data: T, message: String){
    //class Success(val data: T) : NetworkResponse()
}
