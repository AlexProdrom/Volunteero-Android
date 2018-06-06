package com.alexprodrom.volunteero.ui

import android.databinding.BindingAdapter
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.annotation.Nullable
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alexprodrom.volunteero.R
import com.alexprodrom.volunteero.databinding.EventListFragmentBinding
import com.alexprodrom.volunteero.viewmodel.EventListViewModel
import kotlinx.android.synthetic.main.event_list_fragment.*


class EventListFragment : Fragment() {

    private var mBinding: EventListFragmentBinding? = null

    private val rvEvents by lazy {
        rv_events
        rv_events.setHasFixedSize(true)
        rv_events.isNestedScrollingEnabled = false
        rv_events
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.event_list_fragment, container, false)
        mBinding?.isLoading = false
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        //viewmodel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvEvents.adapter = EventsAdapter()
    }

    private fun subscribeUi(viewModel: EventListViewModel) {
        // Update the list when the data changes
        viewModel.getProducts().observe(this, { myProducts ->
            if (myProducts != null) {
                mBinding.setIsLoading(false)
                mProductAdapter.setProductList(myProducts)
            } else {
                mBinding.setIsLoading(true)
            }
            // espresso does not know how to wait for data binding's loop so we execute changes
            // sync.
            mBinding.executePendingBindings()
        })
    }
}

@BindingAdapter("visibleGone")
fun showHide(view: View, show: Boolean) {
    view.visibility = if (show) View.VISIBLE else View.GONE
}