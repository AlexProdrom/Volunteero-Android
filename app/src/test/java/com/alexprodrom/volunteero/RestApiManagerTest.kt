package com.alexprodrom.volunteero

import com.alexprodrom.volunteero.data.api.RestApiManager
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before

import org.junit.Test

class RestApiManagerTest {

    lateinit var restApiManager: RestApiManager

    @Before
    fun setUp() {
        restApiManager = RestApiManager()
    }

    @Test
    fun shouldGetEventsFromApi() {
        val response = restApiManager.getNews().execute()

        assertThat(response.isSuccessful, `is`(equalTo(true)))
    }
}