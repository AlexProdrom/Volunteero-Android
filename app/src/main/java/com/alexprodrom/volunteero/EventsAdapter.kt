package com.alexprodrom.volunteero

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


class EventsAdapter: RecyclerView.Adapter<EventsAdapter.EventViewHolder>() {
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    class EventViewHolder(parent: ViewGroup):
            RecyclerView.ViewHolder(parent.inflate(R.id)){

    }
}

fun ViewGroup.inflate(layoutId: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutId, this, attachToRoot)
}