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
fun ModalNavigationDrawer(
    attrs: AttrBuilderContext<MdElement>? = null,
    opened: Boolean = false,
    content: ContentBuilder<NavigationDrawerElement>? = null,
) {
    val tag = "navigation-drawer-modal"
    MdTagElement(
        tagName = "md-navigation-drawer-modal",
        applyAttrs = Modifier.toAttrs {
            attrs?.invoke(this)
            if (opened) attr("opened", "")
        },
        content = content
    ).also { jsRequire("@material/web/labs/navigationdrawer/$tag.js") }
}

abstract class NavigationDrawerElement : MdElement()

@Suppress("UnsafeCastFromDynamic")
@Composable
fun NavigationDrawer(
    attrs: AttrBuilderContext<MdElement>? = null,
    opened: Boolean = false,
    pivot: Pivot? = null,
    content: ContentBuilder<NavigationDrawerElement>? = null,
) {
    val tag = "navigation-drawer"
    MdTagElement(
        tagName = "md-$tag",
        applyAttrs = Modifier.toAttrs {
            attrs?.invoke(this)
            if (opened) attr("opened", "")
            pivot?.let { attr("pivot", it.value) }
        },
        content = content,
    ).also { jsRequire("@material/web/labs/navigationdrawer/$tag.js") }
}


enum class Pivot(val value: String) {
    START("start"),
    END("end"),
}
