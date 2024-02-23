package material.web.component.labs.menu

import androidx.compose.runtime.Composable
import androidx.compose.web.events.SyntheticEvent
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.modifiers.position
import com.varabyte.kobweb.compose.ui.toAttrs
import material.web.common.MdElement
import material.web.common.MdTagElement
import material.web.common.jsRequire
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.w3c.dom.events.EventTarget

@Suppress("UnsafeCastFromDynamic")
@Composable
fun Menu(
    attrs: AttrBuilderContext<MdElement>? = null,
    anchor: String? = null,
    position: Position = Position.Absolute,
    quick: Boolean = false,
    hasOverflow: Boolean = false,
    open: Boolean = false,
    xOffset: Int = 0,
    yOffset: Int = 0,
    typeAHeadDelay: Int? = null,
    anchorCorner: Corner? = null,
    stayOpenOnOutsideClick: Boolean = false,
    stayOpenOnFocusOut: Boolean = false,
    skipRestoreFocus: Boolean = false,
    defaultFocusState: FocusState? = null,
    isSubmenu: Boolean = false,
    onOpening: ((SyntheticEvent<EventTarget>) -> Unit) = {},
    onOpened: ((SyntheticEvent<EventTarget>) -> Unit) = {},
    onClosing: ((SyntheticEvent<EventTarget>) -> Unit) = {},
    onClosed: ((SyntheticEvent<EventTarget>) -> Unit) = {},
    content: ContentBuilder<MdElement>? = null,
) {
    MdTagElement(
        tagName = "md-menu",
        applyAttrs = Modifier
            .position(position)
            .onClick { evt ->
                evt.preventDefault()
            }
            .toAttrs {
                attrs?.invoke(this)
                anchor?.let { attr("anchor", it) }
                if (quick) attr("quick", "")
                if (hasOverflow) attr("hasOverflow", "")
                if (open) attr("open", "")
                if (xOffset != 0) attr("xOffset", xOffset.toString())
                if (yOffset != 0) attr("yOffset", yOffset.toString())
                typeAHeadDelay?.let { attr("typeaheadDelay", it.toString()) }
                anchorCorner?.let { attr("anchorCorner", it.value) }
                if (stayOpenOnOutsideClick) attr("stayOpenOnOutsideClick", "")
                if (stayOpenOnFocusOut) attr("stayOpenOnFocusout", "")
                if (skipRestoreFocus) attr("skipRestoreFocus", "")
                defaultFocusState?.let { attr("defaultFocusState", it.value) }
                if (isSubmenu) attr("isSubmenu", "")
                addEventListener("opening") { onOpening(it) }
                addEventListener("opened") { onOpened(it) }
                addEventListener("closing") { onClosing(it) }
                addEventListener("closed") { onClosed(it) }
            },
        content = content
    ).also { jsRequire("@material/web/menu/menu.js") }
}

enum class Corner(val value: String) {
    END_START("end-start"),
    END_END("end-end"),
    START_START("start-start"),
    START_END("start-end"),
}

enum class FocusState(val value: String) {
    NONE("none"),
    LIST_ROOT("list-root"),
    FIRST_ITEM("first-item"),
    LAST_ITEM("last-item"),
}
