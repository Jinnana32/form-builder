package com.unionbankph.hrxmobility.domain.common.exception

import com.unionbankph.hrx.domain.common.exception.ServerException
import io.reactivex.annotations.NonNull

class UnhandledStatusException(
    @NonNull message: String,
    val code: Int
) : ServerException(message)
