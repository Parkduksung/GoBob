package com.work.gobob.network.api

import com.work.gobob.network.model.kakao.address.KAKAOAddressResponse
import com.work.gobob.network.model.kakao.category.KAKAOSearchCategoryResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface KAKAOLocalApi {
    //x - longitude , y - latitude
    @Headers(HEADERS)
    @GET("v2/local/search/category.json")
    fun getSearchForCategory(
        @Query("category_group_code") code: String,
        @Query("x") x: Double,
        @Query("y") y: Double,
        @Query("sort") sort: String,
        @Query("radius") radius: Int
    ): Call<KAKAOSearchCategoryResponse>

    @Headers(HEADERS)
    @GET("v2/local/geo/coord2address.json")
    fun getSearchForAddress(
        @Query("x") x: Double,
        @Query("y") y: Double
    ): Call<KAKAOAddressResponse>

    companion object {
        private const val HEADERS = "Authorization: KakaoAK 6e58468cb976a594559d01e8a0fb6665"
    }


}