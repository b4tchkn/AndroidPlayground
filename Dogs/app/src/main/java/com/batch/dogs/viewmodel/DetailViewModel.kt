package com.batch.dogs.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.batch.dogs.model.DogBreed
import com.batch.dogs.model.DogDatabse
import kotlinx.coroutines.launch

class DetailViewModel(application: Application): BaseViewModel(application) {
    val dogLiveData = MutableLiveData<DogBreed>()

    fun fetch(uuid: Int) {
        launch {
            val dog = DogDatabse(getApplication()).dogDao().getDog(uuid)
            dogLiveData.value = dog
        }
    }
}