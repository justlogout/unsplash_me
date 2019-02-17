package com.arondillqs5328.unsplashme.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.arondillqs5328.unsplashme.R;
import com.arondillqs5328.unsplashme.fragments.CollectionPreviewFragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import butterknife.BindView;
import butterknife.ButterKnife;

public class CollectionPreviewActivity extends BaseActivity {

    @BindView(R.id.collection_preview_toolbar) Toolbar mToolbar;

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, CollectionPreviewActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection_preview);
        ButterKnife.bind(this);

        setUpToolbar();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.collection_preview_frame, CollectionPreviewFragment.newInstance())
                .commit();
    }

    private void setUpToolbar() {
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
