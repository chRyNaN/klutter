package com.chrynan.klutter.foundation

data class TextTreeConfiguration(
    val prefixLineOne: String,
    val prefixOtherLines: String,
    val prefixLastChildLineOne: String,
    val prefixOtherLinesRootNode: String,
    val propertyPrefixIfChildren: String,
    val propertyPrefixNoChildren: String,
    val linkCharacter: String,
    val childLinkSpace: String = "",
    val lineBreak: String = "\n",
    val lineBreakProperties: Boolean = true,
    val afterName: String = ":",
    val afterDescriptionIfBody: String = "",
    val beforeProperties: String = "",
    val afterProperties: String = "",
    val propertySeparator: String = "",
    val bodyIndent: String = "",
    val showChildren: Boolean = true,
    val addBlankLineIfNoChildren: Boolean = true,
    val isNameOnOwnLine: Boolean = false,
    val footer: String = "",
    val isBlankLineBetweenPropertiesAndChildren: Boolean = true
) {

    companion object {

        val SPARSE_TEXT_CONFIGURATION = TextTreeConfiguration(
            prefixLineOne = "|--",
            prefixOtherLines = " ",
            prefixLastChildLineOne = "|--",
            linkCharacter = "|",
            propertyPrefixIfChildren = "| ",
            propertyPrefixNoChildren = "  ",
            prefixOtherLinesRootNode = " "
        )
    }
}