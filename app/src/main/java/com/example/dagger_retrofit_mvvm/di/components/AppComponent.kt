package com.example.dagger_retrofit_mvvm.di.components

import com.example.dagger_retrofit_mvvm.MyApp
import com.example.dagger_retrofit_mvvm.di.modules.AppModule
import com.example.dagger_retrofit_mvvm.di.modules.ActivityModule
import com.example.dagger_retrofit_mvvm.di.modules.FragmentModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
        AndroidSupportInjectionModule::class,
        AppModule::class,
        ActivityModule::class,
        FragmentModule::class))
interface AppComponent : AndroidInjector<MyApp> {
    @Component.Builder
    abstract class Builder: AndroidInjector.Builder<MyApp>()
}