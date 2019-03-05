package com.aAronQInk.Walls.activities;

import android.os.Bundle;

import com.aAronQInk.Walls.R;
import com.aAronQInk.Walls.util.ThemeUtil;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        switch (ThemeUtil.getTheme(this)) {
            case "Dark":
                setTheme(R.style.DarkTheme);
                break;
            case "Default":
                setTheme(R.style.AppTheme);
                break;
        }
        super.onCreate(savedInstanceState);
    }
}
