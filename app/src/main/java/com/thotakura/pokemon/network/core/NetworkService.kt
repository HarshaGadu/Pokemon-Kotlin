package com.thotakura.pokemon.network.core

import com.thotakura.pokemon.util.ConfigurationUtils
import com.thotakura.pokemon.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object NetworkService {
    private var service: PokemonApi? = null

    fun service(): PokemonApi? {
        val httpClient = OkHttpClient.Builder()

        if (BuildConfig.DEBUG) {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY

            httpClient.addInterceptor(logging)
        }

        if (service == null) {
            val retrofit = Retrofit.Builder()
                .baseUrl(ConfigurationUtils.baseUrl)
                .client(httpClient.build())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            service = retrofit.create(PokemonApi::class.java)
        }

        return service
    }
}