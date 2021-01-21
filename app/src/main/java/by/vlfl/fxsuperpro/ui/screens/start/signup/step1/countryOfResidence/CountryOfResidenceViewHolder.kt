package by.vlfl.fxsuperpro.ui.screens.start.signup.step1.countryOfResidence

import androidx.recyclerview.widget.RecyclerView
import by.vlfl.fxsuperpro.databinding.ItemCountryOfResidenceBinding
import by.vlfl.fxsuperpro.domain.models.CountryOfResidence

class CountryOfResidenceViewHolder(private val binding: ItemCountryOfResidenceBinding) :
    RecyclerView.ViewHolder(binding.root) {
        fun setCountry(
            countryItem: CountryOfResidence,
            handler: CountryOfResidenceItemHandler
        ) {
            binding.countryItem = countryItem
            binding.countryItemHandler = handler
            binding.executePendingBindings()
        }
}

