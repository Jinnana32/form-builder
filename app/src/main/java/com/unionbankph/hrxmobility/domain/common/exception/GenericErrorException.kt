package com.unionbankph.hrx.domain.common.exception

import com.unionbankph.hrxmobility.domain.common.exception.ErrorResp
import com.unionbankph.hrxmobility.domain.common.exception.ErrorsItem
import io.reactivex.annotations.NonNull


class GenericErrorException(@param:NonNull val errorResp: ErrorsItem) : Exception()
