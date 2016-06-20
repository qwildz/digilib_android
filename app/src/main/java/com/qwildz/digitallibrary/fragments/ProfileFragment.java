package com.qwildz.digitallibrary.fragments;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.GlideBitmapDrawable;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.qwildz.digitallibrary.MainActivity;
import com.qwildz.digitallibrary.MyApplication;
import com.qwildz.digitallibrary.R;
import com.qwildz.digitallibrary.adapters.ViewPagerAdapter;
import com.qwildz.digitallibrary.injector.components.DaggerInjectorComponent;
import com.qwildz.digitallibrary.injector.components.InjectorComponent;
import com.qwildz.digitallibrary.models.Book;
import com.qwildz.digitallibrary.models.Repository;
import com.qwildz.digitallibrary.models.User;
import com.qwildz.digitallibrary.models.Video;
import com.qwildz.digitallibrary.ui.AspectRatioImageView;
import com.qwildz.digitallibrary.ui.MyCollapsingToolbarLayout;
import com.trello.rxlifecycle.components.support.RxFragment;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindColor;
import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;

/**
 * Created by resna on 2016-06-20.
 */
public class ProfileFragment extends RxFragment implements AppBarLayout.OnOffsetChangedListener {

    @BindView(R.id.appbar)
    AppBarLayout appBarLayout;
    @BindView(R.id.collapsing_toolbar)
    MyCollapsingToolbarLayout collapsingToolbarLayout;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;

    @BindView(R.id.profile_container_background)
    FrameLayout profileContainerBackground;
    @BindView(R.id.background_cover)
    ImageView bgCover;
    @BindView(R.id.profile_container)
    RelativeLayout bookContainer;
    @BindView(R.id.profile_picture)
    ImageView profilePicture;
    @BindView(R.id.profile_name)
    TextView profileName;
    @BindView(R.id.profile_title)
    TextView profileTitle;

    @BindView(R.id.tabs)
    TabLayout mTabLayout;
    @BindView(R.id.tabs_viewpager)
    ViewPager mViewPager;

    @BindColor(R.color.navheader_gradient_start)
    int navheaderGradStart;
    @BindColor(R.color.navheader_gradient_center)
    int navheaderGradCenter;
    @BindColor(R.color.navheader_gradient_end)
    int navheaderGradEnd;

    private ArrayList<Book> bookActivity = new ArrayList<>();
    private ArrayList<Video> videoActivity = new ArrayList<>();

    @Inject
    Repository repository;

    private ViewPagerAdapter mPagerAdapter;

    private ViewPropertyAnimator toolbarTitleAnimation;

    boolean collapsed = false;

    public ProfileFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MyApplication application = (MyApplication) getActivity().getApplication();
        InjectorComponent injectorComponent = DaggerInjectorComponent.builder()
                .baseComponent(application.getBaseComponent())
                .build();

        injectorComponent.inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_profile, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //getActivity().setSupportActionBar(toolbar);
        ((MainActivity) getActivity()).setSupportActionBar(toolbar);
        ((MainActivity) getActivity()).setToolbar(toolbar);

        appBarLayout.addOnOffsetChangedListener(this);

        toolbarTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        toolbarTitle.setText(((MainActivity) getActivity()).getTitle());
        toolbarTitle.setAlpha(0);
        (getActivity()).setTitle("");
        toolbarTitleAnimation = toolbarTitle.animate().setDuration(300).setStartDelay(0);

        mTabLayout.setTabMode(TabLayout.MODE_FIXED);
        mTabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        //mPagerAdapter = new ViewPagerAdapter(getChildFragmentManager());
        //mPagerAdapter.addFragment(ListBookFragment.newInstance(bookActivity), null);
        //mPagerAdapter.addFragment(ListVideoFragment.newInstance(videoActivity), null);

        //mViewPager.setAdapter(mPagerAdapter);

        if(getArguments() != null) {
            User user = getArguments().getParcelable("USER");
            if (user == null) {
                repository.getUser().compose(bindToLifecycle()).subscribe(this::setUser);
            } else {
                setUser(user);
            }
        } else {
            repository.getUser().compose(bindToLifecycle()).subscribe(this::setUser);
        }
    }

    private void setUser(User user) {
        profileName.setText(user.nama());
        profileTitle.setText(user.jurusan());

        toolbarTitle.setText(user.nama());

        this.bookActivity = new ArrayList<>(user.bookActivity());
        this.videoActivity = new ArrayList<>(user.videoActivity());

        mPagerAdapter = new ViewPagerAdapter(getChildFragmentManager());
        mPagerAdapter.addFragment(ListBookFragment.newInstance(bookActivity), null);
        mPagerAdapter.addFragment(ListVideoFragment.newInstance(videoActivity), null);
        mViewPager.setAdapter(mPagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
        setupTabIcons();

        Glide.with(getContext()).load(user.getPp()).listener(new RequestListener<String, GlideDrawable>() {
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

                    collapsingToolbarLayout.setContentScrimColor(start);
                    collapsingToolbarLayout.setStatusBarScrimColor(end);

                    GradientDrawable gd = new GradientDrawable(
                            GradientDrawable.Orientation.BR_TL,
                            new int[] {start, end});
                    gd.setCornerRadius(0f);

                    bgCover.post(() -> {
                        bgCover.setImageDrawable(gd);
                        bgCover.animate().setDuration(600).setStartDelay(0).alpha(1);
                    });
                });
                return false;
            }
        }).into(profilePicture);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {

        super.onSaveInstanceState(outState);
    }

    private void setupTabIcons() {
        mTabLayout.getTabAt(0).setIcon(R.drawable.tab_book);
        mTabLayout.getTabAt(1).setIcon(R.drawable.tab_video);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.main, menu);
        super.onCreateOptionsMenu(menu,inflater);
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

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
        int toolBarHeight = toolbar.getMeasuredHeight();
        int appBarHeight = appBarLayout.getMeasuredHeight();
        int tolerant = 30;

        Float f = ((((float) appBarHeight - toolBarHeight - getStatusBarHeight()) + verticalOffset - tolerant)
                / ((float) appBarHeight - toolBarHeight - getStatusBarHeight() - tolerant)) * 255;
        //Float f = ((((float) appBarHeight) + verticalOffset) / ( (float) appBarHeight)) * 255;

        bookContainer.setAlpha(((float) f / 255));

        Timber.d("" + ((float) f / 255));

        if (f > 0 && collapsed) {
            collapsingToolbarLayout.setForceScrimsShown(false);
            toolbarTitleAnimation.alpha(0);
            collapsed = false;
        } else if (f < 0 && !collapsed) {
            collapsingToolbarLayout.setForceScrimsShown(true);
            toolbarTitleAnimation.alpha(1);
            collapsed = true;
        }
    }

    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }
}
