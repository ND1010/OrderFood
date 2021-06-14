package com.dhruv.orderfood.utils.base

import androidx.appcompat.app.AppCompatActivity
import com.dhruv.orderfood.utils.ext.toast

abstract class BaseActivity: AppCompatActivity() {

    fun onUnexpectedError() {
        toast("Error")
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}