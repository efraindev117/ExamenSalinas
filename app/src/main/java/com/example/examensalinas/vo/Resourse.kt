package com.example.examensalinas.vo

import java.lang.Exception

class Resourse{
    sealed class Resourse<out T> {
        class Loading<out T>: Resourse<T>()
        data class Success<out T>(val data: T): Resourse<T>()
        data class Failure(val exception: Exception): Resourse<Nothing>()
    }
}