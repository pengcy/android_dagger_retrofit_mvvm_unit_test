package com.example.dagger_retrofit_mvvm.ui.github

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.example.dagger_retrofit_mvvm.data.GithubAccount
import com.example.dagger_retrofit_mvvm.data.GithubApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import retrofit2.Response
import javax.inject.Inject

class GithubFragmentViewModel
@Inject constructor(private val githubApi: GithubApi) : ViewModel() {
    private val compositeDisposable = CompositeDisposable()
    var githubAccount = MutableLiveData<GithubAccount>()

    internal fun fetchGithubAccountInfo(username: String) {
        val disposable = githubApi.getGithubAccountObservable(username)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableObserver<Response<GithubAccount>>() {
                    override fun onNext(response: Response<GithubAccount>) {
                        githubAccount.value = response.body()
                    }

                    override fun onComplete() {}

                    override fun onError(e: Throwable) {
                        e.printStackTrace()
                    }
                })
        compositeDisposable.add(disposable)
    }

    // This is called by the Android Activity when the activity is destroyed
    override fun onCleared() {
        Log.d("GithubActivityViewModel", "onCleared()")
        compositeDisposable.dispose()
        super.onCleared()
    }
}
