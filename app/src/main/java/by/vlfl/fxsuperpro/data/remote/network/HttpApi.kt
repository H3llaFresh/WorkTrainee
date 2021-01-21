package by.vlfl.fxsuperpro.data.remote.network

import by.vlfl.fxsuperpro.data.json.models.CountryOfResidenceJson
import retrofit2.http.GET

interface HttpApi {

    @GET("/v1/registration/countries")
    suspend fun getCountriesOfResidence(): List<CountryOfResidenceJson>

}