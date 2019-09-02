package com.unionbankph.hrxmobility.presentation.common.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.mikepenz.fastadapter.commons.adapters.FastItemAdapter
import com.unionbankph.hrxmobility.R
import com.unionbankph.hrxmobility.domain.model.WeeklyDtr
import com.unionbankph.hrxmobility.domain.resp.TemplateResp
import com.unionbankph.hrxmobility.presentation.base.FastAdapterItem
import kotlinx.android.synthetic.main.expanding_dtr.view.*
import kotlinx.android.synthetic.main.form_template_item.view.*
import kotlinx.android.synthetic.main.item_dtr_info.view.*
import kotlinx.android.synthetic.main.item_dtr_info_breaks.view.*

class FormTemplateAdapterItem (template: TemplateResp)
    : FastAdapterItem<TemplateResp, FormTemplateAdapterItem, FormTemplateAdapterItem.ViewHolder>(template)
{

    private val STATUS_PRESENT = "Present"

    override fun getType(): Int = R.id.dtr_report_item

    override fun getViewHolder(v: View): ViewHolder {
        return ViewHolder(v)
    }

    override fun getLayoutRes(): Int = R.layout.form_template_item

    override fun bindView(holder: ViewHolder, payloads: MutableList<Any>) {
        super.bindView(holder, payloads)

        holder.tv_form_title.text = model.label

    }

    inner class ViewHolder(item: View) : RecyclerView.ViewHolder(item){
        val tv_form_title = item.tv_form_title
    }

}