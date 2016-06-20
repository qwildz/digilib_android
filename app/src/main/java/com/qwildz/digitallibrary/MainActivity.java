package com.qwildz.digitallibrary;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.GlideBitmapDrawable;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.qwildz.digitallibrary.adapters.ViewPagerAdapter;
import com.qwildz.digitallibrary.fragments.HomeFragment;
import com.qwildz.digitallibrary.fragments.ListBookFragment;
import com.qwildz.digitallibrary.fragments.ListNewsFragment;
import com.qwildz.digitallibrary.fragments.ListVideoFragment;
import com.qwildz.digitallibrary.fragments.ProfileFragment;
import com.qwildz.digitallibrary.injector.components.DaggerInjectorComponent;
import com.qwildz.digitallibrary.injector.components.InjectorComponent;
import com.qwildz.digitallibrary.models.Repository;
import com.qwildz.digitallibrary.models.User;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import javax.inject.Inject;

import butterknife.BindColor;
import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;

public class MainActivity extends RxAppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

//    @BindView(R.id.fab)
//    FloatingActionButton fab;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;
    @BindView(R.id.nav_view)
    NavigationView navigationView;

    LinearLayout navheader;
    ImageView navheaderPicture;
    TextView navheaderName;
    TextView navheaderTitle;

//    @BindView(R.id.tabs)
//    TabLayout mTabLayout;
//    @BindView(R.id.tabs_viewpager)
//    ViewPager mViewPager;

    @BindColor(R.color.navheader_gradient_start)
    int navheaderGradStart;
    @BindColor(R.color.navheader_gradient_center)
    int navheaderGradCenter;
    @BindColor(R.color.navheader_gradient_end)
    int navheaderGradEnd;

    @Inject
    Repository repository;
    @Inject
    SharedPreferences sharedPreferences;

    private ActionBarDrawerToggle toggle;

    private static int stateId = R.id.nav_home;

    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        View navHeader = navigationView.getHeaderView(0);
        navheader = ButterKnife.findById(navHeader, R.id.navheader);
        navheaderPicture = ButterKnife.findById(navHeader, R.id.navheader_picture);
        navheaderName = ButterKnife.findById(navHeader, R.id.navheader_name);
        navheaderTitle = ButterKnife.findById(navHeader, R.id.navheader_title);

        MyApplication application = (MyApplication) getApplication();
        InjectorComponent injectorComponent = DaggerInjectorComponent.builder()
                .baseComponent(application.getBaseComponent())
                .build();

        injectorComponent.inject(this);

        if(! sharedPreferences.getBoolean("logedin", false)) {
            LoginActivity.navigate(this);
            finish();
            return;
        }

        if(savedInstanceState == null) {
            switchFragment(stateId, true);
        } else {
            switchFragment(stateId, false);
        }

        repository.getUser().compose(bindToLifecycle()).subscribe(user -> {
            this.user = user;

            navheaderName.setText(user.nama());
            navheaderTitle.setText(user.jurusan());

            Glide.with(getApplicationContext()).load(user.getPp()).listener(new RequestListener<String, GlideDrawable>() {
                @Override
                public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                    return false;
                }

                @Override
                public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                    Palette.from(((GlideBitmapDrawable) resource).getBitmap()).generate(palette -> {
                        int start = palette.getLightVibrantColor(navheaderGradStart);
                        int center = palette.getVibrantColor(navheaderGradCenter);
                        int end = palette.getDarkVibrantColor(navheaderGradEnd);

                        GradientDrawable gd = new GradientDrawable(
                                GradientDrawable.Orientation.BR_TL,
                                new int[] {start, center, end});
                        gd.setCornerRadius(0f);

                        navheader.setBackground(gd);
                    });
                    return false;
                }
            }).into(navheaderPicture);


        });

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

//        fab.setOnClickListener(view -> Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                .setAction("Action", null).show());

        navigationView.setNavigationItemSelectedListener(this);

//        mTabLayout.setTabMode(TabLayout.MODE_FIXED);
//        mTabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
//
//        mPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
//        mPagerAdapter.addFragment(ListBookFragment.newInstance(), null);
//        mPagerAdapter.addFragment(ListVideoFragment.newInstance(), null);
//        mPagerAdapter.addFragment(ListNewsFragment.newInstance(), null);
//
//        mViewPager.setAdapter(mPagerAdapter);
//        mViewPager.setOffscreenPageLimit(3);
//        mTabLayout.setupWithViewPager(mViewPager);
//        setupTabIcons();
    }

//    private void setupTabIcons() {
//        mTabLayout.getTabAt(0).setIcon(R.drawable.tab_book);
//        mTabLayout.getTabAt(1).setIcon(R.drawable.tab_video);
//        mTabLayout.getTabAt(2).setIcon(R.drawable.tab_news);
//    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public void setToolbar(Toolbar toolbar) {
        if(toggle != null) drawer.removeDrawerListener(toggle);
        toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if(id == R.id.nav_setting) {

        } else if(id == R.id.nav_logout) {
            new AlertDialog.Builder(this)
                    .setMessage("Do you want to logout?")
                    .setPositiveButton("Yes", (dialogInterface, i) -> {
                        sharedPreferences.edit().clear().apply();
                        LoginActivity.navigate(MainActivity.this);
                        finish();
                    })
                    .setNegativeButton("No", null)
                    .show();
        }

        switchFragment(id, false);

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void switchFragment(int id, boolean force) {
        Fragment fragment = null;
        if(id == R.id.nav_home && (stateId != R.id.nav_home || force)) {
            fragment = new HomeFragment();
            stateId = R.id.nav_home;
        } else if(id == R.id.nav_profile && (stateId != R.id.nav_profile || force)) {
            fragment = new ProfileFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("USER", user);
            fragment.setArguments(bundle);
            stateId = R.id.nav_profile;
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.frame_container, fragment).commit();
        }
    }
}
