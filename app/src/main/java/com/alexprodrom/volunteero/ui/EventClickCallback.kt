package com.alexprodrom.volunteero.ui

import com.alexprodrom.volunteero.model.Event

interface EventClickCallback {
    fun onClick(event: Event)
}