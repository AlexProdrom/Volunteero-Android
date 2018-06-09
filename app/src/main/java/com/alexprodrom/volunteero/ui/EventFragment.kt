package com.alexprodrom.volunteero.ui

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alexprodrom.volunteero.R
import com.alexprodrom.volunteero.databinding.EventFragmentBinding
import com.alexprodrom.volunteero.model.Event
import org.parceler.Parcels

class EventFragment : Fragment() {

    private var mBinding: EventFragmentBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: EventFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.event_fragment, container, false)
        val event: Event = Parcels.unwrap(arguments!!.getParcelable(KEY_EVENT));
        binding.event = event

        binding.tvEventLocation.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_place_24dp, 0, 0, 0)
        binding.tvEventDate.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_date_range_24dp, 0, 0, 0)
        binding.tvEventVolunteers.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_account_circle_24dp, 0, 0, 0)
        binding.tvEventPoints.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_points_24dp, 0, 0, 0)
        return binding.root
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