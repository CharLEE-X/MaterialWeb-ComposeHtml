package material.web.component

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.CSSLengthOrPercentageNumericValue
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.Width
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.compose.ui.toAttrs
import material.web.common.MdElement
import material.web.common.MdTagElement
import material.web.common.jsRequire
import material.web.common.propertyOf
import material.web.common.slot
import org.jetbrains.compose.web.attributes.AutoComplete
import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.Span
import org.w3c.dom.HTMLInputElement

/**
 * [Documentation](https://github.com/material-components/material-web/blob/main/docs/components/text-field.md)
 * [All Tokens](https://github.com/material-components/material-web/blob/main/tokens/_md-comp-filled-text-field.scss)
 */
@Suppress("UnsafeCastFromDynamic")
@Composable
private fun BaseTextField(
    attrs: AttrBuilderContext<MdElement>?,
    tagName: String,
    value: String,
    onInput: (String) -> Unit,
    label: String?,
    type: TextFieldType,
    placeholder: String?,
    leadingIcon: (@Composable () -> Unit)?,
    trailingIcon: (@Composable () -> Unit)?,
    required: Boolean,
    disabled: Boolean,
    autoComplete: AutoComplete?,
    error: Boolean,
    errorText: String?,
    prefixText: String?,
    suffixText: String?,
    rows: Int?,
    cols: Int?,
    max: String?,
    maxLength: Int?,
    min: String?,
    minLength: Int?,
    pattern: String?,
    readOnly: Boolean,
    multiple: Boolean,
    step: String?,
    hasLeadingIcon: Boolean,
    hasTrailingIcon: Boolean,
    supportingText: String?,
    textDirection: String?,
) {
    MdTagElement(
        tagName = "md-$tagName",
        applyAttrs = Modifier
            .toAttrs {
                attrs?.invoke(this)
                classes("md-text-field")

                prop({ element: HTMLInputElement, value: String -> element.value = value }, value)

                attr("type", type.value)
                label?.let { attr("label", it.toString()) }
                placeholder?.let { attr("placeholder", it.toString()) }
                if (hasLeadingIcon) attr("has-leading-icon", "")
                if (hasTrailingIcon) attr("has-trailing-icon", "")
                if (required) attr("required", "")
                if (error) attr("error", "")
                errorText?.let { attr("error-text", it.toString()) }
                prefixText?.let { attr("prefix-text", it.toString()) }
                suffixText?.let { attr("suffix-text", it.toString()) }
                if (disabled) attr("disabled", "")
                supportingText?.let { attr("supporting-text", it.toString()) }
                textDirection?.let { attr("text-direction", it.toString()) }
                rows?.let { attr("rows", it.toString()) }
                cols?.let { attr("cols", it.toString()) }
                max?.let { attr("max", it.toString()) }
                maxLength?.let { attr("max-length", it.toString()) }
                min?.let { attr("min", it.toString()) }
                minLength?.let { attr("min-length", it.toString()) }
                pattern?.let { attr("pattern", it.toString()) }
                if (readOnly) attr("readOnly", "")
                if (multiple) attr("multiple", "")
                step?.let { attr("step", it.toString()) }
                autoComplete?.let { attr("autocomplete", it.toString()) }

                addEventListener("input") {
                    onInput(it.nativeEvent.target.asDynamic().value.unsafeCast<String>())
                }
            },
    ) {
        leadingIcon?.let {
            Span({ slot = "leading-icon" }) { it() }
        }

        trailingIcon?.let {
            Span({ slot = "trailing-icon" }) { it() }
        }
    }.also { jsRequire("@material/web/textfield/$tagName.js") }
}

enum class TextFieldType(val value: String) {
    EMAIL("email"),
    NUMBER("number"),
    PASSWORD("password"),
    SEARCH("search"),
    TEL("tel"),
    TEXT("text"),
    URL("url"),
    TEXTAREA("textarea"),
}

