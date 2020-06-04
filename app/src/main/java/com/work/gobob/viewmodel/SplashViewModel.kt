package com.work.gobob.viewmodel

import androidx.lifecycle.ViewModel
import com.work.gobob.data.repository.kakao.KAKAORepository

class SplashViewModel(
    private val kakaoRepository: KAKAORepository
) : ViewModel() {
}