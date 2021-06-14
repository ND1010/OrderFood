package com.dhruv.orderfood.data.pref

import com.dhruv.orderfood.App

object UserSession {

    private const val KEY_IS_LOGIN = "Pref.keyIsLogin"
    private const val KEY_ID = "Pref.keyId"

    var keyIsLogin: Boolean
        get() = App.spUser.getBoolean(KEY_IS_LOGIN, false)
        set(isLogin) = App.spUser.edit().putBoolean(KEY_IS_LOGIN, isLogin).apply()

    var keyId: String?
        get() = App.spUser.getString(KEY_ID, "")
        set(id) = App.spUser.edit().putString(KEY_ID, id).apply()

    fun clearSession() {
        App.spUser.edit().clear().apply()
    }

}