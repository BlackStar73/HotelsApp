package com.hotel.testapp.di

import android.app.Application
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.haroldadmin.cnradapter.NetworkResponseAdapterFactory
import com.hotel.testapp.data.network.ApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService =
        retrofit.create(ApiService::class.java)

    @Provides
    fun provideConverter(json: Json): Converter.Factory {
        return json.asConverterFactory("application/json".toMediaType())
    }

    @[Provides Singleton]
    fun provideJsonSerializer(): Json {
        return Json {
            ignoreUnknownKeys = true
            isLenient = true
            encodeDefaults = false
        }
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(
        chuckerInterceptor: ChuckerInterceptor
    ): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .addInterceptor(chuckerInterceptor)
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(
        converter: Converter.Factory,
        okHttpClient: OkHttpClient
    ): Retrofit =
        Retrofit.Builder()
            .baseUrl("https://run.mocky.io/v3/")
            .addConverterFactory(converter)
            .addCallAdapterFactory(NetworkResponseAdapterFactory()).client(okHttpClient).build()


    @Provides
    @Singleton
    fun provideChucker(application: Application): ChuckerInterceptor {
        return ChuckerInterceptor.Builder(application.applicationContext).maxContentLength(250_000L)
            .alwaysReadResponseBody(true).build()
    }

}