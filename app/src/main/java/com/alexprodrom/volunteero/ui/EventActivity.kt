package com.alexprodrom.volunteero.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.alexprodrom.volunteero.R
import com.alexprodrom.volunteero.model.Event

class EventActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event)

        if (savedInstanceState == null) {
            val fragment = EventListFragment()

            supportFragmentManager.beginTransaction().add(R.id.fragment_container_event, fragment).commit()
        }
    }

    fun show(event: Event) {
        val productFragment = EventFragment.forEvent(event.id)

        supportFragmentManager
                .beginTransaction()
                .addToBackStack("product")
                .replace(R.id.fragment_container_event,
                        productFragment, null).commit()
    }
}
