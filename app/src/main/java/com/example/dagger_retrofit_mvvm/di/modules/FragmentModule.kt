package com.example.dagger_retrofit_mvvm.di.modules

import com.example.dagger_retrofit_mvvm.ui.github.GithubFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {
    @ContributesAndroidInjector
    abstract fun contributeGithubFragment() : GithubFragment
}