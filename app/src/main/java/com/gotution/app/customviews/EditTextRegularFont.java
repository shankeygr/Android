package com.gotution.app.customviews;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

public class EditTextRegularFont extends EditTextRegularFontKeyborad {
    public EditTextRegularFont(Context context) {
        super(context);
    }

    public EditTextRegularFont(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public EditTextRegularFont(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void setCustomFont(Context context)
    {
        if (context != null) {
            setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/Celias_Light.ttf"));
        }
    }

    @Override
    public void setText(CharSequence text, BufferType type)
    {
        super.setText(text, type);
    }
}
