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
import com.unionbankph.hrxmobility.presentation.base.FastAdapterItem
import kotlinx.android.synthetic.main.expanding_dtr.view.*
import kotlinx.android.synthetic.main.item_dtr_info.view.*
import kotlinx.android.synthetic.main.item_dtr_info_breaks.view.*

class DtrAdapterItem (val context: Context, dtr: WeeklyDtr)
    : FastAdapterItem<WeeklyDtr, DtrAdapterItem, DtrAdapterItem.ViewHolder>(dtr)
{

    private val STATUS_PRESENT = "Present"

    override fun getType(): Int = R.id.dtr_report_item

    override fun getViewHolder(v: View): ViewHolder {
        return ViewHolder(v)
    }

    override fun getLayoutRes(): Int = R.layout.expanding_dtr_item

    override fun bindView(holder: ViewHolder, payloads: MutableList<Any>) {
        super.bindView(holder, payloads)

        holder.time_day.text = model.dayOfWeekName
        holder.time_in.text = if(model.timeIn.equals("")) "00:00" else model.timeIn
        holder.time_out.text = if(model.timeOut.equals("")) "00:00" else model.timeOut
        holder.tv_time_day_name.text = model.dayOfWeek
        holder.tv_record_type.text = STATUS_PRESENT

    }

    inner class ViewHolder(item: View) : RecyclerView.ViewHolder(item){
        var time_day = item.tv_time_day
        var time_in = item.tv_time_in_info
        var time_out = item.tv_time_out_info
        var tv_time_day_name = item.tv_time_day_name
        var tv_record_type = item.tv_record_type
    }

}