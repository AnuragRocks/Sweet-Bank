package com.anurag.repository

import com.anurag.account.entities.Account
import com.anurag.entities.StarlingTransaction
import com.anurag.network.TransactionsApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TransactionsRepository (
    private val transactionsApi: TransactionsApi
) {

    /**
     * This method will retrieve the list of transactions for a specific account
     */
    suspend fun retrievePurchases(
        account: Account,
        startDate: String,
        endDate: String
    ): List<StarlingTransaction> {

        return withContext(Dispatchers.IO) {
            return@withContext transactionsApi.getPurchasesInAWeek(
                account.accountUid,
                account.defaultCategory,
                startDate,
                endDate
            ).feedItems
        }

    }
}
