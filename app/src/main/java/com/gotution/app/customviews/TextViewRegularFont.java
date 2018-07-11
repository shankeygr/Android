package com.gotution.app.customviews;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

public class TextViewRegularFont extends AppCompatTextView {
    public TextViewRegularFont(Context context) {
        super(context);
        setCustomFont(context);
    }

    public TextViewRegularFont(Context context, AttributeSet attrs) {
        super(context, attrs);
        setCustomFont(context);
    }

    public TextViewRegularFont(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setCustomFont(context);
    }

    private void setCustomFont(Context context)
    {
        if (context != null) {
            setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/Celias_Regular.ttf"));
        }
    }
}
