package material.web.component

import androidx.compose.runtime.Composable
import androidx.compose.web.events.SyntheticEvent
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.toAttrs
import kotlinx.browser.document
import material.web.common.MdElement
import material.web.common.MdTagElement
import material.web.common.jsRequire
import material.web.common.slot
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.Span
import org.w3c.dom.events.EventTarget

@Suppress("UnsafeCastFromDynamic")
@Composable
fun Dialog(
    attrs: AttrBuilderContext<MdElement>? = null,
    open: Boolean = true,
    onOpening: ((SyntheticEvent<EventTarget>) -> Unit) = {},
    onOpened: ((SyntheticEvent<EventTarget>) -> Unit) = {},
    onClosing: ((SyntheticEvent<EventTarget>) -> Unit) = {},
    onClosed: ((SyntheticEvent<EventTarget>) -> Unit) = {},
    onCancel: ((SyntheticEvent<EventTarget>) -> Unit) = {},
    headline: (@Composable () -> Unit)? = null,
    actions: (@Composable () -> Unit)? = null,
    content: @Composable () -> Unit,
) {
    val tag = "dialog"
    MdTagElement(
        tagName = "md-$tag",
        applyAttrs = Modifier.toAttrs {
            attrs?.invoke(this)
            if (open) attr("open", "")
            addEventListener("opening") { onOpening(it) }
            addEventListener("opened") {
                onOpened(it)
                document.body?.style?.overflowY = Overflow.Hidden.toString()
            }
            addEventListener("closing") { onClosing(it) }
            addEventListener("closed") {
                onClosed(it)
                document.body?.style?.overflowY = Overflow.Auto.toString()
            }
            addEventListener("cancel") { onCancel(it) }
        },
    ) {
        headline?.let { Span({ slot = "headline" }) { it() } }
        actions?.let { Span({ slot = "actions" }) { it() } }
        Span({ slot = "content" }) { content() }
    }.also { jsRequire("@material/web/dialog/$tag.js") }
}
