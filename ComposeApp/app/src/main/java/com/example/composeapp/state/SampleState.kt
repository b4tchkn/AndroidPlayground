package com.example.composeapp.state

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.composeapp.domain.GetSampleUseCase
import com.example.composeapp.model.SampleModel
import com.example.composeapp.model.UiModel
import kotlinx.coroutines.launch

class SampleState(
    private val useCase: GetSampleUseCase = GetSampleUseCase(),
    override val state: MutableLiveData<UiModel<SampleModel>> = MutableLiveData()
) : AtomState<SampleModel>() {
    init {
        viewModelScope.launch {
            fetch()
        }
    }

    override suspend fun fetch() = useCase.call(Unit).fold(
        onSuccess = { state.value = UiModel(data = it, error = null) },
        onFailure = { state.value = UiModel(data = null, error = it.message) },
    )
}