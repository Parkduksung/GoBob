package com.work.gobob.data.source.remote

import com.work.gobob.network.model.kakao.address.KAKAOAddressResponse
import com.work.gobob.network.model.kakao.category.KAKAOSearchCategoryResponse

interface KAKAORemoteDataSource {

    fun getCategoryList(
        category: String,
        x: Double, y: Double,
        sort: String,
        radius: Int,
        onSuccess: (kakaoSearchCategoryResponse: KAKAOSearchCategoryResponse) -> Unit,
        onFailure: () -> Unit
    )

    fun getAddress(
        x: Double, y: Double,
        onSuccess: (kakaoAddressResponse: KAKAOAddressResponse) -> Unit,
        onFailure: () -> Unit
    )

}