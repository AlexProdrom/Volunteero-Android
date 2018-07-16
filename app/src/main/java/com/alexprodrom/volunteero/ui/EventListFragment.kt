package com.alexprodrom.volunteero.ui

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.BindingAdapter
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alexprodrom.volunteero.R
import com.alexprodrom.volunteero.databinding.EventListFragmentBinding
import com.alexprodrom.volunteero.model.Event
import com.alexprodrom.volunteero.viewmodel.EventListViewModel

class EventListFragment : Fragment() {

    private var mBinding: EventListFragmentBinding? = null

    private var mEventAdapter: EventAdapter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: EventListFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.event_list_fragment, container, false)
        mBinding = binding

        mEventAdapter = EventAdapter(mEventClickCallback)
        binding.rvEvents.adapter = mEventAdapter
        binding.rvEvents.setHasFixedSize(true)
        binding.rvEvents.isNestedScrollingEnabled = false

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val viewModel = ViewModelProviders.of(this).get(EventListViewModel::class.java)
        subscribeUi(viewModel)
    }

    private fun subscribeUi(viewModel: EventListViewModel) {
        viewModel.getEvents().observe(this, Observer<List<Event>> { events ->
            if (events != null) {
                mBinding?.isLoading = false
                mEventAdapter?.addEvents(events)
            } else {
                mBinding?.isLoading = true
            }
            mBinding?.executePendingBindings()
        })
    }

    private val mEventClickCallback = object : EventClickCallback {
        override fun onClick(event: Event) {
            if (lifecycle.currentState.isAtLeast(Lifecycle.State.STARTED)) {
                (activity as EventActivity).show(event)
            }
        }
    }
}

// TODO: see what to do with this thing
@BindingAdapter("visibleGone")
fun showHide(view: View, show: Boolean) {
    view.visibility = if (show) View.GONE else View.VISIBLE
}