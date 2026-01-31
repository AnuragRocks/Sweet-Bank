package com.anurag.payees.network

import com.anurag.account.entities.Account
import com.anurag.network.API_KEY
import com.anurag.network.API_VERSION
import com.anurag.payees.entities.Payee
import com.anurag.payees.entities.PayeeCreationResponse
import com.anurag.payees.entities.Payees
import retrofit2.Response
import retrofit2.http.*
import java.time.Instant

interface PayeesApi {

    @GET("api/$API_VERSION/payees")
    suspend fun getPayees(
        @Header("Authorization") token: String = "Bearer $API_KEY",
        @Header("Accept") value: String = "application/json"
    ): Payees


    @PUT("api/${API_VERSION}/payees")
    suspend fun createPayee(
        @Body body: Payee,
        @Header("Authorization") token: String = "Bearer $API_KEY",
        @Header("Accept") value: String = "application/json"
    ): Response<PayeeCreationResponse>
}