@Composable
fun FilledTextField(
    attrs: AttrBuilderContext<MdElement>?,
    value: String,
    onInput: (String) -> Unit,
    label: String? = null,
    type: TextFieldType = TextFieldType.TEXT,
    placeholder: String? = null,
    leadingIcon: (@Composable () -> Unit)? = null,
    trailingIcon: (@Composable () -> Unit)? = null,
    required: Boolean = false,
    disabled: Boolean = false,
    autoComplete: AutoComplete = AutoComplete.off,
    error: Boolean = false,
    errorText: String? = null,
    prefixText: String? = null,
    suffixText: String? = null,
    rows: Int? = null,
    cols: Int? = null,
    max: String? = null,
    maxLength: Int? = null,
    min: String? = null,
    minLength: Int? = null,
    pattern: String? = null,
    readOnly: Boolean = false,
    multiple: Boolean = false,
    step: String? = null,
    hasLeadingIcon: Boolean = false,
    hasTrailingIcon: Boolean = false,
    supportingText: String? = null,
    textDirection: String? = null,
    // Styles
    activeIndicatorColor: CSSColorValue? = null,
    activeIndicatorHeight: String? = null,
    bottomSpace: CSSLengthOrPercentageNumericValue? = null,
    caretColor: CSSColorValue? = null,
    containerColor: CSSColorValue? = null,
    containerShape: CSSLengthOrPercentageNumericValue? = null,
    containerShapeEndEnd: CSSLengthOrPercentageNumericValue? = null,
    containerShapeEndStart: CSSLengthOrPercentageNumericValue? = null,
    containerShapeStartEnd: CSSLengthOrPercentageNumericValue? = null,
    containerShapeStartStart: CSSLengthOrPercentageNumericValue? = null,
    disabledActiveIndicatorColor: CSSColorValue? = null,
    disabledActiveIndicatorHeight: String? = null,
    disabledActiveIndicatorOpacity: String? = null,
    disabledContainerColor: CSSColorValue? = null,
    disabledContainerOpacity: String? = null,
    disabledInputTextColor: CSSColorValue? = null,
    disabledInputTextOpacity: CSSLengthOrPercentageNumericValue? = null,
    disabledLabelTextColor: CSSColorValue? = null,
    disabledLabelTextOpacity: CSSLengthOrPercentageNumericValue? = null,
    disabledLeadingIconColor: CSSColorValue? = null,
    disabledLeadingIconOpacity: CSSLengthOrPercentageNumericValue? = null,
    disabledSupportingTextColor: CSSColorValue? = null,
    disabledSupportingTextOpacity: CSSLengthOrPercentageNumericValue? = null,
    disabledTrailingIconColor: CSSColorValue? = null,
    disabledTrailingIconOpacity: CSSLengthOrPercentageNumericValue? = null,
    errorActiveIndicatorColor: CSSColorValue? = null,
    errorFocusActiveIndicatorColor: CSSColorValue? = null,
    errorFocusCaretColor: CSSColorValue? = null,
    errorFocusInputTextColor: CSSColorValue? = null,
    errorFocusLabelTextColor: CSSColorValue? = null,
    errorFocusLeadingIconColor: CSSColorValue? = null,
    errorFocusSupportingTextColor: CSSColorValue? = null,
    errorFocusTrailingIconColor: CSSColorValue? = null,
    errorHoverActiveIndicatorColor: CSSColorValue? = null,
    errorHoverInputTextColor: CSSColorValue? = null,
    errorHoverLabelTextColor: CSSColorValue? = null,
    errorHoverLeadingIconColor: CSSColorValue? = null,
    errorHoverStateLayerColor: CSSColorValue? = null,
    errorHoverStateLayerOpacity: String? = null,
    errorHoverSupportingTextColor: CSSColorValue? = null,
    errorHoverTrailingIconColor: CSSColorValue? = null,
    errorInputTextColor: CSSColorValue? = null,
    errorLabelTextColor: CSSColorValue? = null,
    errorLeadingIconColor: CSSColorValue? = null,
    errorSupportingTextColor: CSSColorValue? = null,
    errorTrailingIconColor: CSSColorValue? = null,
    focusActiveIndicatorColor: CSSColorValue? = null,
    focusActiveIndicatorHeight: String? = null,
    focusCaretColor: CSSColorValue? = null,
    focusInputTextColor: CSSColorValue? = null,
    focusLabelTextColor: CSSColorValue? = null,
    focusLeadingIconColor: CSSColorValue? = null,
    focusSupportingTextColor: CSSColorValue? = null,
    focusTrailingIconColor: CSSColorValue? = null,
    hoverActiveIndicatorColor: CSSColorValue? = null,
    hoverActiveIndicatorHeight: String? = null,
    hoverInputTextColor: CSSColorValue? = null,
    hoverLabelTextColor: CSSColorValue? = null,
    hoverLeadingIconColor: CSSColorValue? = null,
    hoverStateLayerColor: CSSColorValue? = null,
    hoverStateLayerOpacity: String? = null,
    hoverSupportingTextColor: CSSColorValue? = null,
    hoverTrailingIconColor: CSSColorValue? = null,
    inputTextColor: CSSColorValue? = null,
    inputTextFont: String? = null,
    inputTextLineHeight: CSSLengthOrPercentageNumericValue? = null,
    inputTextPlaceholderColor: CSSColorValue? = null,
    inputTextPrefixColor: CSSColorValue? = null,
    inputTextPrefixTrailingSpace: CSSLengthOrPercentageNumericValue? = null,
    inputTextSize: CSSLengthOrPercentageNumericValue? = null,
    inputTextSuffixColor: CSSColorValue? = null,
    inputTextSuffixLeadingSpace: CSSLengthOrPercentageNumericValue? = null,
    inputTextWeight: FontWeight? = null,
    labelTextColor: CSSColorValue? = null,
    labelTextFont: String? = null,
    labelTextLineHeight: CSSLengthOrPercentageNumericValue? = null,
    labelTextPopulatedLineHeight: CSSLengthOrPercentageNumericValue? = null,
    labelTextPopulatedSize: CSSLengthOrPercentageNumericValue? = null,
    labelTextSize: CSSLengthOrPercentageNumericValue? = null,
    labelTextWeight: FontWeight? = null,
    leadingIconColor: CSSColorValue? = null,
    leadingIconSize: CSSLengthOrPercentageNumericValue? = null,
    leadingSpace: CSSLengthOrPercentageNumericValue? = null,
    supportingTextColor: CSSColorValue? = null,
    supportingTextFont: String? = null,
    supportingTextLineHeight: CSSLengthOrPercentageNumericValue? = null,
    supportingTextSize: CSSLengthOrPercentageNumericValue? = null,
    supportingTextWeight: FontWeight? = null,
    topSpace: CSSLengthOrPercentageNumericValue? = null,
    trailingIconColor: CSSColorValue? = null,
    trailingIconSize: CSSLengthOrPercentageNumericValue? = null,
    trailingSpace: CSSLengthOrPercentageNumericValue? = null,
    withLabelBottomSpace: String? = null,
    withLabelTopSpace: String? = null,
) {
    val tag = "filled-text-field"
    BaseTextField(
        tagName = tag,
        value = value,
        onInput = onInput,
        label = label,
        placeholder = placeholder,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        hasLeadingIcon = hasLeadingIcon,
        hasTrailingIcon = hasTrailingIcon,
        type = type,
        autoComplete = autoComplete,
        required = required,
        disabled = disabled,
        error = error,
        errorText = errorText,
        prefixText = prefixText,
        suffixText = suffixText,
        supportingText = supportingText,
        textDirection = textDirection,
        rows = rows,
        cols = cols,
        max = max,
        maxLength = maxLength,
        min = min,
        minLength = minLength,
        pattern = pattern,
        readOnly = readOnly,
        multiple = multiple,
        step = step,
        attrs = Modifier.styleModifier {
            propertyOf("--md-$tag-active-indicator-color", activeIndicatorColor)
            propertyOf("--md-$tag-active-indicator-height", activeIndicatorHeight)
            propertyOf("--md-$tag-bottom-space", bottomSpace)
            propertyOf("--md-$tag-caret-color", caretColor)
            propertyOf("--md-$tag-container-color", containerColor)
            propertyOf("--md-$tag-container-shape", containerShape)
            propertyOf("--md-$tag-container-shape-end-end", containerShapeEndEnd)
            propertyOf("--md-$tag-container-shape-end-start", containerShapeEndStart)
            propertyOf("--md-$tag-container-shape-start-end", containerShapeStartEnd)
            propertyOf("--md-$tag-container-shape-start-start", containerShapeStartStart)
            propertyOf("--md-$tag-disabled-active-indicator-color", disabledActiveIndicatorColor)
            propertyOf("--md-$tag-disabled-active-indicator-height", disabledActiveIndicatorHeight)
            propertyOf("--md-$tag-disabled-active-indicator-opacity", disabledActiveIndicatorOpacity)
            propertyOf("--md-$tag-disabled-container-color", disabledContainerColor)
            propertyOf("--md-$tag-disabled-container-opacity", disabledContainerOpacity)
            propertyOf("--md-$tag-disabled-input-text-color", disabledInputTextColor)
            propertyOf("--md-$tag-disabled-input-text-opacity", disabledInputTextOpacity)
            propertyOf("--md-$tag-disabled-label-text-color", disabledLabelTextColor)
            propertyOf("--md-$tag-disabled-label-text-opacity", disabledLabelTextOpacity)
            propertyOf("--md-$tag-disabled-leading-icon-color", disabledLeadingIconColor)
            propertyOf("--md-$tag-disabled-leading-icon-opacity", disabledLeadingIconOpacity)
            propertyOf("--md-$tag-disabled-supporting-text-color", disabledSupportingTextColor)
            propertyOf("--md-$tag-disabled-supporting-text-opacity", disabledSupportingTextOpacity)
            propertyOf("--md-$tag-disabled-trailing-icon-color", disabledTrailingIconColor)
            propertyOf("--md-$tag-disabled-trailing-icon-opacity", disabledTrailingIconOpacity)
            propertyOf("--md-$tag-error-active-indicator-color", errorActiveIndicatorColor)
            propertyOf("--md-$tag-error-focus-active-indicator-color", errorFocusActiveIndicatorColor)
            propertyOf("--md-$tag-error-focus-caret-color", errorFocusCaretColor)
            propertyOf("--md-$tag-error-focus-input-text-color", errorFocusInputTextColor)
            propertyOf("--md-$tag-error-focus-label-text-color", errorFocusLabelTextColor)
            propertyOf("--md-$tag-error-focus-leading-icon-color", errorFocusLeadingIconColor)
            propertyOf("--md-$tag-error-focus-supporting-text-color", errorFocusSupportingTextColor)
            propertyOf("--md-$tag-error-focus-trailing-icon-color", errorFocusTrailingIconColor)
            propertyOf("--md-$tag-error-hover-active-indicator-color", errorHoverActiveIndicatorColor)
            propertyOf("--md-$tag-error-hover-input-text-color", errorHoverInputTextColor)
            propertyOf("--md-$tag-error-hover-label-text-color", errorHoverLabelTextColor)
            propertyOf("--md-$tag-error-hover-leading-icon-color", errorHoverLeadingIconColor)
            propertyOf("--md-$tag-error-hover-state-layer-color", errorHoverStateLayerColor)
            propertyOf("--md-$tag-error-hover-state-layer-opacity", errorHoverStateLayerOpacity)
            propertyOf("--md-$tag-error-hover-supporting-text-color", errorHoverSupportingTextColor)
            propertyOf("--md-$tag-error-hover-trailing-icon-color", errorHoverTrailingIconColor)
            propertyOf("--md-$tag-error-input-text-color", errorInputTextColor)
            propertyOf("--md-$tag-error-label-text-color", errorLabelTextColor)
            propertyOf("--md-$tag-error-leading-icon-color", errorLeadingIconColor)
            propertyOf("--md-$tag-error-supporting-text-color", errorSupportingTextColor)
            propertyOf("--md-$tag-error-trailing-icon-color", errorTrailingIconColor)
            propertyOf("--md-$tag-focus-active-indicator-color", focusActiveIndicatorColor)
            propertyOf("--md-$tag-focus-active-indicator-height", focusActiveIndicatorHeight)
            propertyOf("--md-$tag-focus-caret-color", focusCaretColor)
            propertyOf("--md-$tag-focus-input-text-color", focusInputTextColor)
            propertyOf("--md-$tag-focus-label-text-color", focusLabelTextColor)
            propertyOf("--md-$tag-focus-leading-icon-color", focusLeadingIconColor)
            propertyOf("--md-$tag-focus-supporting-text-color", focusSupportingTextColor)
            propertyOf("--md-$tag-focus-trailing-icon-color", focusTrailingIconColor)
            propertyOf("--md-$tag-hover-active-indicator-color", hoverActiveIndicatorColor)
            propertyOf("--md-$tag-hover-active-indicator-height", hoverActiveIndicatorHeight)
            propertyOf("--md-$tag-hover-input-text-color", hoverInputTextColor)
            propertyOf("--md-$tag-hover-label-text-color", hoverLabelTextColor)
            propertyOf("--md-$tag-hover-leading-icon-color", hoverLeadingIconColor)
            propertyOf("--md-$tag-hover-state-layer-color", hoverStateLayerColor)
            propertyOf("--md-$tag-hover-state-layer-opacity", hoverStateLayerOpacity)
            propertyOf("--md-$tag-hover-supporting-text-color", hoverSupportingTextColor)
            propertyOf("--md-$tag-hover-trailing-icon-color", hoverTrailingIconColor)
            propertyOf("--md-$tag-input-text-color", inputTextColor)
            propertyOf("--md-$tag-input-text-font", inputTextFont)
            propertyOf("--md-$tag-input-text-line-height", inputTextLineHeight)
            propertyOf("--md-$tag-input-text-placeholder-color", inputTextPlaceholderColor)
            propertyOf("--md-$tag-input-text-prefix-color", inputTextPrefixColor)
            propertyOf("--md-$tag-input-text-prefix-trailing-space", inputTextPrefixTrailingSpace)
            propertyOf("--md-$tag-input-text-size", inputTextSize)
            propertyOf("--md-$tag-input-text-suffix-color", inputTextSuffixColor)
            propertyOf("--md-$tag-input-text-suffix-leading-space", inputTextSuffixLeadingSpace)
            propertyOf("--md-$tag-input-text-weight", inputTextWeight)
            propertyOf("--md-$tag-label-text-color", labelTextColor)
            propertyOf("--md-$tag-label-text-font", labelTextFont)
            propertyOf("--md-$tag-label-text-line-height", labelTextLineHeight)
            propertyOf("--md-$tag-label-text-populated-line-height", labelTextPopulatedLineHeight)
            propertyOf("--md-$tag-label-text-populated-size", labelTextPopulatedSize)
            propertyOf("--md-$tag-label-text-size", labelTextSize)
            propertyOf("--md-$tag-label-text-weight", labelTextWeight)
            propertyOf("--md-$tag-leading-icon-color", leadingIconColor)
            propertyOf("--md-$tag-leading-icon-size", leadingIconSize)
            propertyOf("--md-$tag-leading-space", leadingSpace)
            propertyOf("--md-$tag-supporting-text-color", supportingTextColor)
            propertyOf("--md-$tag-supporting-text-font", supportingTextFont)
            propertyOf("--md-$tag-supporting-text-line-height", supportingTextLineHeight)
            propertyOf("--md-$tag-supporting-text-size", supportingTextSize)
            propertyOf("--md-$tag-supporting-text-weight", supportingTextWeight)
            propertyOf("--md-$tag-top-space", topSpace)
            propertyOf("--md-$tag-trailing-icon-color", trailingIconColor)
            propertyOf("--md-$tag-trailing-icon-size", trailingIconSize)
            propertyOf("--md-$tag-trailing-space", trailingSpace)
            propertyOf("--md-$tag-with-label-bottom-space", withLabelBottomSpace)
            propertyOf("--md-$tag-with-label-top-space", withLabelTopSpace)
        }.toAttrs(attrs)
    )
}

