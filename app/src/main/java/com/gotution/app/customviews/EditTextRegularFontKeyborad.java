package com.gotution.app.customviews;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;

public class EditTextRegularFontKeyborad extends AppCompatEditText {

    private OnBackPressedInterface callback;

    public EditTextRegularFontKeyborad(Context context) {
        super(context);
        setCustomFont(context);
    }

    public EditTextRegularFontKeyborad(Context context, AttributeSet attrs) {
        super(context, attrs);
        setCustomFont(context);
    }

    public EditTextRegularFontKeyborad(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setCustomFont(context);
    }

    protected void setCustomFont(Context context) {
        if (context != null) {
            setTypeface (Typeface.createFromAsset (context.getAssets (), "fonts/Celias_Regular.ttf"));
        }
    }

    public void setOnBackPressedInterface(OnBackPressedInterface callback) {
        this.callback = callback;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) setCursorVisible(true);
        return super.onTouchEvent(event);
    }

    @Override
    public boolean dispatchKeyEventPreIme(@NonNull KeyEvent event) {
        // Check action too so that the callback only gets fired once
        if (event.getKeyCode() == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_UP) {
            KeyEvent.DispatcherState state = getKeyDispatcherState();
            if (state != null) {
                if (callback != null) {
                    callback.backPressedEditText();
                    return true;
                } else {
                    setCursorVisible(false);
                    return super.dispatchKeyEventPreIme(event);
                }
            }
        }

        return super.dispatchKeyEventPreIme(event);
    }

    public interface OnBackPressedInterface {
        void backPressedEditText();
    }
}
