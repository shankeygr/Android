package com.gotution.app.models;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NumberVerification {
    //private String action;
    //private boolean login;
    @SerializedName("message")
    private String message;

    @SerializedName("success")
    private boolean success;
    //@SerializedName("sms_sent")
    //private boolean smsSent;
}
