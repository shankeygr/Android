package com.gotution.app.customDialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.gotution.gotution.R;

public class CustomProgressDialog extends Dialog {
    private static final String ARG_MESSAGE = "message";
    private String message;
    private TextView messageTextView;

    public CustomProgressDialog(@NonNull Context context, String message) {
        super (context);
        this.message = message;
    }
    public CustomProgressDialog(Context context) {
        this(context, null);
    }

    public CustomProgressDialog(@NonNull Context context, int themeResId) {
        super (context, themeResId);
    }

    protected CustomProgressDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super (context, cancelable, cancelListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //setContentView(R.layout.custom_loading_dialog);
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP)
            getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        //messageTextView = (TextView) findViewById(R.id.custom_loading_dialog_box);
        if (isValidMessage()) {
            messageTextView.setVisibility(View.VISIBLE);
            messageTextView.setText(message);
        } else
            messageTextView.setVisibility(View.GONE);
    }

    public void setMessage(String message) {
        this.message = message;
        if (messageTextView != null) {
            if (isValidMessage()) {
                messageTextView.setVisibility(View.VISIBLE);
                messageTextView.setText(message);
            } else {
                messageTextView.setVisibility(View.GONE);
            }
        }
    }

    private boolean isValidMessage() {
        return !TextUtils.isEmpty(message);
    }
}
