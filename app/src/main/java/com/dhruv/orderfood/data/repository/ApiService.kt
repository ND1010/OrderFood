package com.dhruv.orderfood.data.repository

import com.dhruv.orderfood.data.models.login_master.LoginResponse
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiService {

    @Headers("Version: 1.0")
    @POST("BranchLogin")
    suspend fun apiLoginToapp(@Body request: RequestBody): Response<LoginResponse>
}