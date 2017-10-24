package com.xintu.qunyinghui.customView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.xintu.qunyinghui.R;

public class CustomTextViewTestActivity extends AppCompatActivity {

    private ComboTitleBar titleBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_text_view_test);
        titleBar = (ComboTitleBar) findViewById(R.id.title);
        titleBar.setComboTitleBarClickListener(new ComboTitleBar.OnComboTitleBarClickListener() {
            @Override
            public void onLeftClick() {
                Toast.makeText(CustomTextViewTestActivity.this, "LeftClick", Toast.LENGTH_SHORT)
                        .show();
            }

            @Override
            public void onRightClick() {
                Toast.makeText(CustomTextViewTestActivity.this, "RightClick", Toast.LENGTH_SHORT)
                        .show();
            }
        });
    }
}
