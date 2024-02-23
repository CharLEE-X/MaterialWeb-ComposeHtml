package material.web.component

import androidx.compose.runtime.Composable
import androidx.compose.web.events.SyntheticMouseEvent
import com.varabyte.kobweb.compose.css.CSSLengthOrPercentageNumericValue
import com.varabyte.kobweb.compose.css.CSSPercentageNumericValue
import com.varabyte.kobweb.compose.css.Height
import com.varabyte.kobweb.compose.css.Width
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.compose.ui.toAttrs
import material.web.common.MdElement
import material.web.common.MdTagElement
import material.web.common.jsRequire
import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder

@Suppress("UnsafeCastFromDynamic")
@Composable
private fun BaseIconButton(
    tagName: String,
    attrs: AttrBuilderContext<MdElement>?,
    toggle: Boolean?,
    selected: Boolean?,
    disabled: Boolean?,
    onClick: (SyntheticMouseEvent) -> Unit,
    content: ContentBuilder<MdElement>?,
) {
    MdTagElement(
        tagName = "md-$tagName",
        applyAttrs = Modifier
            .onClick { onClick(it) }
            .toAttrs {
                attrs?.invoke(this)
                toggle?.let { attr("toggle", "") }
                selected?.let { attr("selected", "") }
                disabled?.let { attr("disabled", "") }
            },
        content = content
    ).also { jsRequire("@material/web/iconbutton/$tagName.js") }
}

@Composable
fun IconButton(
    attrs: AttrBuilderContext<MdElement>? = null,
    toggle: Boolean? = null,
    selected: Boolean? = null,
    disabled: Boolean? = null,
    onClick: (SyntheticMouseEvent) -> Unit = {},
    iconColor: CSSColorValue? = null,
    stateLayerShape: String? = null,
    iconSize: CSSColorValue? = null,
    content: ContentBuilder<MdElement>? = null,
) {
    val tag = "icon-button"
    BaseIconButton(
        tagName = tag,
        toggle = toggle,
        selected = selected,
        disabled = disabled,
        onClick = onClick,
        attrs = Modifier.styleModifier {
            iconColor?.let { property("--md-$tag-icon-color", it.toString()) }
            stateLayerShape?.let { property("--md-$tag-state-layer-shape", it) }
            iconSize?.let { property("--md-$tag-icon-size", it.toString()) }
        }.toAttrs(attrs),
        content = content
    )
}

@Composable
fun FilledIconButton(
    attrs: AttrBuilderContext<MdElement>? = null,
    toggle: Boolean? = null,
    selected: Boolean? = null,
    disabled: Boolean? = null,
    onClick: (SyntheticMouseEvent) -> Unit = {},
    selectedContainerColor: CSSColorValue? = null,
    buttonContainerShape: CSSLengthOrPercentageNumericValue? = null,
    buttonContainerWidth: Width? = null,
    buttonContainerHeight: Height? = null,
    iconSize: CSSPercentageNumericValue? = null,
    content: ContentBuilder<MdElement>? = null,
) {
    val tag = "filled-icon-button"
    BaseIconButton(
        tagName = tag,
        toggle = toggle,
        selected = selected,
        disabled = disabled,
        onClick = onClick,
        attrs = Modifier.styleModifier {
            selectedContainerColor?.let { property("--md-$tag-selected-container-color", it.toString()) }
            buttonContainerShape?.let { property("--md-$tag-button-container-shape", it.toString()) }
            buttonContainerWidth?.let { property("--md-$tag-button-container-width", it.toString()) }
            buttonContainerHeight?.let { property("--md-$tag-button-container-height", it.toString()) }
            iconSize?.let { property("--md-$tag-icon-size", it.toString()) }
        }.toAttrs(attrs),
        content = content
    )
}

@Composable
fun OutlinedIconButton(
    attrs: AttrBuilderContext<MdElement>? = null,
    toggle: Boolean? = null,
    selected: Boolean? = null,
    disabled: Boolean? = null,
    onClick: (SyntheticMouseEvent) -> Unit = {},
    outlineColor: CSSColorValue? = null,
    outlineWidth: CSSLengthOrPercentageNumericValue? = null,
    containerShape: CSSLengthOrPercentageNumericValue? = null,
    containerWidth: Width? = null,
    containerHeight: Height? = null,
    iconSize: CSSLengthOrPercentageNumericValue? = null,
    content: ContentBuilder<MdElement>? = null,
) {
    val tag = "outlined-icon-button"
    BaseIconButton(
        tagName = tag,
        toggle = toggle,
        selected = selected,
        disabled = disabled,
        onClick = onClick,
        attrs = Modifier.styleModifier {
            outlineColor?.let { property("--md-$tag-outline-color", it.toString()) }
            outlineWidth?.let { property("--md-$tag-outline-width", it.toString()) }
            containerShape?.let { property("--md-$tag-container-shape", it.toString()) }
            containerWidth?.let { property("--md-$tag-container-width", it.toString()) }
            containerHeight?.let { property("--md-$tag-container-height", it.toString()) }
            iconSize?.let { property("--md-$tag-icon-size", it.toString()) }
        }.toAttrs(attrs),
        content = content
    )
}

@Composable
fun FilledTonalIconButton(
    attrs: AttrBuilderContext<MdElement>? = null,
    toggle: Boolean? = null,
    selected: Boolean? = null,
    disabled: Boolean? = null,
    onClick: (SyntheticMouseEvent) -> Unit = {},
    containerColor: CSSColorValue? = null,
    containerShape: CSSLengthOrPercentageNumericValue? = null,
    containerWidth: Width? = null,
    containerHeight: Height? = null,
    iconSize: CSSLengthOrPercentageNumericValue? = null,
    content: ContentBuilder<MdElement>? = null,
) {
    val tag = "filled-tonal-icon-button"
    BaseIconButton(
        tagName = "filled-tonal-icon-button",
        toggle = toggle,
        selected = selected,
        disabled = disabled,
        onClick = onClick,
        attrs = Modifier.styleModifier {
            containerColor?.let { property("--md-$tag-container-color", it.toString()) }
            containerShape?.let { property("--md-$tag-container-shape", it.toString()) }
            containerWidth?.let { property("--md-$tag-container-width", it.toString()) }
            containerHeight?.let { property("--md-$tag-container-height", it.toString()) }
            iconSize?.let { property("--md-$tag-icon-size", it.toString()) }
        }.toAttrs(attrs),
        content = content
    )
}
