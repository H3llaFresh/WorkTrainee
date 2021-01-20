package by.vlfl.fxsuperpro.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CountryOfResidence(
    val name: String,
    val code: String,
    val current: Boolean,
    //val imageUrl: Uri?,
    val imageUrl: String?,
    val status: CountryRegisterAvailability
): Parcelable