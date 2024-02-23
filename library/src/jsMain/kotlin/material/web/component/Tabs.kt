package material.web.component

import androidx.compose.runtime.Composable
import androidx.compose.web.events.SyntheticEvent
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.toAttrs
import material.web.common.MdElement
import material.web.common.MdTagElement
import material.web.common.jsRequire
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.w3c.dom.events.EventTarget

@Suppress("UnsafeCastFromDynamic")
@Composable
fun Tabs(
    attrs: AttrBuilderContext<MdElement>?,
    activeTabIndex: Int,
    selectOnFocus: Boolean = true,
    onChange: (SyntheticEvent<EventTarget>) -> Unit = {},
    content: ContentBuilder<MdElement>? = null,
) {
    val tag = "tabs"
    MdTagElement(
        tagName = "md-$tag",
        applyAttrs = Modifier.toAttrs {
            attrs?.invoke(this)
            attr("activeTabIndex", activeTabIndex.toString())
            if (selectOnFocus) attr("selectOnFocus", "")
            addEventListener("change") {
                onChange(it)
            }
        },
        content = content
    ).also { jsRequire("@material/web/tabs/$tag.js") }
}

@Suppress("UnsafeCastFromDynamic")
@Composable
fun PrimaryTab(
    attrs: AttrBuilderContext<MdElement>?,
    disabled: Boolean = false,
    active: Boolean = false,
    focusable: Boolean = true,
    inlineIcon: Boolean = false,
    content: ContentBuilder<MdElement>? = null,
) {
    val tag = "primary-tab"
    MdTagElement(
        tagName = "md-$tag",
        applyAttrs = Modifier.toAttrs {
            attrs?.invoke(this)
            if (disabled) attr("disabled", "")
            if (active) attr("active", "")
            if (focusable) attr("focusable", "")
            if (inlineIcon) attr("inlineIcon", "")
        },
        content = content
    ).also { jsRequire("@material/web/tabs/$tag.js") }
}

@Suppress("UnsafeCastFromDynamic")
@Composable
fun SecondaryTab(
    attrs: AttrBuilderContext<MdElement>?,
    disabled: Boolean = false,
    active: Boolean = false,
    focusable: Boolean = true,
    inlineIcon: Boolean = false,
    content: ContentBuilder<MdElement>? = null,
) {
    val tag = "secondary-tab"
    MdTagElement(
        tagName = "md-$tag",
        applyAttrs = Modifier.toAttrs {
            attrs?.invoke(this)
            if (disabled) attr("disabled", "")
            if (active) attr("active", "")
            if (focusable) attr("focusable", "")
            if (inlineIcon) attr("inlineIcon", "")
        },
        content = content
    ).also { jsRequire("@material/web/tabs/$tag.js") }
}

