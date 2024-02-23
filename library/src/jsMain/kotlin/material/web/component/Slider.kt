package material.web.component

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.toAttrs
import material.web.common.MdElement
import material.web.common.MdTagElement
import material.web.common.jsRequire
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.w3c.dom.HTMLInputElement

@Suppress("UnsafeCastFromDynamic")
@Composable
fun Slider(
    attrs: AttrBuilderContext<MdElement>?,
    value: Float,
    min: Float,
    max: Float,
    step: Float,
    valueLabel: String? = null,
    withTickMarks: Boolean = false,
    withLabel: Boolean = false,
    disabled: Boolean = false,
    onChange: (Float) -> Unit = {},
) {
    val tag = "slider"
    MdTagElement(
        tagName = "md-$tag",
        applyAttrs = Modifier
            .toAttrs {
                attrs?.invoke(this)
                attr("value", value.toString())
                attr("min", min.toString())
                attr("max", max.toString())
                attr("step", step.toString())
                valueLabel?.let { attr("valueLabel", valueLabel) }
                if (withTickMarks) attr("withTickMarks", "")
                if (withLabel) attr("withLabel", "")
                if (disabled) attr("disabled", "")
                addEventListener("change") {
                    onChange((it.target as? HTMLInputElement)?.value?.toFloat() ?: 0f)
                }
            },
        content = null
    ).also { jsRequire("@material/web/slider/$tag.js") }
}
