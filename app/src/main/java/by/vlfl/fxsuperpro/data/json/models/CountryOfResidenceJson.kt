package by.vlfl.fxsuperpro.data.json.models

import by.vlfl.fxsuperpro.domain.models.CountryOfResidence
import by.vlfl.fxsuperpro.domain.models.CountryRegisterAvailability
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CountryOfResidenceJson(
        @Json(name = "name") val name: String,
        @Json(name = "code") val code: String,
        @Json(name = "current") val current: Boolean,
        @Json(name = "imageUrl") val imageUrl: String?,
        @Json(name = "status") val status: String
)

fun CountryOfResidenceJson.asDomainModel(): CountryOfResidence {
    return CountryOfResidence(
            name = name,
            code = code,
            current = current,
            //imageUrl = if (!imageUrl.isNullOrEmpty()) "$API_URL$imageUrl".toUri() else null,
            //imageUrl = if (!imageUrl.isNullOrEmpty()) "$imageUrl".toUri() else null,
            imageUrl = imageUrl,
            status = when (status) {
                "active" -> CountryRegisterAvailability.Active
                "inactive" -> CountryRegisterAvailability.Inactive
                "restricted" -> CountryRegisterAvailability.Restricted
                "blocked" -> CountryRegisterAvailability.Blocked
                else -> CountryRegisterAvailability.Unknown
            }
    )
}