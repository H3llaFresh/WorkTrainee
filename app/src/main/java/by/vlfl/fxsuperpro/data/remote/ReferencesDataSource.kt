package by.vlfl.fxsuperpro.data.remote

import by.vlfl.fxsuperpro.data.IRemoteReferencesDataSource
import by.vlfl.fxsuperpro.data.json.models.CountryOfResidenceJson
import by.vlfl.fxsuperpro.data.remote.network.HttpApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ReferencesDataSource(
    private val httpApi: HttpApi
) : IRemoteReferencesDataSource {
    override suspend fun getCountriesOfResidence(): List<CountryOfResidenceJson> {
        return withContext(Dispatchers.IO) {
            httpApi.getCountriesOfResidence()
        }
    }
}