package com.alexprodrom.volunteero.model

import com.squareup.moshi.Json
import org.parceler.Parcel

@Parcel(Parcel.Serialization.BEAN)
data class Event(@Json(name = "_id") val id: String = "",
                 val name: String = "",
                 val description: String = "",
                 val start: String = "",
                 val end: String = "",
                 val location: String = "",
                 val volunteers: Int = 0,
                 val category: String = "",
                 val points: Int = 0,
                 val organizationId: String = "",
                 val available: Boolean = false)