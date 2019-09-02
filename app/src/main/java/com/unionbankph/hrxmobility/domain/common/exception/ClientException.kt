package com.unionbankph.hrx.domain.common.exception

class ClientException : Exception {

    constructor() {}

    constructor(message: String) : super(message) {}

    constructor(message: String, cause: Throwable) : super(message, cause) {}
}
