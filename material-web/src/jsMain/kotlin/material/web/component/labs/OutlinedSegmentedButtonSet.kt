package material.web.component.labs

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.CSSLengthOrPercentageNumericValue
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.Height
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
private fun BaseOutlinedSegmentedButtonSet(
    attrs: AttrBuilderContext<MdElement>?,
    containerHeight: CSSLengthOrPercentageNumericValue?,
    disabledIconColor: CSSColorValue?,
    disabledLabelTextColor: CSSColorValue?,
    disabledOutlineColor: CSSColorValue?,
    hoverStateLayerOpacity: CSSLengthOrPercentageNumericValue?,
    labelTextFont: String?,
    labelTextLineHeight: Height?,
    labelTextSize: CSSLengthOrPercentageNumericValue?,
    labelTextWeight: FontWeight?,
    outlineColor: CSSColorValue?,
    pressedStateLayerOpacity: CSSLengthOrPercentageNumericValue?,
    selectedContainerColor: CSSColorValue?,
    selectedFocusIconColor: CSSColorValue?,
    selectedFocusLabelTextColor: CSSColorValue?,
    selectedHoverIconColor: CSSColorValue?,
    selectedHoverLabelTextColor: CSSColorValue?,
    selectedHoverStateLayerColor: CSSColorValue?,
    selectedLabelTextColor: CSSColorValue?,
    selectedPressedIconColor: CSSColorValue?,
    selectedPressedLabelTextColor: CSSColorValue?,
    selectedPressedStateLayerColor: CSSColorValue?,
    shape: CSSLengthOrPercentageNumericValue?,
    unselectedFocusIconColor: CSSColorValue?,
    unselectedFocusLabelTextColor: CSSColorValue?,
    unselectedHoverIconColor: CSSColorValue?,
    unselectedHoverLabelTextColor: CSSColorValue?,
    unselectedHoverStateLayerColor: CSSColorValue?,
    unselectedLabelTextColor: CSSColorValue?,
    unselectedPressedIconColor: CSSColorValue?,
    unselectedPressedLabelTextColor: CSSColorValue?,
    unselectedPressedStateLayerColor: CSSColorValue?,
    iconSize: CSSLengthOrPercentageNumericValue?,
    selectedIconColor: CSSColorValue?,
    unselectedIconColor: CSSColorValue?,
    shapeStartStart: CSSLengthOrPercentageNumericValue?,
    shapeStartEnd: CSSLengthOrPercentageNumericValue?,
    shapeEndEnd: CSSLengthOrPercentageNumericValue?,
    shapeEndStart: CSSLengthOrPercentageNumericValue?,
    content: ContentBuilder<MdElement>?,
) {
    val tag = "outlined-segmented-button-set"
    MdTagElement(
        tagName = "md-$tag",
        applyAttrs = Modifier.styleModifier {
            containerHeight?.let { property("--md-$tag-container-height", it.toString()) }
            disabledIconColor?.let { property("--md-$tag-disabled-icon-color", it.toString()) }
            disabledLabelTextColor?.let { property("--md-$tag-disabled-label-text-color", it.toString()) }
            disabledOutlineColor?.let { property("--md-$tag-disabled-outline-color", it.toString()) }
            hoverStateLayerOpacity?.let { property("--md-$tag-hover-state-layer-opacity", it.toString()) }
            labelTextFont?.let { property("--md-$tag-label-text-font", it) }
            labelTextLineHeight?.let { property("--md-$tag-label-text-line-height", it.toString()) }
            labelTextSize?.let { property("--md-$tag-label-text-size", it.toString()) }
            labelTextWeight?.let { property("--md-$tag-label-text-weight", it.toString()) }
            outlineColor?.let { property("--md-$tag-outline-color", it.toString()) }
            pressedStateLayerOpacity?.let { property("--md-$tag-pressed-state-layer-opacity", it.toString()) }
            selectedContainerColor?.let { property("--md-$tag-selected-container-color", it.toString()) }
            selectedFocusIconColor?.let { property("--md-$tag-selected-focus-icon-color", it.toString()) }
            selectedFocusLabelTextColor?.let {
                property(
                    "--md-$tag-selected-focus-label-text-color",
                    it.toString()
                )
            }
            selectedHoverIconColor?.let { property("--md-$tag-selected-hover-icon-color", it.toString()) }
            selectedHoverLabelTextColor?.let {
                property(
                    "--md-$tag-selected-hover-label-text-color",
                    it.toString()
                )
            }
            selectedHoverStateLayerColor?.let {
                property(
                    "--md-$tag-selected-hover-state-layer-color",
                    it.toString()
                )
            }
            selectedLabelTextColor?.let { property("--md-$tag-selected-label-text-color", it.toString()) }
            selectedPressedIconColor?.let { property("--md-$tag-selected-pressed-icon-color", it.toString()) }
            selectedPressedLabelTextColor?.let {
                property(
                    "--md-$tag-selected-pressed-label-text-color",
                    it.toString()
                )
            }
            selectedPressedStateLayerColor?.let {
                property(
                    "--md-$tag-selected-pressed-state-layer-color",
                    it.toString()
                )
            }
            shape?.let { property("--md-$tag-shape", it.toString()) }
            unselectedFocusIconColor?.let { property("--md-$tag-unselected-focus-icon-color", it.toString()) }
            unselectedFocusLabelTextColor?.let {
                property(
                    "--md-$tag-unselected-focus-label-text-color",
                    it.toString()
                )
            }
            unselectedHoverIconColor?.let { property("--md-$tag-unselected-hover-icon-color", it.toString()) }
            unselectedHoverLabelTextColor?.let {
                property(
                    "--md-$tag-unselected-hover-label-text-color",
                    it.toString()
                )
            }
            unselectedHoverStateLayerColor?.let {
                property(
                    "--md-$tag-unselected-hover-state-layer-color",
                    it.toString()
                )
            }
            unselectedLabelTextColor?.let { property("--md-$tag-unselected-label-text-color", it.toString()) }
            unselectedPressedIconColor?.let { property("--md-$tag-unselected-pressed-icon-color", it.toString()) }
            unselectedPressedLabelTextColor?.let {
                property(
                    "--md-$tag-unselected-pressed-label-text-color",
                    it.toString()
                )
            }
            unselectedPressedStateLayerColor?.let {
                property(
                    "--md-$tag-unselected-pressed-state-layer-color",
                    it.toString()
                )
            }
            iconSize?.let { property("--md-$tag-icon-size", it.toString()) }
            selectedIconColor?.let { property("--md-$tag-selected-icon-color", it.toString()) }
            unselectedIconColor?.let { property("--md-$tag-unselected-icon-color", it.toString()) }
            shapeStartStart?.let { property("--md-$tag-shape-start-start", it.toString()) }
            shapeStartEnd?.let { property("--md-$tag-shape-start-end", it.toString()) }
            shapeEndEnd?.let { property("--md-$tag-shape-end-end", it.toString()) }
            shapeEndStart?.let { property("--md-$tag-shape-end-start", it.toString()) }
        }.toAttrs {
            attrs?.invoke(this)
        },
        content = content
    ).also { jsRequire("@material/web/labs/segmentedbuttonset/$tag.js") }
}

