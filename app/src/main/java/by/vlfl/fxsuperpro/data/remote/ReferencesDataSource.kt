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
                        status = "active"
                ),
                CountryOfResidenceJson(
                        name = "Hungary",
                        code = "HU",
                        current = false,
                        imageUrl = "@drawable/ic_flag_hu",
                        status = "active"
                ),
                CountryOfResidenceJson(
                        name = "Japan",
                        code = "JP",
                        current = false,
                        imageUrl = "@drawable/ic_flag_jp",
                        status = "active"
                ),
                CountryOfResidenceJson(
                        name = "Russia",
                        code = "RU",
                        current = false,
                        imageUrl = "@drawable/ic_flag_ru",
                        status = "active"
                ),
                CountryOfResidenceJson(
                        name = "United Kingdom",
                        code = "UK",
                        current = false,
                        imageUrl = "@drawable/ic_flag_uk",
                        status = "active"
                ),
                CountryOfResidenceJson(
                        name = "United States of America",
                        code = "US",
                        current = false,
                        imageUrl = "@drawable/ic_flag_us",
                        status = "active"
                )
        )
        //withContext(Dispatchers.IO) {
        //httpApi.getCountriesOfResidence()
        //}
    }
}