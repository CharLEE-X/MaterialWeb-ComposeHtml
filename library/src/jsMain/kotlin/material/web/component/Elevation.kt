package material.web.component

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.compose.ui.toAttrs
import material.web.common.MdElement
import material.web.common.MdTagElement
import material.web.common.jsRequire
import org.jetbrains.compose.web.css.CSSStyleVariable
import org.jetbrains.compose.web.css.StylePropertyNumber
import org.jetbrains.compose.web.dom.AttrBuilderContext

@Suppress("UnsafeCastFromDynamic")
@Composable
fun Elevation(
    attrs: AttrBuilderContext<MdElement>? = null,
    level: Int,
) {
    val tag = "elevation"
    MdTagElement(
        tagName = "md-$tag",
        applyAttrs = Modifier
            .styleModifier { mdElevationLevel(level) }
            .toAttrs(attrs),
        content = null
    ).also { jsRequire("@material/web/elevation/$tag.js") }
}

private val mdElevationLevel = CSSStyleVariable<StylePropertyNumber>("--md-elevation-level")
