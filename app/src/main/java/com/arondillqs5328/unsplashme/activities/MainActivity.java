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
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import androidx.annotation.NonNull;
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
    @BindView(R.id.navigation_view) NavigationView mNavigationView;
    @BindView(R.id.view_pager) ViewPager mViewPager;
    @BindView(R.id.tab_layout) TabLayout mTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setUpToolbar();
        setUpTabLayoutAndViewPager();
        setUpNavigationView();
    }

    private void setUpToolbar() {
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_nav_menu_white_24dp);
    }

    private void setUpTabLayoutAndViewPager() {
        mTabLayout.setupWithViewPager(mViewPager);

        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager());
        pagerAdapter.addFragment(NewPhotoFragment.newInstance(), getString(R.string.tab_new));
        pagerAdapter.addFragment(FeaturedPhotoFragment.newInstance(), getString(R.string.tab_featured));
        pagerAdapter.addFragment(CollectionsPhotoFragment.newInstance(), getString(R.string.tab_collections));

        mViewPager.setAdapter(pagerAdapter);
        mViewPager.setOffscreenPageLimit(2);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        mNavigationView.setCheckedItem(R.id.nav_new);
                        break;
                    case 1:
                        mNavigationView.setCheckedItem(R.id.nav_featured);
                        break;
                    case 2:
                        mNavigationView.setCheckedItem(R.id.nav_collections);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void setUpNavigationView() {
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_new:
                        Toast.makeText(getApplicationContext(), "new", Toast.LENGTH_SHORT).show();
                        mDrawerLayout.closeDrawer(GravityCompat.START);
                        mViewPager.setCurrentItem(0);
                        return true;
                    case R.id.nav_featured:
                        Toast.makeText(getApplicationContext(), "featured", Toast.LENGTH_SHORT).show();
                        mDrawerLayout.closeDrawer(GravityCompat.START);
                        mViewPager.setCurrentItem(1);
                        return true;
                    case R.id.nav_collections:
                        Toast.makeText(getApplicationContext(), "collections", Toast.LENGTH_SHORT).show();
                        mDrawerLayout.closeDrawer(GravityCompat.START);
                        mViewPager.setCurrentItem(2);
                        return true;
                    case R.id.nav_settings:
                        Toast.makeText(getApplicationContext(), "settings", Toast.LENGTH_SHORT).show();
                        mDrawerLayout.closeDrawer(GravityCompat.START);
                        return true;
                    case R.id.nav_about:
                        Toast.makeText(getApplicationContext(), "about", Toast.LENGTH_SHORT).show();
                        mDrawerLayout.closeDrawer(GravityCompat.START);
                        return true;
                }
                return true;
            }
        });
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
