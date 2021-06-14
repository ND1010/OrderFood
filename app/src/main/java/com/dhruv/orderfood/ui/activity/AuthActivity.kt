package com.dhruv.orderfood.ui.activity

import android.content.Intent
import android.os.Bundle
import com.dhruv.orderfood.databinding.ActivityAuthBinding
import com.dhruv.orderfood.utils.base.BaseActivity

class AuthActivity: BaseActivity() {

    private lateinit var binding: ActivityAuthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun initHome() {
        startActivity(Intent(this, DashboardActivity::class.java))
        finish()
    }
}