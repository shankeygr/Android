package com.gotution.app.auth;

import com.google.gson.annotations.SerializedName;

public class Verification {
    private String access_token;
    private String message;
    private boolean success;
    private User user;
    private boolean verified;

    @SerializedName("user_profile_data")
    private UserAttributes userAttributes;

    public boolean isSuccess() {
        return success;
    }

    public boolean isVerified() {
        return verified;
    }
}
