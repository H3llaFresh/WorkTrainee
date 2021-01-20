package by.vlfl.fxsuperpro.ui.bindAdapters

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import by.vlfl.fxsuperpro.R
import by.vlfl.fxsuperpro.domain.models.CountryOfResidence

object CountryBindingAdapter {
//    @JvmStatic
//    @BindingAdapter(value = ["country_flag"])
//    fun setCountryFlag(imageView: ImageView, uri: Uri?) {
//        if (uri != null) {
//            Glide.with(imageView).load(uri).into(imageView)
//        }
//    }

    @JvmStatic
    @BindingAdapter(value = ["country_flag"])
    fun setCountryFlag(imageView: ImageView, uri: String?) {
        if (uri != null) {
            imageView.setImageResource(
                    when (uri) {
                        "@drawable/ic_flag_by" -> R.drawable.ic_flag_by
                        "@drawable/ic_flag_hu" -> R.drawable.ic_flag_hu
                        "@drawable/ic_flag_jp" -> R.drawable.ic_flag_jp
                        "@drawable/ic_flag_ru" -> R.drawable.ic_flag_ru
                        "@drawable/ic_flag_uk" -> R.drawable.ic_flag_uk
                        "@drawable/ic_flag_us" -> R.drawable.ic_flag_us
                        else -> R.drawable.ic_country_flag_unknown
                    }
            )
        }
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