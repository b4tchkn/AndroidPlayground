package com.example.composeapp.domain

import com.example.composeapp.data.SampleDataSource
import com.example.composeapp.model.Sample2Model
import com.example.composeapp.model.SampleModel
import kotlinx.coroutines.delay

class Sample2UseCase(
    private val dataSource: SampleDataSource = SampleDataSource(),
) : UseCase<Unit, Result<Sample2Model>> {

    override suspend fun call(param: Unit): Result<Sample2Model> = runCatching {
        delay(5000L)
        dataSource.getSample2()
    }

}