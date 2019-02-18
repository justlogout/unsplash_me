package com.arondillqs5328.unsplashme.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.arondillqs5328.unsplashme.R;
import com.arondillqs5328.unsplashme.fragments.PhotoPreviewFragment;

import androidx.appcompat.widget.Toolbar;
import butterknife.BindView;
import butterknife.ButterKnife;

public class PhotoPreviewActivity extends BaseActivity {

    @BindView(R.id.preview_toolbar) Toolbar mToolbar;

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, PhotoPreviewActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_preview);
        ButterKnife.bind(this);

        setUpToolbar();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.preview_frame, PhotoPreviewFragment.getInstance())
                .commit();
    }

    private void setUpToolbar() {
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
