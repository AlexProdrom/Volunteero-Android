package com.alexprodrom.volunteero

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.event_card_view.view.*
import kotlin.collections.ArrayList


class EventsAdapter : RecyclerView.Adapter<EventsAdapter.EventViewHolder>() {

    val items by lazy {
        ArrayList<Event>()
    }

    init {
        items.add(Event("Panda saving", "Let's save these pandas!", 5))
        items.add(Event("Tigers saving", "Let's save these tigers!", 2))
        items.add(Event("Romania saving", "Let's save these romanians!", 0))
        items.add(Event("Time saving", "Let's save these minutes!", 1000000))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder = EventViewHolder(parent)

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) = holder.bind(items[position])

    override fun getItemCount(): Int = items.count()

    class EventViewHolder(parent: ViewGroup) :
            RecyclerView.ViewHolder(parent.inflate(R.layout.event_card_view)) {

        fun bind(item: Event) = with(itemView) {
            tv_event_name.text = item.title
            tv_event_description.text = item.description
            tv_event_participants.text = item.participants.toString()
        }
    }
}

fun ViewGroup.inflate(layoutId: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutId, this, attachToRoot)
}

