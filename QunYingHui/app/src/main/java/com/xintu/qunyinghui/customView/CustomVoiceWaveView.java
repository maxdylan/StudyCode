package com.xintu.qunyinghui.customView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.Random;

/**
 * Created by Tong on 2017/10/24.
 */

public class CustomVoiceWaveView extends View {
    private Paint itemPaint;
    private LinearGradient linearGradient;

    public CustomVoiceWaveView(Context context) {
        this(context, null);
    }

    public CustomVoiceWaveView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomVoiceWaveView(Context context, @Nullable AttributeSet attrs,
                               int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        itemPaint = new Paint();
        itemPaint.setColor(Color.GRAY);
        itemPaint.setStyle(Paint.Style.FILL);

//        linearGradient = new LinearGradient()
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int height = MeasureSpec.getSize(heightMeasureSpec);
        if (height < 200) {
            height = 200;
        }
        setMeasuredDimension(MeasureSpec.getSize(widthMeasureSpec), height);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        linearGradient = new LinearGradient(0, 0, getWidth(), getHeight(),
                Color.RED, Color.BLUE, Shader.TileMode.CLAMP);
        itemPaint.setShader(linearGradient);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            canvas.drawRect(i * (getMeasuredWidth() / 10)+5, random.nextInt
                    (getMeasuredHeight()), (i+1)*(getMeasuredWidth() / 10),
                    getMeasuredHeight(), itemPaint);

        }
        postInvalidateDelayed(500);

    }
}
