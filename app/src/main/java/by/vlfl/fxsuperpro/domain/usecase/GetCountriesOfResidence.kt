package by.vlfl.fxsuperpro.domain.usecase

import by.vlfl.fxsuperpro.domain.ICountryGateway
import by.vlfl.fxsuperpro.domain.models.CountryOfResidence

class GetCountriesOfResidence(private val countryGateway: ICountryGateway) {
    suspend operator fun invoke(): List<CountryOfResidence> {
        return countryGateway.getCountriesOfResidence()
    }
}

