package material.web.component.labs.menu

import androidx.compose.runtime.Composable
import androidx.compose.web.events.SyntheticEvent
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.compose.ui.toAttrs
import material.web.common.MdElement
import material.web.common.MdTagElement
import material.web.common.jsRequire
import material.web.common.slot
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.Span
import org.w3c.dom.events.EventTarget


@Suppress("UnsafeCastFromDynamic")
@Composable
fun MenuItem(
    attrs: AttrBuilderContext<MdElement>? = null,
    onClick: (SyntheticEvent<EventTarget>) -> Unit = {},
    selected: Boolean = false,
    disabled: Boolean = false,
    keepOpen: Boolean = false,
    supportingText: @Composable (() -> Unit)? = null,
    trailingSupportingText: @Composable (() -> Unit)? = null,
    content: ContentBuilder<MdElement>?,
) {
    MdTagElement(
        tagName = "md-menu-item",
        applyAttrs = Modifier
            .onClick { evt ->
                onClick(evt)
                evt.stopPropagation()
            }
            .styleModifier {
                property("--md-menu-item-selected-container-color", "#b2ff59")
            }
            .toAttrs {
                attrs?.invoke(this)
                if (keepOpen) attr("keepOpen", "")
                if (selected) attr("selected", "")
                if (disabled) attr("disabled", "")
            },
    ) {
        supportingText?.let {
            Span({ slot = "supporting-text" }) { it() }
        }
        trailingSupportingText?.let {
            Span({ slot = "trailing-supporting-text" }) { it() }
        }
        content?.invoke(this)
    }.also { jsRequire("@material/web/menu/menu-item.js") }
}
