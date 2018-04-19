package com.thieumao.changedkeyboardevent

import android.app.Fragment
import android.graphics.Rect
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import kotlinx.android.synthetic.main.fragment_main.*

/**
 * Created by Thieu Mao on 4/19/18.
 */
class MainFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        listenKeyboardChanged()
    }

    private fun listenKeyboardChanged() {
        root_layout.getViewTreeObserver().addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
            override fun onGlobalLayout() {
                val screenHeight = root_layout.rootView.height
                val rect = Rect()
                activity.window.decorView.getWindowVisibleDisplayFrame(rect)
                val keyboardHeight = screenHeight - rect.bottom - getActionBarHeight()
                val isShowKeyboard = keyboardHeight > CommonUtils.MIN_KEYBOARD_HEIGHT_PX
                updateUI(keyboardHeight, isShowKeyboard)
            }
        })
    }

    private fun updateUI(keyboardHeight: Int, isShow: Boolean) {
        space_view.visibility = if (isShow) View.INVISIBLE else View.GONE

        var layoutParams = space_view.layoutParams
        layoutParams.height = keyboardHeight
        space_view.layoutParams = layoutParams
    }

    private fun getActionBarHeight(): Int {
        val styledAttributes = activity.getTheme().obtainStyledAttributes(intArrayOf(android.R.attr.actionBarSize))
        val actionBarHeight = styledAttributes.getDimension(0, 0f).toInt()
        styledAttributes.recycle()
        return actionBarHeight
    }

    companion object {
        fun newInstance(): MainFragment {
            val fragment = MainFragment()
            return fragment
        }
    }
}