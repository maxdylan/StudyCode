package com.xintu.qunyinghui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.xintu.qunyinghui.customView.CustomTextViewTestActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goCustomTextView(View view) {
        startActivity(new Intent(MainActivity.this,
                CustomTextViewTestActivity.class));
    }
}
