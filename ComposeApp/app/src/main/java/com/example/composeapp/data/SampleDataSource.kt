package com.example.composeapp.data

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.composeapp.model.Sample2Model
import com.example.composeapp.model.SampleModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.time.LocalDateTime

class SampleDataSource {
    suspend fun getSample1(): SampleModel = withContext(Dispatchers.IO) {
        SampleModel(
            title = "タイトル",
            description = "ディスクリプション"
        )
    }

    @RequiresApi(Build.VERSION_CODES.O)
    suspend fun getSample2(): Sample2Model = withContext(Dispatchers.IO) {
        Sample2Model(
            title = "タイトル2",
            description = "${LocalDateTime.now()}"
        )
    }
}