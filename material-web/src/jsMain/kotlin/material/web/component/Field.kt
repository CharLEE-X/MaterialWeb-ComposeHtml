package material.web.component

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.toAttrs
import material.web.common.MdElement
import material.web.common.MdTagElement
import material.web.common.jsRequire
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder

@Suppress("UnsafeCastFromDynamic")
@Composable
private fun BaseField(
    attrs: AttrBuilderContext<MdElement>?,
    name: String,
    label: String?,
    value: String?,
    errorText: String?,
    isError: Boolean,
    content: ContentBuilder<MdElement>?,
) {
    MdTagElement(
        tagName = "md-$name-field",
        applyAttrs = Modifier.toAttrs {
            attrs?.invoke(this)
            classes("md-field")
            if (label != null) attr("label", label)
            if (value != null) attr("value", value)
            if (errorText != null) attr("errorText", errorText)
            if (isError) attr("error", "")
        },
        content = content
    ).also { jsRequire("@material/web/field/$name-field.js") }
}

@Composable
fun FilledField(
    attrs: AttrBuilderContext<MdElement>? = null,
    label: String? = null,
    value: String? = null,
    errorText: String? = null,
    isError: Boolean = false,
    content: ContentBuilder<MdElement>? = null,
) {
    BaseField(
        name = "filled",
        label = label,
        value = value,
        errorText = errorText,
        isError = isError,
        attrs = attrs,
        content = content
    )
}

@Composable
fun OutlinedField(
    attrs: AttrBuilderContext<MdElement>? = null,
    label: String? = null,
    value: String? = null,
    errorText: String? = null,
    isError: Boolean = false,
    content: ContentBuilder<MdElement>? = null,
) {
    BaseField(
        attrs = attrs,
        name = "outlined",
        label = label,
        value = value,
        errorText = errorText,
        isError = isError,
        content = content
    )
}
