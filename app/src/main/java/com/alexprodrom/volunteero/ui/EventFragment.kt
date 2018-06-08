package com.alexprodrom.volunteero.ui

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alexprodrom.volunteero.R
import com.alexprodrom.volunteero.databinding.EventListFragmentBinding
import com.alexprodrom.volunteero.model.Event
import org.parceler.Parcels
import java.security.Key


class EventFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //val binding: EventListFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.event_fragment, container, false)

        val event:Event = Parcels.unwrap(arguments!!.getParcelable(KEY_EVENT));
        return null
    }

    companion object {
        val KEY_EVENT = "event"

        fun forEvent(event: Event): EventFragment {
            val fragment = EventFragment()
            val args = Bundle()
            args.putParcelable(KEY_EVENT, Parcels.wrap(event))
            fragment.setArguments(args)
            return fragment
        }
    }
}