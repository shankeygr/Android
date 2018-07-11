package com.gotution.app.customviews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.gotution.gotution.R;

public class CustomToastView {
    public static Toast makeText(Context context, CharSequence text, int duration) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.custom_toast_view, null);
        TextView tv = (TextView) layout.findViewById(R.id.txt_toast_message);
        tv.setText(text);

        Toast toast = new Toast(context);
        toast.setDuration(duration);
        toast.setView(layout);
        return toast;
    }

}
