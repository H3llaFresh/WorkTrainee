package by.vlfl.fxsuperpro.gateway

import by.vlfl.fxsuperpro.data.IRemoteReferencesDataSource
import by.vlfl.fxsuperpro.data.json.models.asDomainModel
import by.vlfl.fxsuperpro.domain.ICountryGateway
import by.vlfl.fxsuperpro.domain.models.CountryOfResidence

class CountryGateway(private val remote: IRemoteReferencesDataSource): ICountryGateway {

    override suspend fun getCountriesOfResidence(): List<CountryOfResidence> =
        remote.getCountriesOfResidence().map { it.asDomainModel() }

}