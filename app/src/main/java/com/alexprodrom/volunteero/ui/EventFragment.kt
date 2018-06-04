package com.alexprodrom.volunteero.ui

import android.os.Bundle
import android.support.v4.app.Fragment


class EventFragment: Fragment() {



    companion object {
        /** Creates product fragment for specific product ID  */
        fun forEvent(eventId: String): EventFragment {
            val fragment = EventFragment()
            val args = Bundle()
            //args.putInt(KEY_PRODUCT_ID, productId)
            fragment.setArguments(args)
            return fragment
        }
    }
}