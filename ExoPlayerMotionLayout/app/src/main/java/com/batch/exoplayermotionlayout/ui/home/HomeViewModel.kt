package com.batch.exoplayermotionlayout.ui.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.batch.exoplayermotionlayout.ClasickMockRepository
import com.batch.exoplayermotionlayout.R
import com.batch.exoplayermotionlayout.model.Music
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber

class HomeViewModel(application: Application) : AndroidViewModel(application) {
    var musics = MutableLiveData<List<Music>>()
    private val api = ClasickMockRepository(application.applicationContext.getString(R.string.BASE_URL))
    private val scope = CoroutineScope(Dispatchers.Main)

    fun fetchRemote() {
        scope.launch {
            try {
                musics.value = api.getMusics()
                Timber.d(musics.value.toString())
            } catch (e: Exception) {
                Timber.d(e.toString())
                e.stackTrace
            }
        }
    }
}