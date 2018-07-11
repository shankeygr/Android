package com.gotution.app.interfaces;

import java.util.Map;

public interface CustomListener<T> {
    void onResponse(T response, Map<String, String> headers, String apiUrl);
}
