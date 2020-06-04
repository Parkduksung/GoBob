package com.work.gobob.data.repository.kakao

import com.work.gobob.data.source.remote.KAKAORemoteDataSource

class KAKAORepositoryImpl(
    private val kakaoRepository: KAKAORemoteDataSource
) : KAKAORepository {
}