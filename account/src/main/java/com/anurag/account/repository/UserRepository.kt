package com.anurag.account.repository

import com.anurag.account.entities.User
import com.anurag.account.network.UserApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UserRepository (
    private val userApi: UserApi
) {

    suspend fun retrieveUser(): User {
        return withContext(Dispatchers.IO) {
            userApi.getUser()
        }
    }
}
