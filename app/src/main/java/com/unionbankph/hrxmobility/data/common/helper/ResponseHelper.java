package com.unionbankph.hrxmobility.data.common.helper;

import com.google.gson.Gson;
import com.unionbankph.hrxmobility.data.common.service.ServiceOperator;
import io.reactivex.SingleTransformer;
import io.reactivex.annotations.NonNull;
import retrofit2.Response;

public class ResponseHelper {

    private final Gson mGson;

    public ResponseHelper(@NonNull Gson gson) {
        mGson = gson;
    }

    public <T> SingleTransformer<Response<T>, T> errorHandler() {
        return upstream -> upstream
                .lift(new ServiceOperator<>(mGson))
                .retry(ApiConnectionHelper.RETRY_COUNT, new ApiConnectionHelper<>());
    }
}
