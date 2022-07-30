package com.example.composeapp.domain

import com.example.composeapp.data.SampleDataSource
import com.example.composeapp.model.SampleModel
import kotlinx.coroutines.delay

class SampleUseCase(
    private val dataSource: SampleDataSource = SampleDataSource(),
) : UseCase<Unit, Result<SampleModel>> {

    override suspend fun call(param: Unit): Result<SampleModel> = runCatching {
        delay(3000L)
        dataSource.getSample1()
    }
}