package com.alexprodrom.volunteero

import com.alexprodrom.volunteero.data.remote.login.LoginRepository
import com.alexprodrom.volunteero.model.Event
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.Before
import org.junit.Test

class LoginRepositoryTest {
    lateinit var loginRepository: LoginRepository

    @Before
    fun setUp() {
        loginRepository = LoginRepository()
    }

    @Test
    fun shouldGetEventsFromApi() {
        val response = loginRepository.loginPost("liisu", "11qqaa!!QQAA")
    }
}