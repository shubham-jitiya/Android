package com.example.myapplication.uiwidgets.models

import android.os.Parcel
import android.os.Parcelable

data class UserFragment(val firstName: String?, var lastName: String?) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(firstName)
        parcel.writeString(lastName)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<UserFragment> {
        override fun createFromParcel(parcel: Parcel): UserFragment {
            return UserFragment(parcel)
        }

        override fun newArray(size: Int): Array<UserFragment?> {
            return arrayOfNulls(size)
        }
    }
}