package by.vlfl.fxsuperpro.utils

import android.text.InputFilter
import android.text.SpannableString
import android.text.Spanned
import android.text.TextUtils

class CharFilter(private val chars: String): InputFilter {
    override fun filter(source: CharSequence, start: Int, end: Int, dest: Spanned?, dstart: Int, dend: Int): CharSequence? {
        val sb = StringBuilder(end - start)
        var keepOriginal = true

        (start until end).forEach { index ->
            val char = source[index]
            if (char in chars) {
                sb.append(char)
            } else {
                keepOriginal = false
            }
        }

        return if (keepOriginal) {
            null
        } else {
            if (source is Spanned) {
                val sp = SpannableString(sb)
                TextUtils.copySpansFrom(source, start, sb.length, null, sp, 0)
                sp
            } else {
                sb
            }
        }
    }
}