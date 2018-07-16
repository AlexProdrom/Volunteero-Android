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

    fun getEvents() = arrayOf(
            arrayOf("id1", "Saving pandas", "To save pandas all around the world", "20.04.2018", "20.04.2018", "Eindhoven", 4392, "animals", 100, "3", true),
            arrayOf("id2", "Panda saving", "Let's save these pandas!", "20.04.2018", "20.04.2018", "Berlin", 504, "animals", 100, "1", false),
            arrayOf("id3", "Tigers saving", "Let's save these tigers!", "20.04.2018", "20.04.2018", "Paris", 22, "animals", 100, "2", false))

    @Test
    @Parameters(method = "getEvents")
    fun constructorShouldSetFields(id: String, name: String, description: String, start: String, end:
    String, location: String, volunteers: Int, category: String, points: Int, orgId: String, available: Boolean) {
        val event = Event(id, name, description, start, end, location, volunteers, category, points, orgId, available)

        assertThat(event.name, `is`(name))
        assertThat(event.description, `is`(description))
        assertThat(event.location, `is`(location))
        assertThat(event.start, `is`(start))
        assertThat(event.end, `is`(end))
        assertThat(event.volunteers, `is`(volunteers))
        assertThat(event.category, `is`(category))
        assertThat(event.points, `is`(points))
        assertThat(event.organizationId, `is`(orgId))
        assertThat(event.available, `is`(available))
    }

    @Test
    fun constructorShouldNotSetDescription() {
        val event = Event(name = "Save the Pandas", volunteers = 241, start = "12.03.2018")

        assertThat(event.name, `is`(notNullValue()))
        assertThat(event.volunteers, `is`(equalTo(241)))
        assertThat(event.start, `is`(equalTo("12.03.2018")))

        assertThat(event.description, `is`(equalTo("")))
    }

    @Test
    fun constructorShouldWorkEmpty() {
        val event = Event()

        assertThat(event, `is`(notNullValue()))
    }
}