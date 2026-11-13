package com.example.planazum.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

private val LightColors = lightColorScheme(
    primary = PlanazumPink,
    onPrimary = Color.White,
    secondary = PlanazumYellow,
    onSecondary = OnAccent,
    tertiary = PlanazumBlue,
    onTertiary = OnAccent,
    background = LightBackground,
    onBackground = LightText,
    surface = LightSurface,
    onSurface = LightText,
    outline = PlanazumPink
)

private val DarkColors = darkColorScheme(
    primary = PlanazumPink,
    onPrimary = Color.White,
    secondary = PlanazumYellow,
    onSecondary = OnAccent,
    tertiary = PlanazumBlue,
    onTertiary = OnAccent,
    background = DarkBackground,
    onBackground = DarkText,
    surface = DarkSurface,
    onSurface = DarkText,
    outline = PlanazumPink
)

@Immutable
data class PlanazumExtraColors(
    val cards: List<Color>,
    val onCard: Color
)

private val LocalExtraColors = staticCompositionLocalOf {
    PlanazumExtraColors(cards = CardColors, onCard = OnAccent)
}

object PlanazumExtras {
    val colors: PlanazumExtraColors
        @Composable get() = LocalExtraColors.current
}

@Composable
fun PlanazumTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalExtraColors provides PlanazumExtraColors(cards = CardColors, onCard = OnAccent)
    ) {
        MaterialTheme(
            colorScheme = if (darkTheme) DarkColors else LightColors,
            content = content
        )
    }
}