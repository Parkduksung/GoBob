package com.work.gobob.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.work.gobob.App
import com.work.gobob.data.repository.kakao.KAKAORepository
import com.work.gobob.network.model.kakao.category.KAKAOSearchCategoryDocument

class SearchViewModel(
    private val kakaoRepository: KAKAORepository
) : ViewModel() {

    private val prefLongitude = App.prefs.longitude.toDouble()
    private val prefLatitude = App.prefs.latitude.toDouble()

    private val _searchList = MutableLiveData<List<KAKAOSearchCategoryDocument>>()
    val searchList: LiveData<List<KAKAOSearchCategoryDocument>>
        get() = _searchList

    private val _address = MutableLiveData<String>()
    val address: LiveData<String>
        get() = _address

    private val _roadAddress = MutableLiveData<String>()
    val roadAddress: LiveData<String>
        get() = _roadAddress

    fun getSearchList() {
        kakaoRepository.getCategoryList(
            CATEGORY_FOOD,
            prefLongitude,
            prefLatitude,
            "distance",
            SEARCH_RADIUS,
            onSuccess = {
                _searchList.value = it.documents
            },
            onFailure = {}
        )
    }

    fun getAddress() {
        kakaoRepository.getAddress(
            prefLongitude,
            prefLatitude,
            onSuccess = {
                _roadAddress.value = it.documents[0].roadAddress.addressName
                _address.value = it.documents[0].address.addressName
            },
            onFailure = {}
        )
    }

    companion object {

        private const val CATEGORY_FOOD = "FD6"
        private const val SEARCH_RADIUS = 2000
    }

}