@Composable
fun OutlinedTextField(
    attrs: AttrBuilderContext<MdElement>?,
    value: String,
    onInput: (String) -> Unit,
    label: String? = null,
    type: TextFieldType = TextFieldType.TEXT,
    placeholder: String? = null,
    leadingIcon: (@Composable () -> Unit)? = null,
    trailingIcon: (@Composable () -> Unit)? = null,
    required: Boolean = false,
    disabled: Boolean = false,
    autoComplete: AutoComplete = AutoComplete.off,
    error: Boolean = false,
    errorText: String? = null,
    prefixText: String? = null,
    suffixText: String? = null,
    rows: Int? = null,
    cols: Int? = null,
    max: String? = null,
    maxLength: Int? = null,
    min: String? = null,
    minLength: Int? = null,
    pattern: String? = null,
    readOnly: Boolean = false,
    multiple: Boolean = false,
    step: String? = null,
    hasLeadingIcon: Boolean = false,
    hasTrailingIcon: Boolean = false,
    supportingText: String? = null,
    textDirection: String? = null,
    // Styles
    bottomSpace: CSSLengthOrPercentageNumericValue? = null,
    caretColor: CSSColorValue? = null,
    containerShape: CSSLengthOrPercentageNumericValue? = null,
    containerShapeEndEnd: CSSLengthOrPercentageNumericValue? = null,
    containerShapeEndStart: CSSLengthOrPercentageNumericValue? = null,
    containerShapeStartEnd: CSSLengthOrPercentageNumericValue? = null,
    containerShapeStartStart: CSSLengthOrPercentageNumericValue? = null,
    disabledInputTextColor: CSSColorValue? = null,
    disabledInputTextOpacity: CSSLengthOrPercentageNumericValue? = null,
    disabledLabelTextColor: CSSColorValue? = null,
    disabledLabelTextOpacity: CSSLengthOrPercentageNumericValue? = null,
    disabledLeadingIconColor: CSSColorValue? = null,
    disabledLeadingIconOpacity: CSSLengthOrPercentageNumericValue? = null,
    disabledOutlineColor: CSSColorValue? = null,
    disabledOutlineOpacity: CSSLengthOrPercentageNumericValue? = null,
    disabledOutlineWidth: CSSLengthOrPercentageNumericValue? = null,
    disabledSupportingTextColor: CSSColorValue? = null,
    disabledSupportingTextOpacity: CSSLengthOrPercentageNumericValue? = null,
    disabledTrailingIconColor: CSSColorValue? = null,
    disabledTrailingIconOpacity: CSSLengthOrPercentageNumericValue? = null,
    errorFocusCaretColor: CSSColorValue? = null,
    errorFocusInputTextColor: CSSColorValue? = null,
    errorFocusLabelTextColor: CSSColorValue? = null,
    errorFocusLeadingIconColor: CSSColorValue? = null,
    errorFocusOutlineColor: CSSColorValue? = null,
    errorFocusSupportingTextColor: CSSColorValue? = null,
    errorFocusTrailingIconColor: CSSColorValue? = null,
    errorHoverInputTextColor: CSSColorValue? = null,
    errorHoverLabelTextColor: CSSColorValue? = null,
    errorHoverLeadingIconColor: CSSColorValue? = null,
    errorHoverOutlineColor: CSSColorValue? = null,
    errorHoverSupportingTextColor: CSSColorValue? = null,
    errorHoverTrailingIconColor: CSSColorValue? = null,
    errorInputTextColor: CSSColorValue? = null,
    errorLabelTextColor: CSSColorValue? = null,
    errorLeadingIconColor: CSSColorValue? = null,
    errorOutlineColor: CSSColorValue? = null,
    errorSupportingTextColor: CSSColorValue? = null,
    errorTrailingIconColor: CSSColorValue? = null,
    focusCaretColor: CSSColorValue? = null,
    focusInputTextColor: CSSColorValue? = null,
    focusLabelTextColor: CSSColorValue? = null,
    focusLeadingIconColor: CSSColorValue? = null,
    focusOutlineColor: CSSColorValue? = null,
    focusOutlineWidth: Width? = null,
    focusSupportingTextColor: CSSColorValue? = null,
    focusTrailingIconColor: CSSColorValue? = null,
    hoverInputTextColor: CSSColorValue? = null,
    hoverLabelTextColor: CSSColorValue? = null,
    hoverLeadingIconColor: CSSColorValue? = null,
    hoverOutlineColor: CSSColorValue? = null,
    hoverOutlineWidth: Width? = null,
    hoverSupportingTextColor: CSSColorValue? = null,
    hoverTrailingIconColor: CSSColorValue? = null,
    inputTextColor: CSSColorValue? = null,
    inputTextFont: String? = null,
    inputTextLineHeight: CSSLengthOrPercentageNumericValue? = null,
    inputTextPlaceholderColor: CSSColorValue? = null,
    inputTextPrefixColor: CSSColorValue? = null,
    inputTextPrefixTrailingSpace: CSSLengthOrPercentageNumericValue? = null,
    inputTextSize: CSSLengthOrPercentageNumericValue? = null,
    inputTextSuffixColor: CSSColorValue? = null,
    inputTextSuffixLeadingSpace: CSSLengthOrPercentageNumericValue? = null,
    inputTextWeight: FontWeight? = null,
    labelTextColor: CSSColorValue? = null,
    labelTextFont: String? = null,
    labelTextLineHeight: CSSLengthOrPercentageNumericValue? = null,
    labelTextPopulatedLineHeight: CSSLengthOrPercentageNumericValue? = null,
    labelTextPopulatedSize: CSSLengthOrPercentageNumericValue? = null,
    labelTextSize: CSSLengthOrPercentageNumericValue? = null,
    labelTextWeight: FontWeight? = null,
    leadingIconColor: CSSColorValue? = null,
    leadingIconSize: CSSLengthOrPercentageNumericValue? = null,
    leadingSpace: CSSLengthOrPercentageNumericValue? = null,
    outlineColor: CSSColorValue? = null,
    outlineWidth: Width? = null,
    supportingTextColor: CSSColorValue? = null,
    supportingTextFont: String? = null,
    supportingTextLineHeight: CSSLengthOrPercentageNumericValue? = null,
    supportingTextSize: CSSLengthOrPercentageNumericValue? = null,
    supportingTextWeight: FontWeight? = null,
    topSpace: CSSLengthOrPercentageNumericValue? = null,
    trailingIconColor: CSSColorValue? = null,
    trailingIconSize: CSSLengthOrPercentageNumericValue? = null,
    trailingSpace: CSSLengthOrPercentageNumericValue? = null,
) {
    val tag = "outlined-text-field"
    BaseTextField(
        tagName = tag,
        value = value,
        onInput = onInput,
        label = label,
        placeholder = placeholder,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        hasLeadingIcon = hasLeadingIcon,
        hasTrailingIcon = hasTrailingIcon,
        type = type,
        autoComplete = autoComplete,
        required = required,
        disabled = disabled,
        error = error,
        errorText = errorText,
        prefixText = prefixText,
        suffixText = suffixText,
        supportingText = supportingText,
        textDirection = textDirection,
        rows = rows,
        cols = cols,
        max = max,
        maxLength = maxLength,
        min = min,
        minLength = minLength,
        pattern = pattern,
        readOnly = readOnly,
        multiple = multiple,
        step = step,
        attrs = Modifier.styleModifier {
            propertyOf("--md-$tag-bottom-space", bottomSpace)
            propertyOf("--md-$tag-caret-color", caretColor)
            propertyOf("--md-$tag-container-shape", containerShape)
            propertyOf("--md-$tag-container-shape-end-end", containerShapeEndEnd)
            propertyOf("--md-$tag-container-shape-end-start", containerShapeEndStart)
            propertyOf("--md-$tag-container-shape-start-end", containerShapeStartEnd)
            propertyOf("--md-$tag-container-shape-start-start", containerShapeStartStart)
            propertyOf("--md-$tag-disabled-input-text-color", disabledInputTextColor)
            propertyOf("--md-$tag-disabled-input-text-opacity", disabledInputTextOpacity)
            propertyOf("--md-$tag-disabled-label-text-color", disabledLabelTextColor)
            propertyOf("--md-$tag-disabled-label-text-opacity", disabledLabelTextOpacity)
            propertyOf("--md-$tag-disabled-leading-icon-color", disabledLeadingIconColor)
            propertyOf("--md-$tag-disabled-leading-icon-opacity", disabledLeadingIconOpacity)
            propertyOf("--md-$tag-disabled-outline-color", disabledOutlineColor)
            propertyOf("--md-$tag-disabled-outline-opacity", disabledOutlineOpacity)
            propertyOf("--md-$tag-disabled-outline-width", disabledOutlineWidth)
            propertyOf("--md-$tag-disabled-supporting-text-color", disabledSupportingTextColor)
            propertyOf("--md-$tag-disabled-supporting-text-opacity", disabledSupportingTextOpacity)
            propertyOf("--md-$tag-disabled-trailing-icon-color", disabledTrailingIconColor)
            propertyOf("--md-$tag-disabled-trailing-icon-opacity", disabledTrailingIconOpacity)
            propertyOf("--md-$tag-error-focus-caret-color", errorFocusCaretColor)
            propertyOf("--md-$tag-error-focus-input-text-color", errorFocusInputTextColor)
            propertyOf("--md-$tag-error-focus-label-text-color", errorFocusLabelTextColor)
            propertyOf("--md-$tag-error-focus-leading-icon-color", errorFocusLeadingIconColor)
            propertyOf("--md-$tag-error-focus-outline-color", errorFocusOutlineColor)
            propertyOf("--md-$tag-error-focus-supporting-text-color", errorFocusSupportingTextColor)
            propertyOf("--md-$tag-error-focus-trailing-icon-color", errorFocusTrailingIconColor)
            propertyOf("--md-$tag-error-hover-input-text-color", errorHoverInputTextColor)
            propertyOf("--md-$tag-error-hover-label-text-color", errorHoverLabelTextColor)
            propertyOf("--md-$tag-error-hover-leading-icon-color", errorHoverLeadingIconColor)
            propertyOf("--md-$tag-error-hover-outline-color", errorHoverOutlineColor)
            propertyOf("--md-$tag-error-hover-supporting-text-color", errorHoverSupportingTextColor)
            propertyOf("--md-$tag-error-hover-trailing-icon-color", errorHoverTrailingIconColor)
            propertyOf("--md-$tag-error-input-text-color", errorInputTextColor)
            propertyOf("--md-$tag-error-label-text-color", errorLabelTextColor)
            propertyOf("--md-$tag-error-leading-icon-color", errorLeadingIconColor)
            propertyOf("--md-$tag-error-outline-color", errorOutlineColor)
            propertyOf("--md-$tag-error-supporting-text-color", errorSupportingTextColor)
            propertyOf("--md-$tag-error-trailing-icon-color", errorTrailingIconColor)
            propertyOf("--md-$tag-focus-caret-color", focusCaretColor)
            propertyOf("--md-$tag-focus-input-text-color", focusInputTextColor)
            propertyOf("--md-$tag-focus-label-text-color", focusLabelTextColor)
            propertyOf("--md-$tag-focus-leading-icon-color", focusLeadingIconColor)
            propertyOf("--md-$tag-focus-outline-color", focusOutlineColor)
            propertyOf("--md-$tag-focus-outline-width", focusOutlineWidth)
            propertyOf("--md-$tag-focus-supporting-text-color", focusSupportingTextColor)
            propertyOf("--md-$tag-focus-trailing-icon-color", focusTrailingIconColor)
            propertyOf("--md-$tag-hover-input-text-color", hoverInputTextColor)
            propertyOf("--md-$tag-hover-label-text-color", hoverLabelTextColor)
            propertyOf("--md-$tag-hover-leading-icon-color", hoverLeadingIconColor)
            propertyOf("--md-$tag-hover-outline-color", hoverOutlineColor)
            propertyOf("--md-$tag-hover-outline-width", hoverOutlineWidth)
            propertyOf("--md-$tag-hover-supporting-text-color", hoverSupportingTextColor)
            propertyOf("--md-$tag-hover-trailing-icon-color", hoverTrailingIconColor)
            propertyOf("--md-$tag-input-text-color", inputTextColor)
            propertyOf("--md-$tag-input-text-font", inputTextFont)
            propertyOf("--md-$tag-input-text-line-height", inputTextLineHeight)
            propertyOf("--md-$tag-input-text-placeholder-color", inputTextPlaceholderColor)
            propertyOf("--md-$tag-input-text-prefix-color", inputTextPrefixColor)
            propertyOf("--md-$tag-input-text-prefix-trailing-space", inputTextPrefixTrailingSpace)
            propertyOf("--md-$tag-input-text-size", inputTextSize)
            propertyOf("--md-$tag-input-text-suffix-color", inputTextSuffixColor)
            propertyOf("--md-$tag-input-text-suffix-leading-space", inputTextSuffixLeadingSpace)
            propertyOf("--md-$tag-input-text-weight", inputTextWeight)
            propertyOf("--md-$tag-label-text-color", labelTextColor)
            propertyOf("--md-$tag-label-text-font", labelTextFont)
            propertyOf("--md-$tag-label-text-line-height", labelTextLineHeight)
            propertyOf("--md-$tag-label-text-populated-line-height", labelTextPopulatedLineHeight)
            propertyOf("--md-$tag-label-text-populated-size", labelTextPopulatedSize)
            propertyOf("--md-$tag-label-text-size", labelTextSize)
            propertyOf("--md-$tag-label-text-weight", labelTextWeight)
            propertyOf("--md-$tag-leading-icon-color", leadingIconColor)
            propertyOf("--md-$tag-leading-icon-size", leadingIconSize)
            propertyOf("--md-$tag-leading-space", leadingSpace)
            propertyOf("--md-$tag-outline-color", outlineColor)
            propertyOf("--md-$tag-outline-width", outlineWidth)
            propertyOf("--md-$tag-supporting-text-color", supportingTextColor)
            propertyOf("--md-$tag-supporting-text-font", supportingTextFont)
            propertyOf("--md-$tag-supporting-text-line-height", supportingTextLineHeight)
            propertyOf("--md-$tag-supporting-text-size", supportingTextSize)
            propertyOf("--md-$tag-supporting-text-weight", supportingTextWeight)
            propertyOf("--md-$tag-top-space", topSpace)
            propertyOf("--md-$tag-trailing-icon-color", trailingIconColor)
            propertyOf("--md-$tag-trailing-icon-size", trailingIconSize)
            propertyOf("--md-$tag-trailing-space", trailingSpace)
        }.toAttrs(attrs)
    )
}
