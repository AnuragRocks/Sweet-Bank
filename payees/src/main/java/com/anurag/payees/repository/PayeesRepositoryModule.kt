package com.anurag.payees.repository

import com.anurag.network.BASE_URL
import com.anurag.payees.network.PayeesApi
import retrofit2.Retrofit

class PayeesRepositoryModule {


    fun providesPayeesApi(retrofit: Retrofit.Builder): PayeesApi {
        return retrofit
            .baseUrl(BASE_URL)
            .build()
            .create(PayeesApi::class.java)
    }
}
