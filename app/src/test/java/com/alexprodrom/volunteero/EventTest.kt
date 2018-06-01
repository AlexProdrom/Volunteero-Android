package com.alexprodrom.volunteero

import com.alexprodrom.volunteero.model.Event
import junitparams.JUnitParamsRunner
import junitparams.Parameters
import org.hamcrest.CoreMatchers.*
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(JUnitParamsRunner::class)
class EventTest {

    // JUnitParams method
    fun getEvents() = arrayOf(
            arrayOf("Saving pandas", "To save pandas all around the world", 4392, "20.04.2018"),
            arrayOf("Panda saving", "Let's save these pandas!", 5, "10.05.2018"),
            arrayOf("Tigers saving", "Let's save these tigers!", 2, "12.10.2018"))

    @Test
    @Parameters(method = "getEvents")
    fun constructorShouldSetFields(title: String, description: String, participants: Int, date: String) {
        val event = Event(title, description, participants, date)

        // Hamcrest usage
        assertThat(event.title, `is`(title))
        assertThat(event.description, `is`(description))
        assertThat(event.participants, `is`(participants))
        assertThat(event.date, `is`(date))
    }

    @Test
    fun constructorShouldNotSetDescription() {
        val event = Event(title = "Save the Pandas", participants = 241, date = "12.03.2018")

        assertThat(event.title, `is`(notNullValue()))
        assertThat(event.description, `is`(equalTo("")))
    }

    @Test
    fun constructorShouldWorkEmpty() {
        val event = Event()

        assertThat(event,`is`(notNullValue()))
    }
}