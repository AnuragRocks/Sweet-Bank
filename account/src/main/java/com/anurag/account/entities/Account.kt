package com.anurag.account.entities


data class Account(
    val accountUid: String,
    val defaultCategory: String,
    val currency: String,
    val createdAt: String
)
