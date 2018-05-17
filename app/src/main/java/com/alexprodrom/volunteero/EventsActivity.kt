package com.alexprodrom.volunteero

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import hugo.weaving.DebugLog
import kotlinx.android.synthetic.main.activity_events.*

class EventsActivity : AppCompatActivity() {

    private val rvEvents by lazy {
        rv_events.setHasFixedSize(true)
        rv_events.layoutManager = LinearLayoutManager(this)
        rv_events
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_events)
        rvEvents.adapter = EventsAdapter()
    }
}
