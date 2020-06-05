package com.work.gobob.data.repository.kakao

import com.work.gobob.data.source.remote.KAKAORemoteDataSource
import com.work.gobob.network.model.kakao.address.KAKAOAddressResponse
import com.work.gobob.network.model.kakao.category.KAKAOSearchCategoryResponse

class KAKAORepositoryImpl(
    private val kakaoRemoteDataSource: KAKAORemoteDataSource
) : KAKAORepository {
    override fun getCategoryList(
        category: String,
        x: Double,
        y: Double,
        sort: String,
        radius: Int,
        onSuccess: (kakaoSearchCategoryResponse: KAKAOSearchCategoryResponse) -> Unit,
        onFailure: () -> Unit
    ) {
        kakaoRemoteDataSource.getCategoryList(category, x, y, sort, radius, onSuccess, onFailure)
    }

    override fun getAddress(
        x: Double,
        y: Double,
        onSuccess: (kakaoAddressResponse: KAKAOAddressResponse) -> Unit,
        onFailure: () -> Unit
    ) {
        kakaoRemoteDataSource.getAddress(x, y, onSuccess, onFailure)
    }
}