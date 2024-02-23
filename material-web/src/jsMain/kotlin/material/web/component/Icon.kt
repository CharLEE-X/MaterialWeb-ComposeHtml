package material.web.component

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.toAttrs
import material.web.common.MdElement
import material.web.common.MdTagElement
import material.web.common.jsRequire
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.Text

@Suppress("UnsafeCastFromDynamic")
@Composable
fun Icon(
    attrs: AttrBuilderContext<MdElement>? = null,
    iconIdentifier: String,
) {
    val tag = "icon"
    MdTagElement(
        tagName = "md-$tag",
        applyAttrs = Modifier.toAttrs(attrs),
        content = { Text(iconIdentifier) }
    ).also { jsRequire("@material/web/icon/$tag.js") }
}
