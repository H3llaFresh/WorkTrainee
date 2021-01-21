package by.vlfl.fxsuperpro.ui

import android.text.InputFilter
import by.vlfl.fxsuperpro.utils.CharFilter

val latinCharInputFilter: Array<InputFilter>
    get() = arrayOf(
        CharFilter(" !\"#\$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~")
    )
