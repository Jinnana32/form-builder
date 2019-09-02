package com.unionbankph.hrxmobility.data.impl

import com.unionbankph.hrxmobility.data.service.LocalStorageService
import com.unionbankph.hrxmobility.domain.respository.DeviceRepository

class DeviceRepositoryImpl(val service: LocalStorageService) : DeviceRepository {

    companion object {
        val USER_ID = "USER_ID"
        val USER_NAME = "USER_NAME"
        val USER_IS_LOGIN = "USER_IS_LOGIN"
    }

    override fun setUserId(user_id: String) {
        service.saveKey(USER_ID, user_id)
    }

    override fun getUserId(): String {
        return service.getKey(USER_ID)
    }

    override fun getName(): String {
        return service.getKey(USER_NAME)
    }

    override fun setName(name: String) {
       service.saveKey(USER_NAME, name)
    }

    override fun isLogin(): Boolean {
        return service.getKey(USER_IS_LOGIN).isNotEmpty()
    }

    override fun removeIsLogin() {
        service.saveKey(USER_IS_LOGIN, "")
    }

    override fun setIsLogin(isLogin: String) {
        service.saveKey(USER_IS_LOGIN, isLogin)
    }

}