package com.work.gobob.network.model.kakao.category
import com.google.gson.annotations.SerializedName

data class KAKAOSearchCategoryMeta(
    @SerializedName("is_end")
    val isEnd: Boolean,
    @SerializedName("pageable_count")
    val pageableCount: Int,
    @SerializedName("same_name")
    val sameName: Any,
    @SerializedName("total_count")
    val totalCount: Int
)