package material.web.component

import androidx.compose.runtime.Composable
import androidx.compose.web.events.SyntheticMouseEvent
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.toAttrs
import material.web.common.MdElement
import material.web.common.MdTagElement
import material.web.common.jsRequire
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder

@Suppress("UnsafeCastFromDynamic")
@Composable
fun Fab(
    attrs: AttrBuilderContext<MdElement>? = null,
    label: String? = null,
    fabSize: FabSize = FabSize.MEDIUM,
    onClick: (SyntheticMouseEvent) -> Unit = {},
    modifier: Modifier = Modifier,
    content: ContentBuilder<MdElement>? = null,
) = MdTagElement(
    tagName = "md-fab",
    applyAttrs = modifier
        .onClick { onClick(it) }
        .toAttrs {
            attrs?.invoke(this)
            label?.let { attr("label", it) }
            attr("size", fabSize.value)
        },
    content = content
).also { jsRequire("@material/web/fab/fab.js") }

enum class FabSize(val value: String) {
    SMALL("small"),
    MEDIUM("medium"),
    LARGE("large")
}
