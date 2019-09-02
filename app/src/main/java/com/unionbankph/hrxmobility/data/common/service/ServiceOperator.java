package com.unionbankph.hrxmobility.data.common.service;

import android.util.Log;
import com.google.gson.Gson;
import com.ubx.identity.domain.common.exception.NoNetworkException;
import com.unionbankph.hrx.domain.common.exception.ClientException;
import com.unionbankph.hrx.domain.common.exception.ForbiddenRequestException;
import com.unionbankph.hrx.domain.common.exception.GenericErrorException;
import com.unionbankph.hrx.domain.common.exception.ServerException;
import com.unionbankph.hrxmobility.domain.common.exception.ErrResponse;
import com.unionbankph.hrxmobility.domain.common.exception.ErrorResp;
import com.unionbankph.hrxmobility.domain.common.exception.ErrorsItem;
import com.unionbankph.hrxmobility.domain.common.exception.UnhandledStatusException;
import io.reactivex.SingleObserver;
import io.reactivex.SingleOperator;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import retrofit2.Response;

import javax.net.ssl.HttpsURLConnection;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Objects;


public final class ServiceOperator<T> implements SingleOperator<T, Response<T>> {

    private final Gson mGson;

    public ServiceOperator(@NonNull Gson gson) {
        mGson = gson;
    }

    @Override
    public SingleObserver<? super Response<T>> apply(SingleObserver<? super T> observer) {
        return new SingleObserver<Response<T>>() {

            @Override
            public void onSubscribe(Disposable d) {
                observer.onSubscribe(d);
            }

            @Override
            public void onSuccess(Response<T> response) {
                try {
                    int code = response.code();

                    if (code == HttpsURLConnection.HTTP_OK || code == HttpsURLConnection.HTTP_CREATED || code == HttpsURLConnection.HTTP_ACCEPTED) {
                        observer.onSuccess(response.body());
                    } else if (code == HttpsURLConnection.HTTP_BAD_REQUEST) {
                        assert response.errorBody() != null;
                        ErrResponse errorResp = mGson.fromJson(response.errorBody().string(), ErrResponse.class);
                        Log.e("errr", errorResp.toString());
                        observer.onError(new GenericErrorException(Objects.requireNonNull(errorResp.getError())));
                    } else if (code == HttpsURLConnection.HTTP_UNAUTHORIZED) {
                        observer.onError(new ForbiddenRequestException());
                    } else {
                        String message = "It seems that we've encountered a problem. Status: " + code;

                        observer.onError(new UnhandledStatusException(message, code));
                    }
                } catch (Exception e) {
                    String message = "It seems that we've encountered a problem. Error: " + e.getClass().getSimpleName();

                    observer.onError(new ServerException(message, e));
                } finally {
                    if (response.errorBody() != null) {
                        response.errorBody().close();
                    }
                }
            }

            @Override
            public void onError(Throwable e) {
                if (e instanceof SocketException
                        || e instanceof SocketTimeoutException
                        || e instanceof UnknownHostException
                        || e instanceof NoNetworkException) {
                    String message = "It seems that you don't have internet connection. " +
                            "Please check your network settings and try again later.";
                    observer.onError(new ClientException(message, e));
                } else {
                    String message = "It seems that we've encountered a problem. Error: " + e.getClass().getSimpleName();
                    observer.onError(new ClientException(message, e));
                }
            }

        };

    }
}
