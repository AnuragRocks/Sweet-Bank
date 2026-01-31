package com.anurag.payees

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.anurag.payees.entities.Payee
import com.anurag.payees.entities.PayeeAccount
import com.anurag.payees.entities.PayeeType
import com.anurag.payees.entities.Payees
import com.anurag.payees.network.PayeesApi
import com.anurag.payees.repository.PayeesRepository

import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers.any
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class RepositoryTest {


    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    private val payeeAccount = PayeeAccount("", "", null, null, null, null, null)
    private val payee =
        Payee(listOf(payeeAccount), null, null, null, null, null, "", PayeeType.BUSINESS, "", "")

    private val api = mockk<PayeesApi>() {
        coEvery { getPayees() } returns Payees(listOf(payee))
    }
    lateinit var repository: PayeesRepository

    @Before
    fun setUp() {
        repository = PayeesRepository(api)
    }


    @ExperimentalCoroutinesApi
    @Test
    fun `test payeesApi coroutine retrieve`() = runBlocking {

        val result = repository.retrievePayees()
        assertEquals(result, listOf(payee))
    }
}
