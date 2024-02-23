package material.web.component

import androidx.compose.runtime.Composable
import androidx.compose.web.events.SyntheticMouseEvent
import com.varabyte.kobweb.compose.css.CSSLengthOrPercentageNumericValue
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.foundation.layout.RowScope
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.compose.ui.toAttrs
import material.web.common.MdElement
import material.web.common.MdTagElement
import material.web.common.jsRequire
import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.AttrBuilderContext

@Suppress("UnsafeCastFromDynamic")
@Composable
private fun BaseButton(
    attrs: AttrBuilderContext<MdElement>?,
    name: String,
    onClick: (SyntheticMouseEvent) -> Unit,
    leadingIcon: @Composable (() -> Unit)?,
    trailingIcon: @Composable (() -> Unit)?,
    disabled: Boolean,
    content: @Composable RowScope.() -> Unit,
) {
    MdTagElement(
        tagName = "md-$name-button",
        applyAttrs = Modifier
            .onClick { evt ->
                onClick(evt)
                evt.stopPropagation()
            }
            .toAttrs {
                attrs?.invoke(this)
                classes("md-button")
                trailingIcon?.let { attr("hasIcon", "") }
                if (disabled) attr("disabled", "")
            },
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            leadingIcon?.let {
                it()
                Box(Modifier.size(8.px))
            }
            content()
            trailingIcon?.let {
                Box(Modifier.size(8.px))
                it()
            }
        }
    }.also { jsRequire("@material/web/button/$name-button.js") }
}

@Composable
fun ElevatedButton(
    attrs: AttrBuilderContext<MdElement>? = null,
    onClick: (SyntheticMouseEvent) -> Unit,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    disabled: Boolean = false,
    containerColor: CSSColorValue? = null,
    labelTextColor: CSSColorValue? = null,
    containerShape: CSSLengthOrPercentageNumericValue? = null,
    labelTextFont: String? = null,
    content: @Composable RowScope.() -> Unit,
) {
    val tag = "elevated"
    BaseButton(
        name = tag,
        onClick = onClick,
        disabled = disabled,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        attrs = Modifier
            .styleModifier {
                containerColor?.let { property("--md-$tag-button-container-color", it.toString()) }
                labelTextColor?.let { property("--md-$tag-button-label-text-color", it.toString()) }
                containerShape?.let { property("--md-$tag-button-container-shape", it.toString()) }
                labelTextFont?.let { property("--md-$tag-button-label-text-font", it) }
            }.toAttrs { attrs?.invoke(this) },
        content = content
    )
}

@Composable
fun FilledButton(
    attrs: AttrBuilderContext<MdElement>? = null,
    onClick: (SyntheticMouseEvent) -> Unit,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    disabled: Boolean = false,
    containerColor: CSSColorValue? = null,
    disabledContainerColor: CSSColorValue? = null,
    labelTextColor: CSSColorValue? = null,
    containerShape: CSSLengthOrPercentageNumericValue? = null,
    labelTextFont: String? = null,
    content: @Composable RowScope.() -> Unit,
) {
    val tag = "filled"
    BaseButton(
        name = tag,
        onClick = onClick,
        disabled = disabled,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        attrs = Modifier.styleModifier {
            containerColor?.let { property("--md-$tag-button-container-color", it.toString()) }
            disabledContainerColor?.let { property("--md-$tag-button-disabled-container-color", it.toString()) }
            labelTextColor?.let { property("--md-$tag-button-label-text-color", it.toString()) }
            containerShape?.let { property("--md-$tag-button-container-shape", it.toString()) }
            labelTextFont?.let { property("--md-$tag-button-label-text-font", it) }
        }.toAttrs { attrs?.invoke(this) },
        content = content
    )
}

@Composable
fun OutlinedButton(
    attrs: AttrBuilderContext<MdElement>? = null,
    onClick: (SyntheticMouseEvent) -> Unit,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    disabled: Boolean = false,
    containerColor: CSSColorValue? = null,
    labelTextColor: CSSColorValue? = null,
    containerShape: CSSLengthOrPercentageNumericValue? = null,
    labelTextFont: String? = null,
    content: @Composable RowScope.() -> Unit,
) {
    val tag = "outlined"
    BaseButton(
        name = tag,
        onClick = onClick,
        disabled = disabled,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        attrs = Modifier.styleModifier {
            containerColor?.let { property("--md-$tag-button-outline-color", it.toString()) }
            labelTextColor?.let { property("--md-$tag-button-label-text-color", it.toString()) }
            containerShape?.let { property("--md-$tag-button-container-shape", it.toString()) }
            labelTextFont?.let { property("--md-$tag-button-label-text-font", it) }
        }.toAttrs { attrs?.invoke(this) },
        content = content
    )
}

@Composable
fun FilledTonalButton(
    attrs: AttrBuilderContext<MdElement>? = null,
    onClick: (SyntheticMouseEvent) -> Unit,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    disabled: Boolean = false,
    containerColor: CSSColorValue? = null,
    labelTextColor: CSSColorValue? = null,
    containerShape: CSSLengthOrPercentageNumericValue? = null,
    labelTextFont: String? = null,
    content: @Composable RowScope.() -> Unit,
) {
    val tag = "filled-tonal"
    BaseButton(
        name = tag,
        onClick = onClick,
        disabled = disabled,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        attrs = Modifier.styleModifier {
            containerColor?.let { property("--md-$tag-button-outline-color", it.toString()) }
            labelTextColor?.let { property("--md-$tag-button-label-text-color", it.toString()) }
            containerShape?.let { property("--md-$tag-button-container-shape", it.toString()) }
            labelTextFont?.let { property("--md-$tag-button-label-text-font", it) }
        }.toAttrs { attrs?.invoke(this) },
        content = content
    )
}

@Composable
fun TextButton(
    attrs: AttrBuilderContext<MdElement>? = null,
    onClick: (SyntheticMouseEvent) -> Unit,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    disabled: Boolean = false,
    labelTextColor: CSSColorValue? = null,
    labelTextFont: String? = null,
    content: @Composable RowScope.() -> Unit,
) {
    val tag = "text"
    BaseButton(
        name = "text",
        onClick = onClick,
        disabled = disabled,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        attrs = Modifier.styleModifier {
            labelTextColor?.let { property("--md-$tag-button-label-text-color", it.toString()) }
            labelTextFont?.let { property("--md-$tag-button-label-text-font", it) }
        }.toAttrs { attrs?.invoke(this) },
        content = content
    )
}
