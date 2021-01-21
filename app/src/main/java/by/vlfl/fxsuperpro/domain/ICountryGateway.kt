package by.vlfl.fxsuperpro.domain

import by.vlfl.fxsuperpro.domain.models.CountryOfResidence

interface ICountryGateway {
    suspend fun getCountriesOfResidence(): List<CountryOfResidence>
}