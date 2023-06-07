package com.android.socialapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.socialapp.network.DataApi
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var service : DataApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*CoroutineScope(Dispatchers.IO).launch {
            var response = service.getUIData()
            if (response.isSuccessful && response.body()!=null){

            }
        }*/
    }
}
