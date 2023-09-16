package com.fredericho.home.tab.foryou

import androidx.lifecycle.viewModelScope
import com.fredericho.core.base.BaseViewModel
import com.fredericho.domain.foryou.GetForYouPageFeedUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ForYouViewModel @Inject constructor(
    private val getForYouPageFeedUseCase: GetForYouPageFeedUseCase
) : BaseViewModel<ViewState, ForYouEvent>() {
    init {
        getForYouPageFeeds()
    }

    override fun onTriggerEvent(event: ForYouEvent) {}

    private fun getForYouPageFeeds() {
        viewModelScope.launch {
            getForYouPageFeedUseCase().collect {
                updateState(ViewState(forYouPageFeed = it))
            }
        }
    }


}