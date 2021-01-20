package by.vlfl.fxsuperpro.ui.bindAdapters

import android.net.Uri
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import by.vlfl.fxsuperpro.domain.models.CountryOfResidence

object CountryBindingAdapter {
    @JvmStatic
    @BindingAdapter(value = ["country_flag"])
    fun setCountryFlag(imageView: ImageView, uri: Uri?) {
//        if (uri != null) {
//            Glide.with(imageView).load(uri).into(imageView)
//        }
    }

    @JvmStatic
    @BindingAdapter(value = ["country_name"])
    fun setCountryName(view: TextView, countryOfResidence: CountryOfResidence?) {
        if (countryOfResidence != null) {
            view.text = countryOfResidence.name
        } else {
            view.text = null
        }
    }
}