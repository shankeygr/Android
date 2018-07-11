package com.gotution.app.customviews;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

import com.gotution.app.application.goTutionApp;
import com.gotution.app.utils.CommonLib;

public class TextViewLightFont extends AppCompatTextView
{
    public TextViewLightFont(Context context)
    {
        super(context);
        setCustomFont(context);
    }

    public TextViewLightFont(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        setCustomFont(context);
    }

    public TextViewLightFont(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
        setCustomFont(context);
    }

    private void setCustomFont(Context context)
    {
        if (context != null) {
            if(!isInEditMode()) setTypeface(goTutionApp.getTypeFaceLight());
            else setTypeface(CommonLib.getTypeFaceLight(context));
        }
    }
    @Override
    public void setTextColor(int color) {
        try{
            super.setTextColor(color);
        }catch (Exception e){

        }

    }
}

