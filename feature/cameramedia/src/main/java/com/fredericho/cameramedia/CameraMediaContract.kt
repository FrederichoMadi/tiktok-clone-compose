package com.fredericho.cameramedia

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.fredericho.theme.R
import com.fredericho.data.model.TemplateModel

data class ViewState(
    val templates : List<TemplateModel>? = null
)

sealed class CameraMediaEvent {
    object EventFetchTemplate : CameraMediaEvent()
}

enum class Tabs(@StringRes val rawValue: Int) {
    CAMERA(R.string.camera),
    STORY(R.string.story),
    TEMPLATES(R.string.templates)
}

enum class PermissionType {
    CAMERA,
    MICROPHONE
}

enum class CameraController(
    @StringRes val title : Int,
    @DrawableRes val icon : Int,
) {
    FLIP(title = R.string.flip, icon = R.drawable.ic_flip),
    SPEED(title = R.string.speed, icon = R.drawable.ic_speed),
    BEAUTY(title = R.string.beauty, icon = R.drawable.ic_profile_fill),
    FILTER(title = R.string.filters, icon = R.drawable.ic_filter),
    MIRROR(title = R.string.mirror, icon = R.drawable.ic_mirror),
    TIMER(title = R.string.timer, icon = R.drawable.ic_timer),
    FLASH(title = R.string.flash, icon = R.drawable.ic_flash),
}

enum class CameraCaptureOptions(val value: String) {
    SIXTY_SECOND("60s"),
    FIFTEEN_SECOND("15s"),
    PHOTO("Photo"),
    VIDEO("Video"),
    TEXT("Text"),
}