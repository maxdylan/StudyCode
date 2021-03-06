package com.xintu.qunyinghui.customView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by Tong on 2017/10/13.
 */

public class DoubleBackgroundTextView extends android.support.v7.widget.AppCompatTextView {
    public DoubleBackgroundTextView(Context context) {
        super(context);
    }

    public DoubleBackgroundTextView(Context context, @Nullable AttributeSet
            attrs) {
        super(context, attrs);
    }

    public DoubleBackgroundTextView(Context context, @Nullable AttributeSet
            attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

//    @Override
//    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
//        int width = MeasureSpec.getSize(widthMeasureSpec);
//
//        Log.d("DoubleBackground", "At_most is " + MeasureSpec.AT_MOST + "  widthMode is " +
//                widthMode + "  width is " + width);
//
//
//        if (widthMode == MeasureSpec.AT_MOST) {
//            width += 10;
//        }
//
//        setMeasuredDimension(width,MeasureSpec.getSize(heightMeasureSpec));
//    }

    private Paint firstBgPaint,secondBgPaint;

    @Override
    protected void onDraw(Canvas canvas) {
        firstBgPaint = new Paint();
        firstBgPaint.setColor(Color.RED);
        firstBgPaint.setStyle(Paint.Style.FILL);
        secondBgPaint = new Paint();
        secondBgPaint.setColor(Color.GRAY);
        secondBgPaint.setStyle(Paint.Style.FILL);

        canvas.drawRect(0,0,getMeasuredWidth(),getMeasuredHeight(),firstBgPaint);
        canvas.drawRect(10,10,getMeasuredWidth()-10,getMeasuredHeight()-10,secondBgPaint);

        canvas.save();
        canvas.translate(10,0);
        super.onDraw(canvas);
        canvas.restore();
    }
}
