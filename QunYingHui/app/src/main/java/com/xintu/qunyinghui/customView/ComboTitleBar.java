package com.xintu.qunyinghui.customView;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xintu.qunyinghui.R;

/**
 * Created by Tong on 2017/10/16.
 */

public class ComboTitleBar extends RelativeLayout {
    private String title,leftText,rightText;
    private int titleColor,leftTextColor,rightTextColor;
    private Drawable leftBackground,rightBackground;
    private float titleSize;

    private TextView titleView;
    private Button leftBtn,rightBtn;

    private LayoutParams leftParams,rightParams,titleParams;

    private OnComboTitleBarClickListener comboTitleBarClickListener;

    public ComboTitleBar(Context context) {
        this(context, null);
    }

    public ComboTitleBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ComboTitleBar(Context context, AttributeSet attrs, int
            defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.ComboTitleBar);
        title = ta.getString(R.styleable.ComboTitleBar_title);
        titleColor = ta.getColor(R.styleable.ComboTitleBar_titleColor, Color.WHITE);
        titleSize = ta.getDimension(R.styleable.ComboTitleBar_titleSize, 18);
        leftText = ta.getString(R.styleable.ComboTitleBar_leftText);
        leftTextColor = ta.getColor(R.styleable.ComboTitleBar_leftTextColor, Color.WHITE);
        leftBackground = ta.getDrawable(R.styleable.ComboTitleBar_leftBackground);
        rightText = ta.getString(R.styleable.ComboTitleBar_rightText);
        rightTextColor = ta.getColor(R.styleable.ComboTitleBar_rightTextColor, Color.WHITE);
        rightBackground = ta.getDrawable(R.styleable.ComboTitleBar_rightBackground);
        ta.recycle();

        titleView = new TextView(context);
        leftBtn = new Button(context);
        rightBtn = new Button(context);

        titleView.setText(title);
        titleView.setTextColor(titleColor);
        titleView.setTextSize(titleSize);

        leftBtn.setText(leftText);
        leftBtn.setTextColor(leftTextColor);
        leftBtn.setBackground(leftBackground);

        rightBtn.setText(rightText);
        rightBtn.setTextColor(rightTextColor);
        rightBtn.setBackground(rightBackground);

        titleView.setGravity(Gravity.CENTER);

        leftParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
        leftParams.addRule(ALIGN_PARENT_LEFT, TRUE);
        addView(leftBtn,leftParams);

        rightParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
        rightParams.addRule(ALIGN_PARENT_RIGHT, TRUE);
        addView(rightBtn,rightParams);

        titleParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
        titleParams.addRule(CENTER_IN_PARENT, TRUE);
        addView(titleView,titleParams);

        leftBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (comboTitleBarClickListener != null) {
                    comboTitleBarClickListener.onLeftClick();
                }
            }
        });

        rightBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (comboTitleBarClickListener != null) {
                    comboTitleBarClickListener.onRightClick();
                }
            }
        });
    }

    public void setComboTitleBarClickListener(OnComboTitleBarClickListener
                                                      comboTitleBarClickListener) {
        this.comboTitleBarClickListener = comboTitleBarClickListener;
    }

    public interface OnComboTitleBarClickListener{
        void onLeftClick();
        void onRightClick();
    }

}
