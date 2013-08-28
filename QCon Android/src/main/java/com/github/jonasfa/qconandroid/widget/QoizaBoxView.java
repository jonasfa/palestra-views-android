package com.github.jonasfa.qconandroid.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.github.jonasfa.qconandroid.R;

public class QoizaBoxView extends LinearLayout {
    public QoizaBoxView(Context context, AttributeSet attrs) {
        super(context, attrs, R.attr.boxViewStyle);
        setOrientation(VERTICAL);

        TextView title = new TextView(context, null, R.attr.boxViewTitleStyle);
        addView(title, new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));

        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.QoizaBoxView, R.attr.boxViewStyle, 0);
        title.setText(typedArray.getString(R.styleable.QoizaBoxView_title));
        typedArray.recycle();
    }
}
