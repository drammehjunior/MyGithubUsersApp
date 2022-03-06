package com.example.mygithubview

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Github(
    var name: String,
    var username: String,
    var avatar: Int,
    var location: String,
    var repository: String,
    var company: String,
    var followers: String,
    var following: String
): Parcelable