package material.web.component.labs

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.CSSLengthOrPercentageNumericValue
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.compose.ui.toAttrs
import material.web.common.MdElement
import material.web.common.MdTagElement
import material.web.common.jsRequire
import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder

@Suppress("UnsafeCastFromDynamic")
@Composable
private fun BaseCard(
    tag: String,
    attrs: AttrBuilderContext<MdElement>? = null,
    elevation: Int?,
    containerShape: CSSLengthOrPercentageNumericValue?,
    shadowColor: CSSColorValue?,
    content: ContentBuilder<MdElement>?,
) {
    MdTagElement(
        tagName = "md-$tag",
        applyAttrs = Modifier
            .styleModifier {
                elevation?.let { property("--md-$tag-container-elevation", elevation.toString()) }
                containerShape?.let { property("--md-$tag-container-shape", it) }
                shadowColor?.let { property("--md-$tag-container-shadow-color", it.toString()) }
            }
            .toAttrs {
                classes("card")
                attrs?.invoke(this)
            },
        content = content
    ).also { jsRequire("@material/web/labs/card/$tag.js") }
}

@Composable
fun ElevatedCard(
    attrs: AttrBuilderContext<MdElement>? = null,
    elevation: Int? = null,
    containerShape: CSSLengthOrPercentageNumericValue? = null,
    shadowColor: CSSColorValue? = null,
    content: ContentBuilder<MdElement>? = null,
) {
    val tag = "elevated-card"
    BaseCard(
        tag = tag,
        attrs = attrs,
        elevation = elevation,
        containerShape = containerShape,
        shadowColor = shadowColor,
        content = content
    )
}

@Composable
fun ElevatedCard(
    modifier: Modifier = Modifier,
    elevation: Int? = null,
    containerShape: CSSLengthOrPercentageNumericValue? = null,
    shadowColor: CSSColorValue? = null,
    content: ContentBuilder<MdElement>? = null,
) {
    ElevatedCard(
        attrs = modifier.toAttrs(),
        elevation = elevation,
        containerShape = containerShape,
        shadowColor = shadowColor,
        content = content
    )
}

@Composable
fun OutlinedCard(
    attrs: AttrBuilderContext<MdElement>? = null,
    elevation: Int? = null,
    containerShape: CSSLengthOrPercentageNumericValue? = null,
    shadowColor: CSSColorValue? = null,
    content: ContentBuilder<MdElement>? = null,
) {
    val tag = "outlined-card"
    BaseCard(
        tag = tag,
        attrs = attrs,
        elevation = elevation,
        containerShape = containerShape,
        shadowColor = shadowColor,
        content = content
    )
}

@Composable
fun OutlinedCard(
    modifier: Modifier = Modifier,
    elevation: Int? = null,
    containerShape: CSSLengthOrPercentageNumericValue? = null,
    shadowColor: CSSColorValue? = null,
    content: ContentBuilder<MdElement>? = null,
) {
    OutlinedCard(
        attrs = modifier.toAttrs(),
        elevation = elevation,
        containerShape = containerShape,
        shadowColor = shadowColor,
        content = content
    )
}

@Composable
fun FilledCard(
    attrs: AttrBuilderContext<MdElement>? = null,
    elevation: Int? = null,
    containerShape: CSSLengthOrPercentageNumericValue? = null,
    shadowColor: CSSColorValue? = null,
    content: ContentBuilder<MdElement>? = null,
) {
    val tag = "filled-card"
    BaseCard(
        tag = tag,
        attrs = attrs,
        elevation = elevation,
        containerShape = containerShape,
        shadowColor = shadowColor,
        content = content
    )
}

@Composable
fun FilledCard(
    modifier: Modifier = Modifier,
    elevation: Int? = null,
    containerShape: CSSLengthOrPercentageNumericValue? = null,
    shadowColor: CSSColorValue? = null,
    content: ContentBuilder<MdElement>? = null,
) {
    FilledCard(
        attrs = modifier.toAttrs(),
        elevation = elevation,
        containerShape = containerShape,
        shadowColor = shadowColor,
        content = content
    )
}
