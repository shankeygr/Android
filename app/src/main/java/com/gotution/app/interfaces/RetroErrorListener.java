package com.gotution.app.interfaces;

import java.util.Map;

public interface RetroErrorListener<T> {
    void onErrorResponse(Throwable t);

    void onErrorResponse(T response, int statusCode, Map<String, String> headers, String apiUrl);
}

