package com.fredericho.loginwithemailphone

import androidx.annotation.StringRes

data class ViewState(
    val isLoading : Boolean? = null,
    val error : String? = null,
)

sealed class LoginEmailPhoneEvent {
    data class EventPageChange(val settledPage :Int) : LoginEmailPhoneEvent()
    data class OnChangePhoneNumber(val newValue : String) : LoginEmailPhoneEvent()
    data class OnChangeEmailEntry(val newValue: String) : LoginEmailPhoneEvent()
}

enum class LoginPages(@StringRes val title : Int) {
    PHONE(title = com.fredericho.theme.R.string.phone),
    EMAIL_USERNAME(title = com.fredericho.theme.R.string.email_username)
}

val suggestedDomainList = arrayListOf(
    "@gmail.com", "@hotmail.com", "@outlook.com", "@yahoo.com", "@icloud.com"
)