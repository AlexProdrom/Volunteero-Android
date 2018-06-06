package com.alexprodrom.volunteero.ui

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.alexprodrom.volunteero.R
import com.alexprodrom.volunteero.model.Event
import com.alexprodrom.volunteero.utils.inflate
import kotlinx.android.synthetic.main.event_card_view.view.*
import kotlin.collections.ArrayList


class EventAdapter : RecyclerView.Adapter<EventAdapter.EventViewHolder>() {

    val items = ArrayList<Event>()

    fun addEvents(events: List<Event>) {
        items.clear()
        items.addAll(events)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder = EventViewHolder(parent)

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) = holder.bind(items[position])

    override fun getItemCount(): Int = items.count()

    class EventViewHolder(parent: ViewGroup) :
            RecyclerView.ViewHolder(parent.inflate(R.layout.event_card_view)) {

        fun bind(item: Event) = with(itemView) {
            tv_event_title.text = item.name
            tv_event_description.text = item.category
            tv_event_date.text = item.start
        }
    }
}


