package com.anurag.sweetbankapp

import android.app.Application
import com.anurag.account.repository.accountRepositoryModule
import com.anurag.account.repository.userRepositoryModule
import com.anurag.dashboardModule
import com.anurag.network.di.baseNetworkModule
import com.anurag.repository.transactionsRepositoryModule
import com.anurag.sweetbankapp.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class SweetBank : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@SweetBank)
            modules(
                dashboardModule, viewModelModule, userRepositoryModule, baseNetworkModule,
                accountRepositoryModule, transactionsRepositoryModule
            )
        }
    }
}
