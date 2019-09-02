package com.unionbankph.hrxmobility.presentation.util

import android.content.res.Resources
import android.widget.Button
import com.unionbankph.hrxmobility.R

class TabUtil {

    companion object {

        public fun toggleTab(pos: String, clickedBtn: Button, offBtn : Button, res: Resources) {

            when(pos){
                "left" -> {
                    // ON
                    clickedBtn.setTextColor(res.getColor(R.color.white_color))
                    clickedBtn.setBackgroundDrawable(res.getDrawable(R.drawable.ub_button_left_primary_bg))
                    // OFF
                    offBtn.setTextColor(res.getColor(R.color.lightGray))
                    offBtn.setBackgroundDrawable(res.getDrawable(R.drawable.ub_button_right_bg))
                }
                "right" -> {
                    // ON
                    clickedBtn.setTextColor(res.getColor(R.color.white_color))
                    clickedBtn.setBackgroundDrawable(res.getDrawable(R.drawable.ub_button_right_primary_bg))
                    // OFF
                    offBtn.setTextColor(res.getColor(R.color.lightGray))
                    offBtn.setBackgroundDrawable(res.getDrawable(R.drawable.ub_button_left_bg))
                }
            }

        }

        const val RIGHT = "right"
        const val LEFT = "left"
    }

}