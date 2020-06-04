package com.work.gobob.network.di

import com.work.gobob.network.api.KAKAOLocalApi
import org.koin.core.parameter.parametersOf
import org.koin.dsl.module
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val KAKAO_URL = "https://dapi.kakao.com/"


val networkModule = module {

    single<KAKAOLocalApi> {
        get<Retrofit> { parametersOf(KAKAO_URL) }
            .create(KAKAOLocalApi::class.java)
    }

    factory<Retrofit> { (url: String) ->
        Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(get())
            .build()
    }
    single<Converter.Factory> { GsonConverterFactory.create() }

}