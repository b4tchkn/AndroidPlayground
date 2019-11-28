package com.batch.recyclerviewsample.ui.groupie

import android.app.Application
import androidx.lifecycle.*
import com.batch.recyclerviewsample.R
import com.batch.recyclerviewsample.SampleRepository
import com.batch.recyclerviewsample.model.Music
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import timber.log.Timber
import java.lang.Exception

class GroupieViewModel(application: Application) : AndroidViewModel(application) {
    var musics = MutableLiveData<List<Music>>()
    private val api = SampleRepository(application.applicationContext.getString(R.string.BASE_URL))

    fun fetchRemote() {
        viewModelScope.launch {
            try {
                musics.value = api.getMusics()
                Timber.d(musics.value.toString())
            } catch (e: Exception) {
                e.stackTrace
                Timber.d(e.toString())
            }
        }
    }
}