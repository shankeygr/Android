package com.gotution.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.gotution.app.customviews.CustomToastView;
import com.gotution.app.customviews.EditTextRegularFont;
import com.gotution.app.interfaces.CustomListener;
import com.gotution.app.interfaces.RetroErrorListener;
import com.gotution.app.models.NumberVerification;
import com.gotution.app.networking.ApiManager;
import com.gotution.app.utils.Api;
import com.gotution.app.utils.CommonLib;
import com.gotution.app.utils.PermissionUtils;
import com.gotution.gotution.R;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity {

    private static final String LOG_TAG = Login.class.getSimpleName ();
    private static Context sContext;
    private static Context activityContext;
    private EditText phoneNum;
    private ApiManager apiManager = new ApiManager ();
    private boolean smsSent;
    private String mPhoneNumber;
    private TextView countryCode;
    private Button continueButton;
    private boolean permissionGranted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        sContext = getApplicationContext ();
        activityContext = this;

        setContentView (R.layout.activity_login);

        phoneNum = (EditText)findViewById (R.id.et_enter_phone);
        countryCode = (TextView)findViewById (R.id.et_areacode);
        countryCode.setEnabled (false);

        continueButton = (Button)findViewById (R.id.next_button);
        continueButton.setEnabled (false);

        phoneNum.addTextChangedListener (new TextWatcher () {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @SuppressLint("ResourceAsColor")
            @Override
            public void afterTextChanged(Editable s) {
                mPhoneNumber = phoneNum.getText ().toString ();

                if (!mPhoneNumber.equals ("") && mPhoneNumber.length ()==10) {
                    continueButton.setEnabled (true);
                    continueButton.setBackgroundColor (R.color.BLU);
                } else {
                    continueButton.setEnabled (false);
                    continueButton.setBackgroundColor (R.color.BLU4);
                }
            }
        });

        if (savedInstanceState != null) {
            phoneNum.setText(savedInstanceState.getString ("phone_num"));
        } else {
            permissionGranted = false;
        }
    }

    public boolean verifyPhoneNumberLength(){
        return (mPhoneNumber.length() == 10);
    }

    public void sendVerificationData()
    {
        //showProgressDialog("Requesting verification code");
        Log.d (LOG_TAG, "In start verification process");
        apiManager.requestVerificationCode(mPhoneNumber, new CustomListener<NumberVerification> () {
            @Override
            public void onResponse(NumberVerification numberVerification, Map headers, String apiUrl) {
                if (numberVerification.isSuccess()) {
                    smsSent = true;

                }
                if (!numberVerification.isSuccess()) {
                    HashMap<String, String> map = new HashMap<>();
                    map.putAll(CommonLib.getAuthenticationHeaders());
                    map.put(Api.AccountsApi.USER_PHONE, mPhoneNumber.trim());
                    map.put("REQUEST_URL", apiUrl);
                    map.put("REQUEST_TYPE", "POST");
                    //Log.e(LOG_TAG, numberVerification.getMessage(), CommonLib.Priority.VERY_HIGH, map);
                    //showAToast("Unable to request verification code, please retry.");
                }
            }
        }, null);

    }

    public boolean verifySMSPermission() {
        if (PermissionUtils.hasPermission(PermissionUtils.REQUEST_SMS, sContext)) {
            return true;
        } else {
            PermissionUtils.requestPermissions(new int[] {PermissionUtils.REQUEST_SMS},
                    activityContext, PermissionUtils.REQUEST_SMS);
            return false;
        }
    }

    public void getOTP(View view) {
        Log.d (LOG_TAG, "Get OTP."+ phoneNum.getText ().toString ());

        mPhoneNumber = phoneNum.getText().toString ();

        Log.d (LOG_TAG, "Phone num:."+ mPhoneNumber);
        if (verifySMSPermission()){
            permissionGranted = true;
            sendVerificationData();
        }

        if (smsSent) {
            Intent otp_screen = new Intent (this, OTP.class);

            otp_screen.putExtra ("phoneNum", mPhoneNumber);
            startActivity (otp_screen);
        }
    }



    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState (outState);

        if (phoneNum != null) {
            outState.putString ("phone_num", phoneNum.getText ().toString ());
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case PermissionUtils.REQUEST_SMS: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    permissionGranted = true;
                    sendVerificationData ();
                }
                return;
            }
        }
    }

}
