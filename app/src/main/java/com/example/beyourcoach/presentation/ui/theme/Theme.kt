package com.example.beyourcoach.presentation.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import com.example.beyourcoach.domain.model.UserMode

private val LiteColorScheme = lightColorScheme(
    primary = LitePrimary,
    onPrimary = LiteOnPrimary,
    secondary = LiteSecondary,
    background = LiteBackground,
    surface = LiteSurface
)

private val ProColorScheme = darkColorScheme(
    primary = ProPrimary,
    onPrimary = ProOnPrimary,
    secondary = ProSecondary,
    background = ProBackground,
    surface = ProSurface,
    onBackground = ProOnBackground,
    onSurface = ProOnSurface
)

@Composable
fun BeYourCoachTheme(
    mode: UserMode = UserMode.LITE,
    content: @Composable () -> Unit
) {
    val colorScheme = when (mode) {
        UserMode.LITE -> LiteColorScheme
        UserMode.PRO -> ProColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
