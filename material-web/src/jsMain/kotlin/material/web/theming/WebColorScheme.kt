package material.web.theming

import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.StyleSheet
import org.jetbrains.compose.web.css.backgroundColor
import org.jetbrains.compose.web.css.color
import org.jetbrains.compose.web.css.value

data class WebColorScheme(
    val primary: CSSColorValue,
    val primaryContainer: CSSColorValue,
    val onPrimary: CSSColorValue,
    val onPrimaryContainer: CSSColorValue,
    val secondary: CSSColorValue,
    val secondaryContainer: CSSColorValue,
    val onSecondary: CSSColorValue,
    val onSecondaryContainer: CSSColorValue,
    val tertiary: CSSColorValue,
    val tertiaryContainer: CSSColorValue,
    val onTertiary: CSSColorValue,
    val onTertiaryContainer: CSSColorValue,
    val error: CSSColorValue,
    val errorContainer: CSSColorValue,
    val onError: CSSColorValue,
    val onErrorContainer: CSSColorValue,
    val outline: CSSColorValue,
    val background: CSSColorValue,
    val onBackground: CSSColorValue,
    val surface: CSSColorValue,
    val onSurface: CSSColorValue,
    val surfaceDim: CSSColorValue,
    val surfaceBright: CSSColorValue,
    val surfaceContainerLowest: CSSColorValue,
    val surfaceContainerLow: CSSColorValue,
    val surfaceContainer: CSSColorValue,
    val surfaceContainerHigh: CSSColorValue,
    val surfaceContainerHighest: CSSColorValue,
    val surfaceVariant: CSSColorValue,
    val onSurfaceVariant: CSSColorValue,
    val inverseSurface: CSSColorValue,
    val inverseOnSurface: CSSColorValue,
    val inversePrimary: CSSColorValue,
    val shadow: CSSColorValue,
    val surfaceTint: CSSColorValue,
    val outlineVariant: CSSColorValue,
    val scrim: CSSColorValue
) {
    fun asStylesheet(): StyleSheet = StyleSheet().apply {
        root style {
            backgroundColor(MaterialTheme.colors.surfaceContainerLowest.value())
            color(MaterialTheme.colors.onBackground.value())
        }

        universal style {
            MaterialTheme.colors.primary(this@WebColorScheme.primary)
            MaterialTheme.colors.primaryContainer(this@WebColorScheme.primaryContainer)
            MaterialTheme.colors.onPrimary(this@WebColorScheme.primary)
            MaterialTheme.colors.onPrimaryContainer(this@WebColorScheme.onPrimaryContainer)
            MaterialTheme.colors.secondary(this@WebColorScheme.secondary)
            MaterialTheme.colors.secondaryContainer(this@WebColorScheme.secondaryContainer)
            MaterialTheme.colors.onSecondary(this@WebColorScheme.secondary)
            MaterialTheme.colors.onSecondaryContainer(this@WebColorScheme.onSecondaryContainer)
            MaterialTheme.colors.tertiary(this@WebColorScheme.tertiary)
            MaterialTheme.colors.tertiaryContainer(this@WebColorScheme.tertiaryContainer)
            MaterialTheme.colors.onTertiary(this@WebColorScheme.tertiary)
            MaterialTheme.colors.onTertiaryContainer(this@WebColorScheme.onTertiaryContainer)
            MaterialTheme.colors.error(this@WebColorScheme.error)
            MaterialTheme.colors.errorContainer(this@WebColorScheme.errorContainer)
            MaterialTheme.colors.onError(this@WebColorScheme.onError)
            MaterialTheme.colors.onErrorContainer(this@WebColorScheme.onErrorContainer)
            MaterialTheme.colors.outline(this@WebColorScheme.outline)
            MaterialTheme.colors.background(this@WebColorScheme.background)
            MaterialTheme.colors.onBackground(this@WebColorScheme.onBackground)
            MaterialTheme.colors.surface(this@WebColorScheme.surface)
            MaterialTheme.colors.onSurface(this@WebColorScheme.onSurface)
            MaterialTheme.colors.surfaceDim(this@WebColorScheme.surfaceDim)
            MaterialTheme.colors.surfaceBright(this@WebColorScheme.surfaceBright)
            MaterialTheme.colors.surfaceContainerLowest(this@WebColorScheme.surfaceContainerLowest)
            MaterialTheme.colors.surfaceContainerLow(this@WebColorScheme.surfaceContainerLow)
            MaterialTheme.colors.surfaceContainer(this@WebColorScheme.surfaceContainer)
            MaterialTheme.colors.surfaceContainerHigh(this@WebColorScheme.surfaceContainerHigh)
            MaterialTheme.colors.surfaceContainerHighest(this@WebColorScheme.surfaceContainerHighest)
            MaterialTheme.colors.surfaceVariant(this@WebColorScheme.surfaceVariant)
            MaterialTheme.colors.onSurfaceVariant(this@WebColorScheme.onSurfaceVariant)
            MaterialTheme.colors.inverseSurface(this@WebColorScheme.inverseSurface)
            MaterialTheme.colors.inverseOnSurface(this@WebColorScheme.inverseOnSurface)
            MaterialTheme.colors.inversePrimary(this@WebColorScheme.inversePrimary)
            MaterialTheme.colors.shadow(this@WebColorScheme.shadow)
            MaterialTheme.colors.surfaceTint(this@WebColorScheme.surfaceTint)
            MaterialTheme.colors.outlineVariant(this@WebColorScheme.outlineVariant)
            MaterialTheme.colors.scrim(this@WebColorScheme.scrim)
        }
    }
}
