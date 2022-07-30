package com.example.composeapp.domain

interface UseCase<Param, Result> {
    suspend fun call(param: Param): Result
}