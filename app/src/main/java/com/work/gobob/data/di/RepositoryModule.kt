package com.work.gobob.data.di

import com.work.gobob.data.repository.kakao.KAKAORepository
import com.work.gobob.data.repository.kakao.KAKAORepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<KAKAORepository> { KAKAORepositoryImpl(get()) }
}