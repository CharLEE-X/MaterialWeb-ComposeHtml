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
fun NavigationTab(
    attrs: AttrBuilderContext<MdElement>? = null,
    label: String,
    disabled: Boolean = false,
    active: Boolean = false,
    hideInactiveLabels: Boolean = false,
    badgeValue: String? = null,
    showBadge: Boolean = false,
    onClick: (SyntheticMouseEvent) -> Unit = {},
    content: ContentBuilder<MdElement>? = null,
) {
    val tag = "navigation-tab"
    MdTagElement(
        tagName = "navigation-tab",
        applyAttrs = Modifier
            .onClick { onClick(it) }
            .toAttrs {
                attrs?.invoke(this)
                attr("label", label)
                if (disabled) attr("disabled", "")
                if (active) attr("active", "")
                if (hideInactiveLabels) attr("hide-inactive-labels", "")
                badgeValue?.let { attr("badge-value", it) }
                if (showBadge) attr("show-badge-dot", "")
            },
        content = content
    ).also { jsRequire("@material/web/labs/navigationtab/$tag.js") }
}
