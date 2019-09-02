package com.unionbankph.hrxmobility.domain.respository

interface DeviceRepository {

    fun setUserId(user_id: String)

    fun getUserId() : String

    fun setName(name: String)

    fun getName() : String

    fun isLogin() : Boolean

    fun setIsLogin(isLogin: String)

    fun removeIsLogin()

}