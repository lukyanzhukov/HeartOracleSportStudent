package com.heartoracle.sport.student.core.domain.usecase.set

interface SetUseCase<T> {
    fun setCurrent(current: T)
}