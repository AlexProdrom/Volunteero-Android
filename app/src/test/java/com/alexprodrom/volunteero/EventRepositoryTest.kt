package com.alexprodrom.volunteero

import android.arch.lifecycle.LiveData
import com.alexprodrom.volunteero.data.api.EventRepository
import com.alexprodrom.volunteero.model.Event
import org.hamcrest.CoreMatchers.*
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before

import org.junit.Test

class EventRepositoryTest {

    lateinit var eventRepository: EventRepository

    @Before
    fun setUp() {
        eventRepository = EventRepository()
    }

    @Test
    fun shouldGetEventsFromApi() {
        val response = eventRepository.getEvents()

        assertThat(response, instanceOf(Event::class.java))
    }
}