package com.xintu.qunyinghui.customView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by tongchenfei on 2017/10/15.
 */

@SuppressLint("AppCompatCustomView")
public class FlashTextView extends TextView {
    public FlashTextView(Context context) {
        super(context);
    }

    public FlashTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public FlashTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private int viewWidth = 0;
    private Paint mPaint;
    private LinearGradient mLinearGradient;
    private Matrix mMatrix;
    private int translate = 0;

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (viewWidth == 0) {
            viewWidth = getMeasuredWidth();
            if (viewWidth != 0) {
                mPaint = getPaint();
                mLinearGradient = new LinearGradient(0, 0, viewWidth, 0, new int[]{Color.BLUE,
                        0xffffffff, Color.BLUE}, null, Shader.TileMode.CLAMP);
                mPaint.setShader(mLinearGradient);
                mMatrix = new Matrix();
            }
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mMatrix != null) {
            translate += viewWidth/5;
            if (translate > 2 * viewWidth) {
                translate = -viewWidth;
            }

            mMatrix.setTranslate(translate,0);
            mLinearGradient.setLocalMatrix(mMatrix);
            postInvalidateDelayed(100);

        }
    }
}
