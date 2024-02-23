package material.web.component

import androidx.compose.runtime.Composable
import material.web.common.MdElement
import material.web.common.MdTagElement
import material.web.common.jsRequire
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder

@Suppress("UnsafeCastFromDynamic")
@Composable
fun NavigationBar(
    attrs: AttrBuilderContext<MdElement>? = null,
    content: ContentBuilder<MdElement>? = null,
) {
    val tag = "navigation-bar"
    MdTagElement(
        tagName = "md-$tag",
        applyAttrs = attrs,
        content = content
    ).also { jsRequire("@material/web/labs/navigationbar/$tag.js") }
}
