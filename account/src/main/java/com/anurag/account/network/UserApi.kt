package com.anurag.account.network

import com.anurag.account.entities.AccountBalance
import com.anurag.account.entities.Accounts
import com.anurag.account.entities.User
import com.anurag.network.API_KEY
import com.anurag.network.API_VERSION
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface UserApi {

    @GET("api/$API_VERSION/identity/individual")
    suspend fun getUser(
        @Header("Authorization") token: String = "Bearer $API_KEY",
        @Header("Accept") value: String = "application/json"
    ): User
}
