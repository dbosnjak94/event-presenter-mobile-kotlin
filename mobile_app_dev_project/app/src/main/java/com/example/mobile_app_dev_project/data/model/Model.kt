package com.example.mobile_app_dev_project.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
data class Event (
    @PrimaryKey
    val id_event: Int,
    val name: String,
    val description: String,
    val image: String,
    val score: Double,
    val price: Int
    ): Parcelable