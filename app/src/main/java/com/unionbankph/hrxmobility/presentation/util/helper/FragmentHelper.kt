package com.unionbankph.hrxmobility.presentation.util.helper

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.unionbankph.hrxmobility.R
import com.unionbankph.hrxmobility.presentation.base.BaseFragment
import com.unionbankph.hrxmobility.presentation.base.BasePresenter
import com.unionbankph.hrxmobility.presentation.base.MvpView

class FragmentHelper {

    companion object {
        fun setupFragment(fragmentManager: FragmentManager, baseFragment: Fragment, frameLayoutId: Int) {
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(frameLayoutId, baseFragment)
            fragmentTransaction.commitNow()
        }

        fun loadNavigationScreen(fm: FragmentManager, fragment: Fragment) {
            val transaction = fm.beginTransaction()
            transaction.replace(R.id.frame_container, fragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }

    }

}
