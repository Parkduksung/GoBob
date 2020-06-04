package com.work.gobob.network.model.kakao.address

import com.google.gson.annotations.SerializedName

data class KAKAOAddressDocument(
    @SerializedName("address")
    val address: Address,
    @SerializedName("road_address")
    val roadAddress: RoadAddress
)