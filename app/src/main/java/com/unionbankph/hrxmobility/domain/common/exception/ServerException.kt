package com.unionbankph.hrx.domain.common.exception

import io.reactivex.annotations.NonNull

open class ServerException : Exception {

    constructor(@NonNull message: String) : super(message) {}

    constructor(@NonNull message: String,
                @NonNull cause: Throwable) : super(message, cause) {
    }
}
