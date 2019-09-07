package com.heartoracle.sport.student.core.presentation

import android.os.Bundle
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel {

    internal val disposables = CompositeDisposable()

    open fun onUnbind() {
        disposables.dispose()
    }

    open fun onBind(state: Bundle? = null) = Unit

}