package com.arondillqs5328.unsplashme.activities;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.arondillqs5328.unsplashme.R;
import com.arondillqs5328.unsplashme.adapters.PagerAdapter;
import com.arondillqs5328.unsplashme.fragments.CollectionsPhotoFragment;
import com.arondillqs5328.unsplashme.fragments.FeaturedPhotoFragment;
import com.arondillqs5328.unsplashme.fragments.NewPhotoFragment;
import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.toolbar) Toolbar mToolbar;
    @BindView(R.id.drawer_layout) DrawerLayout mDrawerLayout;
    @BindView(R.id.view_pager) ViewPager mViewPager;
    @BindView(R.id.tab_layout) TabLayout mTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setUpToolbar();
        setUpTabLayoutAndViewPager();
    }

    private void setUpTabLayoutAndViewPager() {
        mTabLayout.setupWithViewPager(mViewPager);

        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager());
        pagerAdapter.addFragment(NewPhotoFragment.newInstance(), getString(R.string.tab_new));
        pagerAdapter.addFragment(FeaturedPhotoFragment.newInstance(), getString(R.string.tab_featured));
        pagerAdapter.addFragment(CollectionsPhotoFragment.newInstance(), getString(R.string.tab_collections));

        mViewPager.setAdapter(pagerAdapter);
        mViewPager.setOffscreenPageLimit(2);
    }

    private void setUpToolbar() {
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_nav_menu_white_24dp);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
            case R.id.search:
                Toast.makeText(this, "SEARCH", Toast.LENGTH_LONG).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
