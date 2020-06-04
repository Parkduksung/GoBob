package com.work.gobob.network.model.kakao.address

import com.google.gson.annotations.SerializedName

data class KAKAOAddressResponse(
    @SerializedName("documents")
    val documents: List<KAKAOAddressDocument>,
    @SerializedName("meta")
    val meta: KAKAOAddressMeta
)