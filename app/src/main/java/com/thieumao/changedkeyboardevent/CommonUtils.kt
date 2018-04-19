package com.thieumao.changedkeyboardevent

import android.content.res.Resources

/**
 * Created by Thieu Mao on 4/19/18.
 */
class CommonUtils {

    companion object {

        val MIN_KEYBOARD_HEIGHT_PX = 150

        fun dpToPx(dp: Int): Int {
            return (dp * Resources.getSystem().displayMetrics.density).toInt()
        }
    }
}
