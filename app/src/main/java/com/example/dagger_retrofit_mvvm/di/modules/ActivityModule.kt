package com.example.dagger_retrofit_mvvm.di.modules

import com.example.dagger_retrofit_mvvm.ui.github.GithubActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {
    @ContributesAndroidInjector(modules = arrayOf(FragmentModule::class))
    abstract fun contributeLoginActivity() : GithubActivity
}