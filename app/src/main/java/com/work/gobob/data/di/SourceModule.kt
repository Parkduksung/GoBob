package com.work.gobob.data.di

import com.work.gobob.data.source.remote.KAKAORemoteDataSource
import com.work.gobob.data.source.remote.KAKAORemoteDataSourceImpl
import org.koin.dsl.module

val sourceModule = module {
    single<KAKAORemoteDataSource> { KAKAORemoteDataSourceImpl(get()) }
}