@Composable
fun OutlinedSegmentedButtonSet(
    attrs: AttrBuilderContext<MdElement>? = null,
    containerHeight: CSSLengthOrPercentageNumericValue? = null,
    disabledIconColor: CSSColorValue? = null,
    disabledLabelTextColor: CSSColorValue? = null,
    disabledOutlineColor: CSSColorValue? = null,
    hoverStateLayerOpacity: CSSLengthOrPercentageNumericValue? = null,
    labelTextFont: String? = null,
    labelTextLineHeight: Height? = null,
    labelTextSize: CSSLengthOrPercentageNumericValue? = null,
    labelTextWeight: FontWeight? = null,
    outlineColor: CSSColorValue? = null,
    pressedStateLayerOpacity: CSSLengthOrPercentageNumericValue? = null,
    selectedContainerColor: CSSColorValue? = null,
    selectedFocusIconColor: CSSColorValue? = null,
    selectedFocusLabelTextColor: CSSColorValue? = null,
    selectedHoverIconColor: CSSColorValue? = null,
    selectedHoverLabelTextColor: CSSColorValue? = null,
    selectedHoverStateLayerColor: CSSColorValue? = null,
    selectedLabelTextColor: CSSColorValue? = null,
    selectedPressedIconColor: CSSColorValue? = null,
    selectedPressedLabelTextColor: CSSColorValue? = null,
    selectedPressedStateLayerColor: CSSColorValue? = null,
    shape: CSSLengthOrPercentageNumericValue? = null,
    unselectedFocusIconColor: CSSColorValue? = null,
    unselectedFocusLabelTextColor: CSSColorValue? = null,
    unselectedHoverIconColor: CSSColorValue? = null,
    unselectedHoverLabelTextColor: CSSColorValue? = null,
    unselectedHoverStateLayerColor: CSSColorValue? = null,
    unselectedLabelTextColor: CSSColorValue? = null,
    unselectedPressedIconColor: CSSColorValue? = null,
    unselectedPressedLabelTextColor: CSSColorValue? = null,
    unselectedPressedStateLayerColor: CSSColorValue? = null,
    iconSize: CSSLengthOrPercentageNumericValue? = null,
    selectedIconColor: CSSColorValue? = null,
    unselectedIconColor: CSSColorValue? = null,
    shapeStartStart: CSSLengthOrPercentageNumericValue? = null,
    shapeStartEnd: CSSLengthOrPercentageNumericValue? = null,
    shapeEndEnd: CSSLengthOrPercentageNumericValue? = null,
    shapeEndStart: CSSLengthOrPercentageNumericValue? = null,
    content: ContentBuilder<MdElement>? = null,
) {
    BaseOutlinedSegmentedButtonSet(
        attrs = attrs,
        containerHeight = containerHeight,
        disabledIconColor = disabledIconColor,
        disabledLabelTextColor = disabledLabelTextColor,
        disabledOutlineColor = disabledOutlineColor,
        hoverStateLayerOpacity = hoverStateLayerOpacity,
        labelTextFont = labelTextFont,
        labelTextLineHeight = labelTextLineHeight,
        labelTextSize = labelTextSize,
        labelTextWeight = labelTextWeight,
        outlineColor = outlineColor,
        pressedStateLayerOpacity = pressedStateLayerOpacity,
        selectedContainerColor = selectedContainerColor,
        selectedFocusIconColor = selectedFocusIconColor,
        selectedFocusLabelTextColor = selectedFocusLabelTextColor,
        selectedHoverIconColor = selectedHoverIconColor,
        selectedHoverLabelTextColor = selectedHoverLabelTextColor,
        selectedHoverStateLayerColor = selectedHoverStateLayerColor,
        selectedLabelTextColor = selectedLabelTextColor,
        selectedPressedIconColor = selectedPressedIconColor,
        selectedPressedLabelTextColor = selectedPressedLabelTextColor,
        selectedPressedStateLayerColor = selectedPressedStateLayerColor,
        shape = shape,
        unselectedFocusIconColor = unselectedFocusIconColor,
        unselectedFocusLabelTextColor = unselectedFocusLabelTextColor,
        unselectedHoverIconColor = unselectedHoverIconColor,
        unselectedHoverLabelTextColor = unselectedHoverLabelTextColor,
        unselectedHoverStateLayerColor = unselectedHoverStateLayerColor,
        unselectedLabelTextColor = unselectedLabelTextColor,
        unselectedPressedIconColor = unselectedPressedIconColor,
        unselectedPressedLabelTextColor = unselectedPressedLabelTextColor,
        unselectedPressedStateLayerColor = unselectedPressedStateLayerColor,
        iconSize = iconSize,
        selectedIconColor = selectedIconColor,
        unselectedIconColor = unselectedIconColor,
        shapeStartStart = shapeStartStart,
        shapeStartEnd = shapeStartEnd,
        shapeEndEnd = shapeEndEnd,
        shapeEndStart = shapeEndStart,
        content = content
    )
}

