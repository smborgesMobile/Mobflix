package br.com.mobflix.ui.dimens

import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

class Dimens(
    /** 0dp */
    val none: Dp = 0.dp,
    /** 4dp */
    val verySmall: Dp = 4.dp,
    /** 8dp */
    val small: Dp = 8.dp,
    /** 16dp */
    val medium: Dp = 16.dp,
    /** 24dp */
    val large: Dp = 24.dp,
    /** 36dp */
    val veryLarge: Dp = 36.dp
)

val MaterialTheme.dimens: Dimens
    get() = Dimens()