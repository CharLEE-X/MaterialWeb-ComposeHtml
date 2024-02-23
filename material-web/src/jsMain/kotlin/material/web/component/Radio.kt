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
fun Radio(
    attrs: AttrBuilderContext<MdElement>?,
    value: String? = null,
    checked: Boolean = false,
    name: String? = null,
    disabled: Boolean = false,
    onChange: (SyntheticEvent<EventTarget>) -> Unit = {},
    content: ContentBuilder<MdElement>? = null,
) {
    val tag = "radio"
    MdTagElement(
        tagName = "md-$tag",
        applyAttrs = Modifier.toAttrs {
            attrs?.invoke(this)
            value?.let { attr("value", it) }
            if (checked) attr("checked", "")
            name?.let { attr("name", it) }
            if (disabled) attr("disabled", "")
            addEventListener("change") {
                onChange(it)
            }
        },
        content = content
    ).also { jsRequire("@material/web/radio/$tag.js") }
}
