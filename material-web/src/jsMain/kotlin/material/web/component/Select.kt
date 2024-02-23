package material.web.component

import androidx.compose.runtime.Composable
import androidx.compose.web.events.SyntheticEvent
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.toAttrs
import material.web.common.MdElement
import material.web.common.MdTagElement
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.w3c.dom.events.EventTarget

@Composable
fun MdSelectTagElement(
    attrs: AttrBuilderContext<MdElement>?,
    tagName: String,
    label: String,
    supportingText: String? = null,
    errorText: String? = null,
    required: Boolean? = null,
    onChange: (SyntheticEvent<EventTarget>) -> Unit = {},
    content: ContentBuilder<MdElement>? = null,
) {
    MdTagElement(
        tagName = tagName,
        applyAttrs = Modifier.toAttrs {
            attrs?.invoke(this)
            classes("md-select")
            attr("label", label)
            supportingText?.let { attr("supportingText", it) }
            errorText?.let { attr("errorText", it) }
            required?.let { attr("required", "") }
            addEventListener("change") {
                onChange(it)
            }
        },
        content = content
    )
}

@Composable
fun FilledSelect(
    attrs: AttrBuilderContext<MdElement>?,
    label: String,
    supportingText: String? = null,
    errorText: String? = null,
    required: Boolean? = null,
    onChange: (SyntheticEvent<EventTarget>) -> Unit = {},
    content: ContentBuilder<MdElement>? = null,
) {
    val tag = "filled-select"
    MdSelectTagElement(
        tagName = "md-$tag",
        label = label,
        supportingText = supportingText,
        errorText = errorText,
        required = required,
        onChange = onChange,
        attrs = attrs,
        content = content
    )
}

@Composable
fun OutlinedSelect(
    attrs: AttrBuilderContext<MdElement>?,
    label: String,
    supportingText: String? = null,
    errorText: String? = null,
    required: Boolean? = null,
    onChange: (SyntheticEvent<EventTarget>) -> Unit = {},
    content: ContentBuilder<MdElement>? = null,
) {
    val tag = "outlined-select"
    MdSelectTagElement(
        tagName = "md-$tag",
        label = label,
        supportingText = supportingText,
        errorText = errorText,
        required = required,
        onChange = onChange,
        attrs = attrs,
        content = content
    )
}

@Composable
fun SelectOption(
    value: String = "",
    headline: String? = null,
    modifier: Modifier = Modifier,
    content: ContentBuilder<MdElement>? = null,
) {
    val tag = "select-option"
    MdTagElement(
        tagName = "md-$tag",
        applyAttrs = modifier.toAttrs {
            attr("value", value)
            headline?.let { attr("headline", it) }
        },
        content = content
    )
}
