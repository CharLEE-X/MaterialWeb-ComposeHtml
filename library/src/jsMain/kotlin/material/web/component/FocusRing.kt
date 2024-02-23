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
fun FocusRing(
    attrs: AttrBuilderContext<MdElement>? = null,
    visible: Boolean? = null,
    inward: Boolean = false,
) {
    MdTagElement(
        tagName = "md-focus-ring",
        applyAttrs = Modifier.toAttrs {
            attrs?.invoke(this)
            if (visible != null) attr("visible", "")
            if (inward) attr("inward", "")
        },
        content = null
    ).also { jsRequire("@material/web/focus/md-focus-ring.js") }
}
