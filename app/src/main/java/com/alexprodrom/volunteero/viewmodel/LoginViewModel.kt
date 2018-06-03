package com.alexprodrom.volunteero.viewmodel

import android.arch.lifecycle.ViewModel
import com.alexprodrom.volunteero.model.User


class LoginViewModel: ViewModel() {
    private var userId: String? = null
    private val user: User? = null

    fun init(userId: String) {
        this.userId = userId
    }

    fun getUser(): User? {
        return user
    }

}