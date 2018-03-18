package com.example.dagger_retrofit_mvvm

import android.arch.core.executor.testing.InstantTaskExecutorRule
import android.arch.lifecycle.Observer
import com.example.dagger_retrofit_mvvm.data.GithubAccount
import com.example.dagger_retrofit_mvvm.data.GithubApi
import com.example.dagger_retrofit_mvvm.ui.github.GithubFragmentViewModel
import org.junit.Before
import org.junit.ClassRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import io.reactivex.Observable
import retrofit2.Response

@RunWith(MockitoJUnitRunner::class)
class GithubActivityViewModelTest {

    // A JUnit Test Rule that swaps the background executor used by
    // the Architecture Components with a different one which executes each task synchronously.
    // You can use this rule for your host side tests that use Architecture Components.
    @Rule
    @JvmField
    var rule = InstantTaskExecutorRule()

    // Test rule for making the RxJava to run synchronously in unit test
    companion object {
        @ClassRule
        @JvmField
        val schedulers = RxImmediateSchedulerRule()
    }

    @Mock
    lateinit var githubApi: GithubApi

    @Mock
    lateinit var observer: Observer<GithubAccount>

    lateinit var githubFragmentViewModel: GithubFragmentViewModel


    @Before
    fun setUp() {
        // initialize the ViewModel with a mocked github api
        githubFragmentViewModel = GithubFragmentViewModel(githubApi)
    }

    @Test
    fun shouldShowGithubAccountLoginName() {
        // mock data
        val githubAccountName = "google"
        val githubAccount = GithubAccount(githubAccountName)

        // make the github api to return mock data
        Mockito.`when`(githubApi!!.getGithubAccountObservable(githubAccountName))
                .thenReturn(Observable.just(Response.success(githubAccount)))

        // observe on the MutableLiveData with an observer
        githubFragmentViewModel.githubAccount.observeForever(observer!!)
        githubFragmentViewModel.fetchGithubAccountInfo(githubAccountName)

        // assert that the name matches
        assert(githubFragmentViewModel.githubAccount.value!!.login == githubAccountName)
    }

}
