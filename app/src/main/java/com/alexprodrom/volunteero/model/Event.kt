package com.alexprodrom.volunteero.model

import com.squareup.moshi.Json

data class Event(@Json(name = "_id") val id: String = "",
                 val name: String = "",
                 val description: String = "",
                 val start: String = "",
                 val end: String = "",
                 val location: String = "",
                 val volunteers: Int = 0,
                 val category: String = "",
                 val points: Int = 0,
                 val organizationId: String = "", // needs mapping
                 val available: Boolean = false)