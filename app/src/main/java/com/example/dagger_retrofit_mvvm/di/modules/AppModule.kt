package com.example.dagger_retrofit_mvvm.di.modules

import android.content.Context
import com.example.dagger_retrofit_mvvm.MyApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = arrayOf(ViewModelModule::class, NetworkModule::class))
class AppModule {

    @Provides
    @Singleton
    fun provideContext(application : MyApp): Context {
        return application.applicationContext
    }

}