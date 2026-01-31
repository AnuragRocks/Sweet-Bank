package com.anurag.account.repository

import com.anurag.account.network.AccountApi
import org.koin.dsl.module
import retrofit2.Retrofit

val accountRepositoryModule = module {

    single {
        AccountRepository(get())
    }

    single {
        (get() as Retrofit.Builder).build()
            .create(AccountApi::class.java)
    }
}
