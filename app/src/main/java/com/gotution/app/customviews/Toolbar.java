package com.gotution.app.customviews;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.gotution.app.utils.CommonLib;
import com.gotution.gotution.R;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class Toolbar extends android.support.v7.widget.Toolbar {

    public final static int TITLE_ONLY = 0;
    private Context context;

    private int state;
    private TextView title;
    private LinearLayout titleLayout;
    private TextView titleSmall;
    private TextView subTitle;


    public Toolbar(Context context)
    {
        this(context, null);
    }

    public Toolbar(Context context, @Nullable AttributeSet attrs)
    {
        this(context, attrs, 0);
    }

    public Toolbar(Context context, @Nullable AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
        setMinimumHeight((int) CommonLib.convertDpToPixel(56, context));
        setBackgroundColor(ContextCompat.getColor(context, R.color.actionbar));
        setTitleTextColor (0xBB999999);
        this.context = context;

        setAsActionBar();
    }

    public void setTitle(@Nullable String title) {
        this.title.setText(title);
    }

    public void setTitleSmall(@Nullable String titleSmall) {
        this.titleSmall.setText(titleSmall);
    }

    public void setSubTitle(@Nullable String subTitle) {
        this.subTitle.setText(subTitle);
    }


    public void setAsActionBar() {
        if(context instanceof AppCompatActivity) {
            ((AppCompatActivity) context).setSupportActionBar(this);
            ActionBar actionBar = ((AppCompatActivity) context).getSupportActionBar();
            assert actionBar != null;
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setDisplayShowCustomEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
            this.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((AppCompatActivity) context).onBackPressed();
                }
            });
        } else {
            if(isInEditMode()) {
                //setTitle("Not of AppCompatActivity");
            } else {
                throw new IllegalStateException("Context must be of AppCompatActivity type: " + context.toString());
            }
        }
    }

    private void updateToolbar() {
        switch (state) {
            case TITLE_ONLY:
                title.setVisibility(VISIBLE);
                titleLayout.setVisibility(GONE);
                break;
        }
    }

    /**
     * Animate the title from Normal to Small and bring up the subTitle
     * @param subTitle the subTitle to set
     */
    public void animateTitle(String subTitle) {
        setSubTitle(subTitle);
        animateTitle();
    }

    public void animateTitle() {
        final float startSize = 15;
        final float endSize = 14;
        final int animationDuration = 600; // Animation duration in ms

        ValueAnimator animator = ValueAnimator.ofFloat(startSize, endSize);
        animator.setDuration(animationDuration);

        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedValue = (float) valueAnimator.getAnimatedValue();
                title.setTextSize(animatedValue);
            }
        });

        animator.start();
    }
}