@Composable
fun OutlinedSegmentedButtonSet(
    modifier: Modifier = Modifier,
    containerHeight: CSSLengthOrPercentageNumericValue? = null,
    disabledIconColor: CSSColorValue? = null,
    disabledLabelTextColor: CSSColorValue? = null,
    disabledOutlineColor: CSSColorValue? = null,
    hoverStateLayerOpacity: CSSLengthOrPercentageNumericValue? = null,
    labelTextFont: String? = null,
    labelTextLineHeight: Height? = null,
    labelTextSize: CSSLengthOrPercentageNumericValue? = null,
    labelTextWeight: FontWeight? = null,
    outlineColor: CSSColorValue? = null,
    pressedStateLayerOpacity: CSSLengthOrPercentageNumericValue? = null,
    selectedContainerColor: CSSColorValue? = null,
    selectedFocusIconColor: CSSColorValue? = null,
    selectedFocusLabelTextColor: CSSColorValue? = null,
    selectedHoverIconColor: CSSColorValue? = null,
    selectedHoverLabelTextColor: CSSColorValue? = null,
    selectedHoverStateLayerColor: CSSColorValue? = null,
    selectedLabelTextColor: CSSColorValue? = null,
    selectedPressedIconColor: CSSColorValue? = null,
    selectedPressedLabelTextColor: CSSColorValue? = null,
    selectedPressedStateLayerColor: CSSColorValue? = null,
    shape: CSSLengthOrPercentageNumericValue? = null,
    unselectedFocusIconColor: CSSColorValue? = null,
    unselectedFocusLabelTextColor: CSSColorValue? = null,
    unselectedHoverIconColor: CSSColorValue? = null,
    unselectedHoverLabelTextColor: CSSColorValue? = null,
    unselectedHoverStateLayerColor: CSSColorValue? = null,
    unselectedLabelTextColor: CSSColorValue? = null,
    unselectedPressedIconColor: CSSColorValue? = null,
    unselectedPressedLabelTextColor: CSSColorValue? = null,
    unselectedPressedStateLayerColor: CSSColorValue? = null,
    iconSize: CSSLengthOrPercentageNumericValue? = null,
    selectedIconColor: CSSColorValue? = null,
    unselectedIconColor: CSSColorValue? = null,
    shapeStartStart: CSSLengthOrPercentageNumericValue? = null,
    shapeStartEnd: CSSLengthOrPercentageNumericValue? = null,
    shapeEndEnd: CSSLengthOrPercentageNumericValue? = null,
    shapeEndStart: CSSLengthOrPercentageNumericValue? = null,
    content: ContentBuilder<MdElement>? = null,
) {
    OutlinedSegmentedButtonSet(
        attrs = modifier.toAttrs(),
        containerHeight = containerHeight,
        disabledIconColor = disabledIconColor,
        disabledLabelTextColor = disabledLabelTextColor,
        disabledOutlineColor = disabledOutlineColor,
        hoverStateLayerOpacity = hoverStateLayerOpacity,
        labelTextFont = labelTextFont,
        labelTextLineHeight = labelTextLineHeight,
        labelTextSize = labelTextSize,
        labelTextWeight = labelTextWeight,
        outlineColor = outlineColor,
        pressedStateLayerOpacity = pressedStateLayerOpacity,
        selectedContainerColor = selectedContainerColor,
        selectedFocusIconColor = selectedFocusIconColor,
        selectedFocusLabelTextColor = selectedFocusLabelTextColor,
        selectedHoverIconColor = selectedHoverIconColor,
        selectedHoverLabelTextColor = selectedHoverLabelTextColor,
        selectedHoverStateLayerColor = selectedHoverStateLayerColor,
        selectedLabelTextColor = selectedLabelTextColor,
        selectedPressedIconColor = selectedPressedIconColor,
        selectedPressedLabelTextColor = selectedPressedLabelTextColor,
        selectedPressedStateLayerColor = selectedPressedStateLayerColor,
        shape = shape,
        unselectedFocusIconColor = unselectedFocusIconColor,
        unselectedFocusLabelTextColor = unselectedFocusLabelTextColor,
        unselectedHoverIconColor = unselectedHoverIconColor,
        unselectedHoverLabelTextColor = unselectedHoverLabelTextColor,
        unselectedHoverStateLayerColor = unselectedHoverStateLayerColor,
        unselectedLabelTextColor = unselectedLabelTextColor,
        unselectedPressedIconColor = unselectedPressedIconColor,
        unselectedPressedLabelTextColor = unselectedPressedLabelTextColor,
        unselectedPressedStateLayerColor = unselectedPressedStateLayerColor,
        iconSize = iconSize,
        selectedIconColor = selectedIconColor,
        unselectedIconColor = unselectedIconColor,
        shapeStartStart = shapeStartStart,
        shapeStartEnd = shapeStartEnd,
        shapeEndEnd = shapeEndEnd,
        shapeEndStart = shapeEndStart,
        content = content
    )
}
