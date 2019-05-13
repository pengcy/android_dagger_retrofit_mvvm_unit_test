package com.example.dagger_retrofit_mvvm.di.modules

import dagger.Module

@Module(includes = arrayOf(ViewModelModule::class, NetworkModule::class))
class AppModule {

}