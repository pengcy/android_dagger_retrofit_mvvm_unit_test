package com.example.dagger_retrofit_mvvm.ui

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.example.dagger_retrofit_mvvm.R
import com.example.dagger_retrofit_mvvm.ui.github.GithubActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun launchGithub(v: View) {
        startActivity(Intent(this, GithubActivity::class.java))
    }

}
