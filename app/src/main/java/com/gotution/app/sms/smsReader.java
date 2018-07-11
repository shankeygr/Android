package com.gotution.app.sms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;

import com.gotution.app.Login;
import com.gotution.app.auth.Verification;
import com.gotution.app.interfaces.CustomListener;
import com.gotution.app.interfaces.RetroErrorListener;
import com.gotution.app.networking.ApiManager;
import com.gotution.app.utils.CommonLib;

import java.io.IOException;
import java.util.Map;

public class smsReader extends BroadcastReceiver {
    private static final String LOG_TAG = smsReader.class.getSimpleName ();
    private String senderTag;
    private ApiManager apiManager = new ApiManager ();
    private String requestCode;
    private String mPhoneNumber;
    private static final int maxOtpLength = 5;

    public boolean checkSenderNumberValid(String senderNum){
        if (senderNum == null)
            return false;
        return (senderNum.contains(senderTag));
    }

    public void getData() {

            apiManager.verifyPhone(requestCode, mPhoneNumber, new CustomListener<Verification> () {
                @Override
                public void onResponse(Verification verification, Map headers, String apiUrl) {
                    verifyPhoneCallback.onSuccessResponse(verification, apiUrl);
                }
            }, new RetroErrorListener () {
                @Override
                public void onErrorResponse(Throwable t) {

                }

                @Override
                public void onErrorResponse(Object response, int statusCode, Map headers, String apiUrl) {

                }
            });
        }
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        final Bundle bundle = intent.getExtras();
        try {
            if (bundle != null) {
                final Object[] pdusObj = (Object[]) bundle.get("pdus");

                for (Object aPdusObj : pdusObj) {
                    SmsMessage currentMessage = SmsMessage.createFromPdu((byte[]) aPdusObj);
                    String senderNum = currentMessage.getDisplayOriginatingAddress();

                    String message = currentMessage.getDisplayMessageBody();

                    if (checkSenderNumberValid(senderNum)) {
                        message = message.replaceAll("\\D+", "");
                        if(message.length() > maxOtpLength){
                            message = message.substring(0, maxOtpLength);
                        }
                        if (message != null) {
                            requestCode = message;
                            getData();
                        }
                    }
                }
            }
        } catch (Exception exception) {

        }
    }

}
