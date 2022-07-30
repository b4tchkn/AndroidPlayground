package com.example.composeapp.model

data class UiModel<T>(
    val data: T?,
    val error: String?,
)