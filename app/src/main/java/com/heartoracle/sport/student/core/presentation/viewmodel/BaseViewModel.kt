package com.heartoracle.sport.student.core.presentation.viewmodel

import io.reactivex.disposables.CompositeDisposable
import androidx.lifecycle.ViewModel

abstract class BaseViewModel : ViewModel() {
    protected val compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}
