package by.vlfl.fxsuperpro.data.remote.network

import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit


fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
    return HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
}

fun provideOkHttpClient(logging: HttpLoggingInterceptor): OkHttpClient {
    return OkHttpClient.Builder()
        .addInterceptor(logging)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .connectTimeout(30, TimeUnit.SECONDS)
        .build()
}

fun provideHttpApi(baseUrl: String, moshi: Moshi, okHttpClient: OkHttpClient): HttpApi {
    return Retrofit.Builder().apply {
        addConverterFactory(MoshiConverterFactory.create(moshi).asLenient())
        client(okHttpClient)
        baseUrl(baseUrl)
    }.build().create()
}