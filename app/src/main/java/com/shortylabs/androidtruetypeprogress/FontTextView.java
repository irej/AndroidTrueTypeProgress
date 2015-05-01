package com.shortylabs.androidtruetypeprogress;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 */
public class FontTextView extends TextView {


    public FontTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    public FontTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public FontTextView(Context context) {
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
