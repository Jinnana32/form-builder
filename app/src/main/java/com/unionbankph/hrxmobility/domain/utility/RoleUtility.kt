package com.unionbankph.hrxmobility.domain.utility

import com.unionbankph.hrxmobility.domain.respository.enums.Roles

object RoleUtility {

    val ADMIN_IDS = intArrayOf(1, 2, 3, 4)

    fun getRole(isLineManager: Boolean?): Roles {
        if (isLineManager!!) {
            return Roles.LINE_MANAGER
        }
        return Roles.EMPLOYEE
    }

}