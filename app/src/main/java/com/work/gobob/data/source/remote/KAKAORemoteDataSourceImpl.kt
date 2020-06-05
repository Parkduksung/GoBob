package com.work.gobob.data.source.remote

import com.work.gobob.network.api.KAKAOLocalApi
import com.work.gobob.network.model.kakao.address.KAKAOAddressResponse
import com.work.gobob.network.model.kakao.category.KAKAOSearchCategoryResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class KAKAORemoteDataSourceImpl(
    private val kakaoLocalApi: KAKAOLocalApi
) : KAKAORemoteDataSource {

    override fun getCategoryList(
        category: String,
        x: Double,
        y: Double,
        sort: String,
        radius: Int,
        onSuccess: (kakaoSearchCategoryResponse: KAKAOSearchCategoryResponse) -> Unit,
        onFailure: () -> Unit
    ) {
        kakaoLocalApi.getSearchForCategory(category, x, y, sort, radius).enqueue(object :
            Callback<KAKAOSearchCategoryResponse> {

            override fun onResponse(
                call: Call<KAKAOSearchCategoryResponse>,
                response: Response<KAKAOSearchCategoryResponse>
            ) {
                response.body()?.let(onSuccess)
            }

            override fun onFailure(call: Call<KAKAOSearchCategoryResponse>, t: Throwable) {
                onFailure()
            }
        })

    }

    override fun getAddress(
        x: Double,
        y: Double,
        onSuccess: (kakaoAddressResponse: KAKAOAddressResponse) -> Unit,
        onFailure: () -> Unit
    ) {

        kakaoLocalApi.getSearchForAddress(x, y).enqueue(object : Callback<KAKAOAddressResponse> {
            override fun onResponse(
                call: Call<KAKAOAddressResponse>,
                response: Response<KAKAOAddressResponse>
            ) {
                response.body()?.let(onSuccess)
            }

            override fun onFailure(call: Call<KAKAOAddressResponse>, t: Throwable) {
                onFailure()
            }
        })


    }
}