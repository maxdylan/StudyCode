package com.xintu.qunyinghui.customView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Scroller;

/**
 * Created by Tong on 2017/10/24.
 */

public class CustomVerticalScrollView extends ViewGroup {
    private int mScreenHeight;
    private int mStart, mEnd, mLast;
    private Scroller mScroller;

    public CustomVerticalScrollView(Context context) {
        super(context);
    }

    public CustomVerticalScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomVerticalScrollView(Context context, AttributeSet attrs, int
            defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mScroller = new Scroller(context);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mScreenHeight = MeasureSpec.getSize(heightMeasureSpec);
        int viewCount = getChildCount();
        for (int i = 0; i < viewCount; i++) {
            View v = getChildAt(i);
            measureChild(v, widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int viewCount = getChildCount();
        MarginLayoutParams params = (MarginLayoutParams) getLayoutParams();
        params.height = viewCount * mScreenHeight;
        setLayoutParams(params);

        for (int i = 0; i < viewCount; i++) {
            View v = getChildAt(i);
            if (v.getVisibility() != GONE) {
                v.layout(l, i * mScreenHeight, r, (i + 1) * mScreenHeight);
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int y = (int) event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mStart = getScrollY();
                mLast = y;
                break;
            case MotionEvent.ACTION_MOVE:
                if (!mScroller.isFinished()) {
                    mScroller.abortAnimation();
                }
                int dy = mLast - y;
                if (getScrollY() < 0 || getScrollY() > getHeight() -
                        mScreenHeight) {
                    dy = 0;
                }
                scrollBy(0, dy);
                mLast = y;
                break;
            case MotionEvent.ACTION_UP:
                mEnd = getScrollY();
                int dScroll = mEnd - mStart;
                if (dScroll > 0) {
                    if (dScroll < mScreenHeight / 3) {
                        mScroller.startScroll(0, getScrollY(), 0, -dScroll);
                    } else {
                        mScroller.startScroll(0, getScrollY(), 0,
                                mScreenHeight - dScroll);
                    }
                } else {
                    if (-dScroll < mScreenHeight / 3) {
                        mScroller.startScroll(0, getScrollY(), 0, -dScroll);
                    } else {
                        mScroller.startScroll(0, getScrollY(), 0,
                                -mScreenHeight - dScroll);
                    }
                }
                break;
        }
        postInvalidate();
        return true;
    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        if (mScroller.computeScrollOffset()) {
            scrollTo(0, mScroller.getCurrY());
            postInvalidate();
        }
    }
}
