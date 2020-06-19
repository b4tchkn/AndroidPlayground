package com.batch.recyclerviewsample.ui.common

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.batch.recyclerviewsample.SampleRepository
import com.batch.recyclerviewsample.model.Music
import kotlinx.coroutines.launch
import java.lang.Exception

class CommonViewModel : ViewModel() {

    companion object {
        private const val BASE_URL = "http://private-e41e4-clasickmock.apiary-mock.com/"
    }

    var musicList = MutableLiveData<List<Music>>()
    private val api = SampleRepository(BASE_URL)

    fun fetchMusic() {
        viewModelScope.launch {
            try {
                musicList.value = api.getMusics()
            } catch (e: Exception) {
                e.stackTrace
            }
        }
    }

}