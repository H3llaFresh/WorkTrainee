package by.vlfl.fxsuperpro.ui.screens.start.signup.step1.countryOfResidence

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.vlfl.fxsuperpro.databinding.ItemCountryOfResidenceBinding
import by.vlfl.fxsuperpro.domain.models.CountryOfResidence

class CountriesOfResidenceAdapter(private val handler: CountryOfResidenceItemHandler) :
        RecyclerView.Adapter<CountryOfResidenceViewHolder>() {

    private val items: MutableList<CountryOfResidence> = mutableListOf()

    override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
    ): CountryOfResidenceViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ItemCountryOfResidenceBinding = ItemCountryOfResidenceBinding.inflate(inflater, parent, false)
        return CountryOfResidenceViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CountryOfResidenceViewHolder, position: Int) {
        holder.setCountry(items[position], handler)
    }

    override fun getItemCount(): Int = items.size

    fun replaceItems(newItems: List<CountryOfResidence>) {
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }
}

class CountryOfResidenceItemHandler(private val clickListener: (CountryOfResidence) -> Unit) {
    operator fun invoke(
            countryResidence: CountryOfResidence
    ) {
        clickListener.invoke(countryResidence)
    }
}