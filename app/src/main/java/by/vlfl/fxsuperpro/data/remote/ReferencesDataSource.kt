package by.vlfl.fxsuperpro.data.remote

import by.vlfl.fxsuperpro.data.IRemoteReferencesDataSource
import by.vlfl.fxsuperpro.data.json.models.CountryOfResidenceJson

class ReferencesDataSource : IRemoteReferencesDataSource {

    override suspend fun getCountriesOfResidence(): List<CountryOfResidenceJson> {
        return listOf(
            CountryOfResidenceJson(
                name = "Belarus",
                code = "BY",
                current = false,
                imageUrl = "@drawable/ic_flag_by",
                status = "good"
            )
        )
        //withContext(Dispatchers.IO) {
        //httpApi.getCountriesOfResidence()
        //}
    }
}