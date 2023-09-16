package com.fredericho.loginwithemailphone

import com.fredericho.core.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class LoginWithEmailPhoneViewModel @Inject constructor() : BaseViewModel<ViewState, LoginEmailPhoneEvent>() {
    private val _settledPage = MutableStateFlow<Int?>(null)
    val settledPage = _settledPage.asStateFlow()

    private val _phoneNumber = MutableStateFlow<Pair<String, String?>>(Pair("", null))
    val phoneNumber = _phoneNumber.asStateFlow()

    private val _dialCode = MutableStateFlow<Pair<String, String?>>(Pair("Np +62", null))
    val dialCode = _dialCode.asStateFlow()

    private val _email = MutableStateFlow<Pair<String, String?>>(Pair("", null))
    val email = _email.asStateFlow()

    override fun onTriggerEvent(event: LoginEmailPhoneEvent) {
        when(event) {
            is LoginEmailPhoneEvent.EventPageChange -> _settledPage.value = event.settledPage
            is LoginEmailPhoneEvent.OnChangeEmailEntry -> _email.value = _email.value.copy(first = event.newValue)
            is LoginEmailPhoneEvent.OnChangePhoneNumber -> _phoneNumber.value = _phoneNumber.value.copy(first = event.newValue)
        }
    }
}