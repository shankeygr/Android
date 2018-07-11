package com.gotution.app.customviews;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

public class TextViewMediumFont extends AppCompatTextView {

    public TextViewMediumFont(Context context) {
        super (context);
        setCustomFont(context);
    }

    public TextViewMediumFont(Context context, AttributeSet attrs) {
        super (context, attrs);
        setCustomFont(context);
    }

    public TextViewMediumFont(Context context, AttributeSet attrs, int defStyleAttr) {
        super (context, attrs, defStyleAttr);
        setCustomFont(context);
    }

    private void setCustomFont(Context context)
    {
        if (context != null) {
            setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/Celias_Medium.ttf"));
        }
    }

    @Override
    public void setTextColor(int color) {
        try{
            super.setTextColor(color);
        }catch (Exception e){}
    }
}
