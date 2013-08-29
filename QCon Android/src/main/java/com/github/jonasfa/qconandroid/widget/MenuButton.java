package com.github.jonasfa.qconandroid.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.PopupMenu;
import com.github.jonasfa.qconandroid.R;

public class MenuButton extends Button {
    int menuRes;

    public MenuButton(Context context, AttributeSet attrs) {
        super(context, attrs, R.attr.menuButtonStyle);

        TypedArray typedArray = context.obtainStyledAttributes(attrs,
                R.styleable.MenuButton, R.attr.menuButtonStyle, 0);
        menuRes = typedArray.getResourceId(R.styleable.MenuButton_menu, 0);
        typedArray.recycle();
    }

    public boolean performClick() {
        PopupMenu popup = new PopupMenu(getContext(), this);
        popup.getMenuInflater().inflate(menuRes, popup.getMenu());
        popup.show();

        return super.performClick();
    }
}
