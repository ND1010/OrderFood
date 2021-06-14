package com.dhruv.orderfood.ui.activity

import android.os.Bundle
import com.dhruv.orderfood.databinding.ActivitySplashBinding
import com.dhruv.orderfood.utils.AppConstants
import com.dhruv.orderfood.utils.base.BaseActivity
import com.dhruv.orderfood.utils.ext.delay
import com.dhruv.orderfood.utils.ext.observe
import com.dhruv.orderfood.utils.ext.startActivityWithFade
import com.dhruv.orderfood.viewmodels.SplashViewModel
import io.reactivex.disposables.CompositeDisposable
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashActivity : BaseActivity() {

    private val viewModel by viewModel<SplashViewModel>()
    private lateinit var binding: ActivitySplashBinding
    private val compositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initSplash()
    }

    private fun initSplash() {
        viewModel.getValue()
        observe(viewModel.isLogin) {
            compositeDisposable.delay(AppConstants.SPLASH_TIME_MILLISECOND) {
                if (it) {
                    initHome()
                } else {
                    initAuth()
                }
            }
        }
    }

    private fun initAuth() {
        startActivityWithFade(this, AuthActivity::class.java)
        finish()
    }

    private fun initHome() {
        startActivityWithFade(this, DashboardActivity::class.java)
        finish()
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }

}
