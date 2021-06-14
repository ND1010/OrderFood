package com.dhruv.orderfood.ui.activity

import android.os.Bundle
import com.dhruv.orderfood.databinding.ActivityDashboardBinding
import com.dhruv.orderfood.utils.base.BaseActivity

class DashboardActivity : BaseActivity() {

    companion object{
        val TAG = DashboardActivity::class.java.simpleName
    }
    private lateinit var binding : ActivityDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}