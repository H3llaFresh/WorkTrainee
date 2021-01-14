package by.vlfl.fxsuperpro.data

import by.vlfl.fxsuperpro.data.json.models.CountryOfResidenceJson

interface IRemoteReferencesDataSource {
    suspend fun getCountriesOfResidence(): List<CountryOfResidenceJson>
}