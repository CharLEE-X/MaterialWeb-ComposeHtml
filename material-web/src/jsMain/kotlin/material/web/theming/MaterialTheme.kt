package material.web.theming

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.CSSStyleVariable
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.Style
import org.jetbrains.compose.web.css.StyleSheet
import org.jetbrains.compose.web.css.backgroundColor
import org.jetbrains.compose.web.css.value

@Composable
fun MaterialTheme(
    colorScheme: WebColorScheme? = null,
    fontScheme: WebFontScheme? = null,
    content: @Composable () -> Unit,
) {
    if (colorScheme != null) {
        Style(colorScheme.asStylesheet())
    } else {
        Style(DefaultBackground)
    }
    if (fontScheme != null) {
        Style(fontScheme.asStyleSheet())
    }

    content()
}

private object DefaultBackground : StyleSheet() {
    init {
        root style {
            backgroundColor(MaterialTheme.colors.surfaceContainerLowest.value(Color("#FFFFFF")))
        }
    }
}

object MaterialTheme {
    @Suppress("ClassName")
    object colors {
        val primary = CSSStyleVariable<CSSColorValue>("md-sys-color-primary")
        val primaryContainer = CSSStyleVariable<CSSColorValue>("md-sys-color-primary-container")
        val onPrimary = CSSStyleVariable<CSSColorValue>("md-sys-color-on-primary")
        val onPrimaryContainer = CSSStyleVariable<CSSColorValue>("md-sys-color-on-primary-container")
        val secondary = CSSStyleVariable<CSSColorValue>("md-sys-color-secondary")
        val secondaryContainer = CSSStyleVariable<CSSColorValue>("md-sys-color-secondary-container")
        val onSecondary = CSSStyleVariable<CSSColorValue>("md-sys-color-on-secondary")
        val onSecondaryContainer = CSSStyleVariable<CSSColorValue>("md-sys-color-on-secondary-container")
        val tertiary = CSSStyleVariable<CSSColorValue>("md-sys-color-tertiary")
        val tertiaryContainer = CSSStyleVariable<CSSColorValue>("md-sys-color-tertiary-container")
        val onTertiary = CSSStyleVariable<CSSColorValue>("md-sys-color-on-tertiary")
        val onTertiaryContainer = CSSStyleVariable<CSSColorValue>("md-sys-color-on-tertiary-container")
        val error = CSSStyleVariable<CSSColorValue>("md-sys-color-error")
        val errorContainer = CSSStyleVariable<CSSColorValue>("md-sys-color-error-container")
        val onError = CSSStyleVariable<CSSColorValue>("md-sys-color-on-error")
        val onErrorContainer = CSSStyleVariable<CSSColorValue>("md-sys-color-on-error-container")
        val outline = CSSStyleVariable<CSSColorValue>("md-sys-color-outline")
        val background = CSSStyleVariable<CSSColorValue>("md-sys-color-background")
        val onBackground = CSSStyleVariable<CSSColorValue>("md-sys-color-on-background")
        val surface = CSSStyleVariable<CSSColorValue>("md-sys-color-surface")
        val onSurface = CSSStyleVariable<CSSColorValue>("md-sys-color-on-surface")
        val surfaceDim = CSSStyleVariable<CSSColorValue>("md-sys-color-surface-dim")
        val surfaceBright = CSSStyleVariable<CSSColorValue>("md-sys-color-surface-bright")
        val surfaceContainerLowest = CSSStyleVariable<CSSColorValue>("md-sys-color-surface-container-lowest")
        val surfaceContainerLow = CSSStyleVariable<CSSColorValue>("md-sys-color-surface-container-low")
        val surfaceContainer = CSSStyleVariable<CSSColorValue>("md-sys-color-surface-container")
        val surfaceContainerHigh = CSSStyleVariable<CSSColorValue>("md-sys-color-surface-container-high")
        val surfaceContainerHighest = CSSStyleVariable<CSSColorValue>("md-sys-color-surface-container-highest")
        val surfaceVariant = CSSStyleVariable<CSSColorValue>("md-sys-color-surface-variant")
        val onSurfaceVariant = CSSStyleVariable<CSSColorValue>("md-sys-color-on-surface-variant")
        val inverseSurface = CSSStyleVariable<CSSColorValue>("md-sys-color-inverse-surface")
        val inverseOnSurface = CSSStyleVariable<CSSColorValue>("md-sys-color-inverse-on-surface")
        val inversePrimary = CSSStyleVariable<CSSColorValue>("md-sys-color-inverse-primary")
        val shadow = CSSStyleVariable<CSSColorValue>("md-sys-color-shadow")
        val surfaceTint = CSSStyleVariable<CSSColorValue>("md-sys-color-surface-tint")
        val outlineVariant = CSSStyleVariable<CSSColorValue>("md-sys-color-outline-variant")
        val scrim = CSSStyleVariable<CSSColorValue>("md-sys-color-scrim")
    }

    @Suppress("ClassName")
    object typography : TypeScaleTokens("md-sys-typescale") {
        object displayLarge : Role("display-large")
        object displayMedium : Role("display-medium")
        object displaySmall : Role("display-small")
        object headlineLarge : Role("headline-large")
        object headlineMedium : Role("headline-medium")
        object headlineSmall : Role("headline-small")
        object titleLarge : Role("title-large")
        object titleMedium : Role("title-medium")
        object titleSmall : Role("title-small")
        object bodyLarge : Role("body-large")
        object bodyMedium : Role("body-medium")
        object bodySmall : Role("body-small")
        object labelLarge : Role("label-large")
        object labelMedium : Role("label-medium")
        object labelSmall : Role("label-small")
    }
}
