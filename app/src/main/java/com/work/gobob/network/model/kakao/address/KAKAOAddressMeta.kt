package com.work.gobob.network.model.kakao.address

import com.google.gson.annotations.SerializedName

data class KAKAOAddressMeta(
    @SerializedName("total_count")
    val totalCount: Int
)