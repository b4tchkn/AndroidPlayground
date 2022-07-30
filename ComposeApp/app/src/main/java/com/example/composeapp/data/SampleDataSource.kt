package com.example.composeapp.data

import com.example.composeapp.model.Sample2Model
import com.example.composeapp.model.SampleModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SampleDataSource {
    suspend fun getSample1(): SampleModel = withContext(Dispatchers.IO) {
        SampleModel(
            title = "タイトル",
            description = "ディスクリプション"
        )
    }

    suspend fun getSample2(): Sample2Model = withContext(Dispatchers.IO) {
        Sample2Model(
            title = "タイトル2",
            description = "ディスクリプション2"
        )
    }
}