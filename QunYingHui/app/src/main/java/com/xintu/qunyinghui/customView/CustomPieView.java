package com.xintu.qunyinghui.customView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by tongchenfei on 2017/10/23.
 */

public class CustomPieView extends View {
    private Paint circlePaint,textPaint,arcPaint;
    public CustomPieView(Context context) {
        this(context,null);
    }

    public CustomPieView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CustomPieView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        circlePaint = new Paint();
        circlePaint.setColor(Color.BLACK);
        circlePaint.setStyle(Paint.Style.FILL);

        textPaint = new Paint();
        textPaint.setColor(Color.GRAY);
        textPaint.setTextSize(20);

        arcPaint = new Paint();
        arcPaint.setColor(Color.BLACK);
        arcPaint.setStyle(Paint.Style.STROKE);
        arcPaint.setStrokeWidth(10);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int length = getWidth();
        float circleCenter = length/2;
        float circleRadius = length/4;
        RectF rectF = new RectF((float) (length * 0.1), (float) (length * 0.1), (float) (length *
                0.9), (float) (length * 0.9));
        canvas.drawCircle(circleCenter,circleCenter,circleRadius,circlePaint);
        canvas.drawArc(rectF,0,270,false,arcPaint);
        String text = "CenterText";
        canvas.drawText(text,0,text.length(),circleCenter,circleCenter+5,textPaint);
    }
}
