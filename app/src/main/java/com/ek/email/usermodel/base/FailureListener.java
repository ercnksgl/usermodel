package com.ek.email.usermodel.base;

public interface FailureListener {
    void getFailure();
    void onGetError(String error, boolean isError, Class toClass);
}
