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
fun Badge(
    attrs: AttrBuilderContext<MdElement>? = null,
    value: String = "",
) {
    val tag = "badge"
    MdTagElement(
        tagName = "md-$tag",
        applyAttrs = Modifier.toAttrs {
            attrs?.invoke(this)
            attr("value", value)
        },
        content = {}
    ).also { jsRequire("@material/web/labs/badge/$tag.js") }
}
