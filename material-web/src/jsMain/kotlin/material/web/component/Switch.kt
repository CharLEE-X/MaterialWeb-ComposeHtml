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

@Suppress("UnsafeCastFromDynamic")
@Composable
fun Switch(
    attrs: AttrBuilderContext<MdElement>?,
    value: Boolean? = null,
    selected: Boolean = false,
    onClick: (SyntheticMouseEvent) -> Unit = {},
    icons: Boolean = false,
    showOnlySelectedIcon: Boolean = false,
    disabled: Boolean = false,
) {
    val tag = "switch"
    MdTagElement(
        tagName = "md-$tag",
        applyAttrs = Modifier
            .onClick {
                println("Switch.onClick: $it")
                onClick(it)
            }
            .toAttrs {
                attrs?.invoke(this)
                value?.let { attr("value", it.toString()) }
                if (selected) attr("selected", "")
                if (icons) attr("icons", "")
                if (showOnlySelectedIcon) attr("showOnlySelectedIcon", "")
                if (disabled) attr("disabled", "")
            },
        content = null
    ).also { jsRequire("@material/web/switch/$tag.js") }
}
