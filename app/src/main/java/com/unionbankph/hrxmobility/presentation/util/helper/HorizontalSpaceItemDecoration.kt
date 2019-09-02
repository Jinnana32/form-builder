package com.unionbankph.hrxmobility.presentation.util.helper

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class HorizontalSpaceItemDecoration @JvmOverloads
constructor(private val mHorizontalSpaceWidth: Int, private val mSpaceLastItemRight: Boolean = false) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView,
                                state: RecyclerView.State) {
        if (parent.getChildAdapterPosition(view) != parent.adapter?.itemCount?.minus(1) ?: 0 || mSpaceLastItemRight) {
            outRect.right = mHorizontalSpaceWidth
        }
    }
}