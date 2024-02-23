package material.web.component

import androidx.compose.runtime.Composable
import androidx.compose.web.events.SyntheticMouseEvent
import com.varabyte.kobweb.compose.css.CSSLengthOrPercentageNumericValue
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
fun Checkbox(
    attrs: AttrBuilderContext<MdElement>? = null,
    value: Boolean? = null,
    onClick: (SyntheticMouseEvent) -> Unit = {},
    checked: Boolean = false,
    indeterminate: Boolean = false,
    disabled: Boolean = false,
    shape: CSSLengthOrPercentageNumericValue? = null,
    containerSize: CSSLengthOrPercentageNumericValue? = null,
    outlineColor: CSSColorValue? = null,
    outlineWidth: CSSLengthOrPercentageNumericValue? = null,
    selectedContainerColor: CSSColorValue? = null,
    content: ContentBuilder<MdElement>? = null,
) {
    val tag = "checkbox"
    MdTagElement(
        tagName = "md-$tag",
        applyAttrs = Modifier
            .onClick { onClick(it) }
            .styleModifier {
                shape?.let { property("--md-$tag-container-shape", it.toString()) }
                containerSize?.let { property("--md-$tag-container-size", it.toString()) }
                outlineColor?.let { property("--md-$tag-outline-color", it.toString()) }
                selectedContainerColor?.let { property("--md-$tag-selected-container-color", it.toString()) }
                outlineWidth?.let { property("--md-$tag-outline-width", it.toString()) }
            }
            .toAttrs {
                attrs?.invoke(this)
                value?.let { attr("value", it.toString()) }
                if (disabled) attr("disabled", "")
                if (checked) attr("checked", "")
                if (indeterminate) attr("indeterminate", "")
            },
        content = content
    ).also { jsRequire("@material/web/checkbox/$tag.js") }
}
