package com.anurag.account.repository

import com.anurag.account.entities.Account
import com.anurag.account.entities.AccountBalance
import com.anurag.account.entities.AccountHolder
import com.anurag.account.network.AccountApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.asRequestBody
import java.io.File


class AccountRepository(
    private val accountApi: AccountApi
) {

    private var accountCachedData: List<Account>? = null

    private suspend fun getAccountCachedData(): List<Account> {
        return if (accountCachedData != null) accountCachedData!! else
            accountApi.getAccounts().accounts

    }

    suspend fun retrieveAccounts(): List<Account> {
        return if (getAccountCachedData().isNullOrEmpty()) {
            emptyList()
        } else {
            getAccountCachedData()
        }
    }

    suspend fun retrieveAccountBalance(accountId: String): AccountBalance {

        return withContext(Dispatchers.IO) {
            accountApi.getAccountBalance(accountId)
        }

    }

    suspend fun retrieveAccountHolder(): AccountHolder {
        return withContext(Dispatchers.IO) {
            accountApi.getAccountHolder()
        }
    }

    suspend fun retrieveProfilePicture(accountHolderId: String): String {
        return withContext(Dispatchers.IO) {
            accountApi.getAccountPicture(accountHolder = accountHolderId)
        }
    }

    suspend fun uploadProfilePicture(
        accountHolderId: String,
        file: File
    ): Array<String>? {
        return withContext(Dispatchers.IO) {
            accountApi.uploadAccountPicture(
                accountHolder = accountHolderId,
                requestBody = file.asRequestBody("image/*".toMediaTypeOrNull())
            )
        }
    }
}
