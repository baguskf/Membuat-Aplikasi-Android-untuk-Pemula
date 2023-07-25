package com.example.bangkit

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Hotel(
    val name: String,
    val description: String,
    val photo: Int,
    val dataHotel : String
) : Parcelable

