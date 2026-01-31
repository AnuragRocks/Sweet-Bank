package com.anurag.account.repository

import com.anurag.account.network.UserApi
import org.koin.dsl.module
import retrofit2.Retrofit

val userRepositoryModule = module {

    single {
        UserRepository(get())
    }

    single<UserApi> {
        (get() as Retrofit.Builder).build()
            .create(UserApi::class.java)
    }
}
