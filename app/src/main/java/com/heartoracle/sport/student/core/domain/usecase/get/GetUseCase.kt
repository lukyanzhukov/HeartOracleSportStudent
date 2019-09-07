package com.heartoracle.sport.student.core.domain.usecase.get

interface GetUseCase<T> {
    fun getCurrent(): T
}