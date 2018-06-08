package com.alexprodrom.volunteero.ui

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.ViewGroup
import com.alexprodrom.volunteero.R
import com.alexprodrom.volunteero.model.Event
import com.alexprodrom.volunteero.utils.inflate
import kotlinx.android.synthetic.main.event_card_view.view.*
import kotlin.collections.ArrayList

class EventAdapter(val eventOnClickCallback: EventClickCallback) : RecyclerView.Adapter<EventAdapter.EventViewHolder>() {

    val items = ArrayList<Event>()

    fun addEvents(events: List<Event>) {
        items.clear()
        items.addAll(events)
        notifyDataSetChanged()
        Log.d("Lifecycle error", "addEvents")
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder = EventViewHolder(parent)

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) = holder.bind(items[position], eventOnClickCallback)

    override fun getItemCount(): Int = items.count()

    class EventViewHolder(parent: ViewGroup) :
            RecyclerView.ViewHolder(parent.inflate(R.layout.event_card_view)) {

        fun bind(item: Event, eventOnClickCallback: EventClickCallback) = with(itemView) {
            Log.d("Lifecycle error", "binding events")
            tv_event_title.text = item.name
            tv_event_description.text = item.category
            tv_event_date.text = item.start
            btn_view_event.setOnClickListener({
                eventOnClickCallback.onClick(item)
            })
        }
    }
}


