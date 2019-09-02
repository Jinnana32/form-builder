package com.unionbankph.hrxmobility.presentation.base

import androidx.recyclerview.widget.RecyclerView
import com.mikepenz.fastadapter.items.ModelAbstractItem


abstract class FastAdapterItem<M, T : ModelAbstractItem<*, *, *>, VH : RecyclerView.ViewHolder>(m: M) :
    ModelAbstractItem<M, T, VH>(m) {

    var headerId: Long = 0
        private set
    var header: String? = null
        private set

    fun withHeader(header: String): T {
        this.header = header
        return this as T
    }

    fun withHeaderId(headerId: Long): T {
        this.headerId = headerId
        return this as T
    }
}
