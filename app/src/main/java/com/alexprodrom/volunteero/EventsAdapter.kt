package com.alexprodrom.volunteero

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.alexprodrom.volunteero.utils.inflate
import kotlinx.android.synthetic.main.event_card_view.view.*
import kotlin.collections.ArrayList


class EventsAdapter : RecyclerView.Adapter<EventsAdapter.EventViewHolder>() {

    val items by lazy {
        ArrayList<Event>()
    }

    init {
        items.add(Event("Panda saving", "Let's save these pandas!", 5, "10.05.2018"))
        items.add(Event("Tigers saving", "Let's save these tigers!", 2, "12.10.2018"))
        items.add(Event("Romania saving", "Let's save these romanians!", 0, "29.02.2018"))
        items.add(Event("Time saving", "Let's save these minutes!", 1000000, "03.04.2019"))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder = EventViewHolder(parent)

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) = holder.bind(items[position])

    override fun getItemCount(): Int = items.count()

    class EventViewHolder(parent: ViewGroup) :
            RecyclerView.ViewHolder(parent.inflate(R.layout.event_card_view)) {

        fun bind(item: Event) = with(itemView) {
            tv_event_title.text = item.title
            tv_event_description.text = item.description
            tv_event_date.text = item.date
        }
    }
}


