package com.shortylabs.androidtruetypeprogress;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.Button;

/**
 */
public class FontButton extends Button {


    public FontButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    public FontButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public FontButton(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        // Typeface.createFromAsset doesn't work in the layout editor. Skipping ...
        if (isInEditMode()) {
            return;
        }

//        Typeface tf = Typeface.createFromAsset(context.getAssets(),
//                "fonts/SirucaPictograms1.1_.ttf");
        Typeface tf = Typeface.createFromAsset(context.getAssets(),
                "fonts/fauxsnow.ttf");
        setTypeface(tf, 1);

    }
}
