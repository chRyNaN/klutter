package com.chrynan.klutter.services

typealias TextInputFormatFunction = (oldValue: TextEditingValue, newValue: TextEditingValue) -> TextEditingValue

abstract class TextInputFormatter {

    abstract fun formatEditUpdate(oldValue: TextEditingValue, newValue: TextEditingValue): TextEditingValue
}

class SimpleTextInputFormatter(private val formatFunction: TextInputFormatFunction) : TextInputFormatter() {

    override fun formatEditUpdate(oldValue: TextEditingValue, newValue: TextEditingValue) =
        formatFunction.invoke(oldValue, newValue)
}

class BlacklistingTextInputFormatter(
    // TODO val blacklistedPattern: Pattern,
    val replacementString: String
) : TextInputFormatter(){

    override fun formatEditUpdate(oldValue: TextEditingValue, newValue: TextEditingValue): TextEditingValue {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

class LengthLimitingTextInputFormatter(val maxLength: Int) : TextInputFormatter(){

    override fun formatEditUpdate(oldValue: TextEditingValue, newValue: TextEditingValue): TextEditingValue {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

class WhitelistingTextInputFormatter(
    // TODO val whitelistedPattern: Pattern
): TextInputFormatter() {

    override fun formatEditUpdate(oldValue: TextEditingValue, newValue: TextEditingValue): TextEditingValue {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}