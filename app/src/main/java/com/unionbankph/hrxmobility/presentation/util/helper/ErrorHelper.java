package com.unionbankph.hrxmobility.presentation.util.helper;

public abstract class ErrorHelper<T extends Exception> {

    private final T mThrowable;

    ErrorHelper(T throwable) {
        mThrowable = throwable;
    }

    public abstract String getErrorMessage();

    T getThrowable() {
        return mThrowable;
    }
}
