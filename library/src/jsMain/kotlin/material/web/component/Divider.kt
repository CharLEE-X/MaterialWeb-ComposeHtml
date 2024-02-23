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
fun Divider(
    attrs: AttrBuilderContext<MdElement>? = null,
    inset: Boolean = false,
    insetStart: Boolean = false,
    insetEnd: Boolean = false,
) {
    val tag = "divider"
    MdTagElement(
        tagName = "md-$tag",
        applyAttrs = Modifier.toAttrs {
            attrs?.invoke(this)
            if (inset) attr("inset", "")
            if (insetStart) attr("inset-start", "")
            if (insetEnd) attr("inset-end", "")
        },
        content = {}
    ).also { jsRequire("@material/web/divider/$tag.js") }
}
