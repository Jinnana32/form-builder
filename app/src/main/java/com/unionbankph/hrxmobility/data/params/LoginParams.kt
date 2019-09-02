package com.unionbankph.hrxmobility.data.params

data class LoginParams(val username: String, val password: String) {

    companion object {
        fun createEmpty(): LoginParams {
            return LoginParams("", "")
        }
    }
}