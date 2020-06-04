package com.work.gobob.network.model.kakao.category

import com.google.gson.annotations.SerializedName
import com.work.gobob.network.model.kakao.category.KAKAOSearchCategoryDocument
import com.work.gobob.network.model.kakao.category.KAKAOSearchCategoryMeta

data class KAKAOSearchCategoryResponse(
    @SerializedName("documents")
    val documents: List<KAKAOSearchCategoryDocument>,
    @SerializedName("meta")
    val meta: KAKAOSearchCategoryMeta
)