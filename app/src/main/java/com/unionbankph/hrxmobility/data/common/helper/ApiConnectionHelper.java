package com.unionbankph.hrxmobility.data.common.helper;

import com.unionbankph.hrxmobility.domain.common.exception.UnhandledStatusException;
import io.reactivex.functions.Predicate;

import javax.net.ssl.HttpsURLConnection;

/**
 * Retry api call if responded with 502 BAD GATEWAY status.
 */
public class ApiConnectionHelper<T> implements Predicate<T> {

    public static final int RETRY_COUNT = 3;

    @Override
    public boolean test(T t) {
        if (t instanceof UnhandledStatusException) {
            UnhandledStatusException exception = (UnhandledStatusException) t;

            return exception.getCode() == HttpsURLConnection.HTTP_BAD_GATEWAY;
        }

        return false;
    }
}
