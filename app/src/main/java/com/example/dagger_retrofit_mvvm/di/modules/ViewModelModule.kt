package com.example.dagger_retrofit_mvvm.di.modules

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.dagger_retrofit_mvvm.ui.github.GithubActivityViewModel
import com.example.dagger_retrofit_mvvm.di.ViewModelFactory
import com.example.dagger_retrofit_mvvm.di.ViewModelKey
import com.example.dagger_retrofit_mvvm.ui.github.GithubFragmentViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory) : ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(GithubActivityViewModel::class)
    abstract fun bindGithubActivityViewModel(mainActivityViewModel: GithubActivityViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(GithubFragmentViewModel::class)
    abstract fun bindGithubFragmentViewModel(githubFragmentViewModel: GithubFragmentViewModel) : ViewModel

}