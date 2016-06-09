package com.freakybyte.poketest.ui.textview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Jose Torres in FreakyByte on 08/06/16.
 */
public class CapitalizedTextView extends TextView {

    public CapitalizedTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void setText(CharSequence text, BufferType type) {
        if (text.length() > 0) {
            text = String.valueOf(text.charAt(0)).toUpperCase() + text.subSequence(1, text.length());
        }
        super.setText(text, type);
    }
}