package material.web.component.labs.menu

import androidx.compose.runtime.Composable
import androidx.compose.web.events.SyntheticEvent
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.toAttrs
import material.web.common.MdElement
import material.web.common.MdTagElement
import material.web.common.jsRequire
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.w3c.dom.events.EventTarget

@Suppress("UnsafeCastFromDynamic")
@Composable
fun SubMenu(
    attrs: AttrBuilderContext<MdElement>? = null,
    anchorCorner: Corner? = null,
    menuCorner: Corner? = null,
    hoverOpenDelay: Int? = null,
    hoverCloseDelay: Int? = null,
    isSubMenu: Boolean = false,
    onCLick: (SyntheticEvent<EventTarget>) -> Unit = {},
    content: ContentBuilder<MdElement>?,
) {
    MdTagElement(
        tagName = "md-sub-menu",
        applyAttrs = Modifier
            .onClick { evt ->
                println("Evt: ${evt.target.asDynamic().id}")
                onCLick(evt)
                evt.stopPropagation()
            }
            .toAttrs {
                attrs?.invoke(this)
                anchorCorner?.let { attr("anchorCorner", it.value) }
                menuCorner?.let { attr("menuCorner", it.value) }
                hoverOpenDelay?.let { attr("hoverOpenDelay", it.toString()) }
                hoverCloseDelay?.let { attr("hoverCloseDelay", it.toString()) }
                if (isSubMenu) attr("isSubMenu", "")
            },
        content = content
    ).also { jsRequire("@material/web/menu/sub-menu.js") }
}
