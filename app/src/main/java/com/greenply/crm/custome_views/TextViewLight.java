package com.greenply.crm.custome_views;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by covetus-akki on 20/2/18.
 */

public class TextViewLight extends TextView {

    public TextViewLight(Context context) {
        super(context);
        Typeface face= Typeface.createFromAsset(context.getAssets(), "roboto_light.ttf");
        this.setTypeface(face);
    }

    public TextViewLight(Context context, AttributeSet attrs) {
        super(context, attrs);
        Typeface face= Typeface.createFromAsset(context.getAssets(), "roboto_light.ttf");
        this.setTypeface(face);
    }

    public TextViewLight(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        Typeface face= Typeface.createFromAsset(context.getAssets(), "roboto_light.ttf");
        this.setTypeface(face);
    }

    protected void onDraw (Canvas canvas) {
        super.onDraw(canvas);

    }

}
