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
private fun BaseProgress(
    attrs: AttrBuilderContext<MdElement>?,
    tagName: String,
    value: Float?,
    buffer: Float?,
    intermediate: Boolean,
    fourColor: Boolean,
    content: ContentBuilder<MdElement>?,
) {
    MdTagElement(
        tagName = "md-$tagName",
        applyAttrs = Modifier.toAttrs {
            attrs?.invoke(this)
            classes("md-progress")
            value?.let {
                require(it in 0f..1f)
                attr("value", it.toString())
            }
            buffer?.let {
                require(it in 0f..1f)
                attr("buffer", it.toString())
            }
            if (intermediate) attr("indeterminate", "")
            if (fourColor) attr("four-color", "")
        },
        content = content
    ).also { jsRequire("@material/web/labs/progress/$tagName.js") }
}

@Composable
fun CircularProgress(
    attrs: AttrBuilderContext<MdElement>? = null,
    value: Float? = null,
    buffer: Float? = null,
    intermediate: Boolean = false,
    fourColor: Boolean = false,
) {
    val tag = "circular-progress"
    BaseProgress(
        attrs = attrs,
        tagName = tag,
        value = value,
        buffer = buffer,
        intermediate = intermediate,
        fourColor = fourColor,
        content = null
    )
}

@Composable
fun LinearProgress(
    attrs: AttrBuilderContext<MdElement>? = null,
    value: Float? = null,
    buffer: Float? = null,
    intermediate: Boolean = false,
    fourColor: Boolean = false,
) {
    val tag = "linear-progress"
    BaseProgress(
        tagName = tag,
        value = value,
        buffer = buffer,
        intermediate = intermediate,
        fourColor = fourColor,
        attrs = attrs,
        content = null
    )
}
