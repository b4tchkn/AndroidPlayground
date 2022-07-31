package com.example.composeapp.state

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.composeapp.domain.Sample2UseCase
import com.example.composeapp.model.Sample2Model
import com.example.composeapp.model.SampleModel
import com.example.composeapp.model.UiModel
import kotlinx.coroutines.launch

class Sample2State(
    private val useCase: Sample2UseCase = Sample2UseCase(),
    override val state: MutableLiveData<UiModel<Sample2Model>> = MutableLiveData()
) : AtomState<Sample2Model>() {
    init {
        viewModelScope.launch {
            fetch()
        }
    }

    override suspend fun fetch() = useCase.call(Unit).fold(
        onSuccess = {
            state.value = UiModel(data = it, error = null)
        },
        onFailure = { state.value = UiModel(data = null, error = it.message) },
    )
}