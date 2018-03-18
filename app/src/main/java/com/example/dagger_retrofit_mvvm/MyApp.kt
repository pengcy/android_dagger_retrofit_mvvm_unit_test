package com.example.dagger_retrofit_mvvm

import com.example.dagger_retrofit_mvvm.di.components.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class MyApp : DaggerApplication() {

    companion object {
        var instance: MyApp? = null
            private set
    }

    override fun applicationInjector() : AndroidInjector<MyApp> =
            DaggerAppComponent.builder().create(this@MyApp)

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

}