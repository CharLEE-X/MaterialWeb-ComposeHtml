package material.web.component

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.toAttrs
import material.web.common.MdElement
import material.web.common.MdTagElement
import material.web.common.jsRequire
import org.jetbrains.compose.web.dom.AttrBuilderContext

@Suppress("UnsafeCastFromDynamic")
@Composable
fun Ripple(
    attrs: AttrBuilderContext<MdElement>?,
    disabled: Boolean? = null,
) {
    val tag = "ripple"
    MdTagElement(
        tagName = "md-$tag",
        applyAttrs = Modifier.toAttrs {
            attrs?.invoke(this)
            disabled?.let { attr("disabled", "") }
        },
        content = null
    ).also { jsRequire("@material/web/ripple/$tag.js") }
}
