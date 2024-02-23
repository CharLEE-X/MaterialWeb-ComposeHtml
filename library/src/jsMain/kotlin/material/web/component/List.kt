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
fun List(
    attrs: AttrBuilderContext<MdElement>? = null,
    content: ContentBuilder<MdElement>? = null,
) {
    val tag = "list"
    MdTagElement(
        tagName = "md-$tag",
        applyAttrs = attrs,
        content = content
    ).also { jsRequire("@material/web/list/$tag.js") }
}

@Suppress("UnsafeCastFromDynamic")
@Composable
fun ListItem(
    attrs: AttrBuilderContext<MdElement>? = null,
    headline: String? = null,
    supportingText: String? = null,
    content: ContentBuilder<MdElement>? = null,
) {
    val tag = "list-item"
    MdTagElement(
        tagName = "md-$tag",
        applyAttrs = Modifier.toAttrs {
            attrs?.invoke(this)
            headline?.let { attr("headline", it) }
            supportingText?.let { attr("supportingText", it) }
        },
        content = content
    ).also { jsRequire("@material/web/list/$tag.js") }
}
