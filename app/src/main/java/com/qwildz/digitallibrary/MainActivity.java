package com.qwildz.digitallibrary;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.fab) FloatingActionButton fab;
    @BindView(R.id.drawer_layout) DrawerLayout drawer;
    @BindView(R.id.nav_view) NavigationView navigationView;

    @BindView(R.id.tabs) TabLayout mTabLayout;
    @BindView(R.id.tabs_viewpager) ViewPager mViewPager;

    private CheesePagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab.setOnClickListener(view -> Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show());

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

        mTabLayout.setTabMode(TabLayout.MODE_FIXED);
        mTabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        mPagerAdapter = new CheesePagerAdapter();
        mViewPager.setAdapter(mPagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);

        addTab();
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void addTab() {
        mPagerAdapter.addTab("ADA");
        mPagerAdapter.addTab("KAMU");
        mPagerAdapter.addTab("DIHATI");
    }

    private static class CheesePagerAdapter extends PagerAdapter {
        private final ArrayList<CharSequence> mCheeses = new ArrayList<>();

        public void addTab(String title) {
            mCheeses.add(title);
            notifyDataSetChanged();
        }

        public void removeTab() {
            if (!mCheeses.isEmpty()) {
                mCheeses.remove(mCheeses.size() - 1);
                notifyDataSetChanged();
            }
        }

        @Override
        public int getCount() {
            return mCheeses.size();
        }

        @Override
        public int getItemPosition(Object object) {
            final Item item = (Item) object;
            final int index = mCheeses.indexOf(item.cheese);
            return index >= 0 ? index : POSITION_NONE;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            final TextView tv = new TextView(container.getContext());
            tv.setText(getPageTitle(position));
            tv.setGravity(Gravity.CENTER);
            tv.setTextAppearance(tv.getContext(), R.style.TextAppearance_AppCompat_Title);
            container.addView(tv, ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT);

            Item item = new Item();
            item.cheese = mCheeses.get(position);
            item.view = tv;
            return item;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            final Item item = (Item) object;
            return item.view == view;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mCheeses.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            final Item item = (Item) object;
            container.removeView(item.view);
        }

        private static class Item {
            TextView view;
            CharSequence cheese;
        }
    }

}
