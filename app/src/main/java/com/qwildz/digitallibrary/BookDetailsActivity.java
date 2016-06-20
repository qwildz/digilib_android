package com.qwildz.digitallibrary;

import android.app.DownloadManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.database.ContentObserver;
import android.database.Cursor;
import android.graphics.PorterDuff;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.graphics.ColorUtils;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.load.resource.bitmap.GlideBitmapDrawable;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.github.jorgecastilloprz.FABProgressCircle;
import com.qwildz.digitallibrary.injector.components.DaggerInjectorComponent;
import com.qwildz.digitallibrary.injector.components.InjectorComponent;
import com.qwildz.digitallibrary.models.Book;
import com.qwildz.digitallibrary.models.Repository;
import com.qwildz.digitallibrary.ui.AspectRatioImageView;
import com.qwildz.digitallibrary.ui.MyCollapsingToolbarLayout;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import java.io.File;

import javax.inject.Inject;

import butterknife.BindColor;
import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observable;
import timber.log.Timber;

public class BookDetailsActivity extends RxAppCompatActivity implements AppBarLayout.OnOffsetChangedListener {

    @BindView(R.id.appbar)
    AppBarLayout appBarLayout;
    @BindView(R.id.collapsing_toolbar)
    MyCollapsingToolbarLayout collapsingToolbarLayout;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    //@BindView(R.id.fab_progress)
    //FABProgressCircle fabProgress;

    @BindView(R.id.book_container_background)
    FrameLayout bookContainerBackground;
    @BindView(R.id.background_cover)
    ImageView bgCover;
    @BindView(R.id.book_container)
    RelativeLayout bookContainer;
    @BindView(R.id.book_cover)
    AspectRatioImageView bookCover;
    @BindView(R.id.book_title)
    TextView bookTitle;
    @BindView(R.id.book_author)
    TextView bookAuthor;
    @BindView(R.id.book_category)
    TextView bookCategory;
    @BindView(R.id.book_description)
    TextView bookDescription;

    @BindView(R.id.download_container)
    LinearLayout downloadContainer;
    @BindView(R.id.download_progress)
    ProgressBar downloadProgress;

    @BindColor(R.color.navheader_gradient_start)
    int navheaderGradStart;
    @BindColor(R.color.navheader_gradient_center)
    int navheaderGradCenter;
    @BindColor(R.color.navheader_gradient_end)
    int navheaderGradEnd;
    @BindColor(R.color.transparent)
    int transparent;
    boolean vibrantBright = false;

    @Inject
    Repository repository;

    @Inject
    SharedPreferences preferences;

    private DownloadsObserver downloadsObserver;

    private ViewPropertyAnimator toolbarTitleAnimation;

    boolean collapsed = false;

    private boolean isLoaded = false;
    private Book book;
    private static Observable<Book> bookObservable;

    private static final String EXTRA_BOOK = "EXTRA_BOOK";
    private static final String STATE_BOOK = "STATE_BOOK";

    public static void navigate(Context context, Book book) {
        Intent intent = new Intent(context, BookDetailsActivity.class);
        intent.putExtra(EXTRA_BOOK, book);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_details);
        ButterKnife.bind(this);

        MyApplication application = (MyApplication) getApplication();
        InjectorComponent injectorComponent = DaggerInjectorComponent.builder()
                .baseComponent(application.getBaseComponent())
                .build();

        injectorComponent.inject(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Scroll Listener
        appBarLayout.addOnOffsetChangedListener(this);

        // Set Title
        toolbarTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        toolbarTitle.setText(getSupportActionBar().getTitle());
        toolbarTitle.setAlpha(0);
        getSupportActionBar().setTitle("");
        toolbarTitleAnimation = toolbarTitle.animate().setDuration(300).setStartDelay(0);

        collapsingToolbarLayout.setContentScrimColor(transparent);
        collapsingToolbarLayout.setStatusBarScrimColor(transparent);

        fab.hide();
        fab.setOnClickListener(v -> managePdf());

        //fabProgress.attachListener(this::managePdf);

//        if(savedInstanceState != null) {
//            Timber.d(savedInstanceState.get(EXTRA_BOOK).toString());
//        }

        Bundle bundle = getIntent().getExtras();
        if (!bundle.isEmpty()) {
            book = bundle.getParcelable(EXTRA_BOOK);
            if (book != null)
                setContent(book);
        }

        if (book != null) {
            Timber.d("Loading book data");

            if (bookObservable == null || savedInstanceState == null)
                bookObservable = repository.getBook(book.id()).compose(bindToLifecycle()).cache();

            bookObservable.subscribe(this::setContent, error -> {
                Timber.e(error.getMessage());
            });
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        checkDownloadStatus();
    }

    @Override
    public void onStop() {
        super.onStop();
        if(downloadsObserver != null)
            getContentResolver().unregisterContentObserver(downloadsObserver);
    }

//    @Override
//    public void onSaveInstanceState(Bundle savedInstanceState) {
//        // Save the user's current game state
//        Bundle bundle = new Bundle();
//        bundle.putParcelable(STATE_BOOK, bookObservable);
//        savedInstanceState.put
//
//        // Always call the superclass so it can save the view hierarchy state
//        super.onSaveInstanceState(savedInstanceState);
//    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
        int toolBarHeight = toolbar.getMeasuredHeight();
        int appBarHeight = appBarLayout.getMeasuredHeight();
        int tolerant = 30;

        Float f = ((((float) appBarHeight - toolBarHeight - getStatusBarHeight()) + verticalOffset - tolerant)
                / ((float) appBarHeight - toolBarHeight - getStatusBarHeight() - tolerant)) * 255;
        //Float f = ((((float) appBarHeight) + verticalOffset) / ( (float) appBarHeight)) * 255;

        bookContainer.setAlpha(((float) f / 255));

        //Timber.d("" + ((float) f / 255));

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

    private void setContent(Book book) {
        this.book = book;
        Timber.d(book.toString());

        //getSupportActionBar().setTitle(book.judul());
        toolbarTitle.setText(book.judul());

        bookTitle.setText(book.judul());
        bookAuthor.setText(book.penulis());
        bookCategory.setText(book.kategori());
        bookDescription.setText(book.deskripsi());

        //Glide.with(this).load(book.getGambar()).placeholder(new ColorDrawable(Color.TRANSPARENT)).crossFade().into(bookCover);
        if (!isLoaded) {
            isLoaded = true;
            return;
        }
        bookCover.setListener(new RequestListener<String, GlideDrawable>() {
            @Override
            public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                return false;
            }

            @Override
            public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                Palette.from(((GlideBitmapDrawable) resource).getBitmap()).generate(palette -> {
                    int start = palette.getLightVibrantColor(navheaderGradStart);
                    int vibrant = palette.getVibrantColor(navheaderGradCenter);
                    int end = palette.getDarkVibrantColor(navheaderGradEnd);

                    vibrantBright = ColorUtils.calculateLuminance(vibrant) > 0.5;

                    GradientDrawable gd = new GradientDrawable(
                            GradientDrawable.Orientation.BR_TL,
                            new int[]{start, end});
                    gd.setCornerRadius(0f);

                    bgCover.post(() -> {
                        bgCover.setImageDrawable(gd);
                        bgCover.animate().setDuration(600).setStartDelay(0).alpha(1);
                    });

                    //collapsingToolbarLayout.setContentScrimColor(start);
                    collapsingToolbarLayout.setStatusBarScrimColor(end);

                    fab.postDelayed(() -> {
                        fab.setImageResource(vibrantBright ? R.drawable.ic_chrome_reader_mode_grey_700_24dp : R.drawable.ic_chrome_reader_mode_white_24dp);
                        fab.setRippleColor(start);
                        fab.setBackgroundTintList(ColorStateList.valueOf(vibrant));
                        fab.show();
                    }, 50);

                    //bookContainerBackground.setBackground(gd);
                });

                bookCover.post(() -> {
                    bookCover.setAlpha(0f);
                    bookCover.animate().setDuration(600).setStartDelay(0).alpha(1);
                });

                return false;
            }
        });
        bookCover.setSrcNoFade(book.getGambar());
    }

    private void checkDownloadStatus() {
        long downloadId = preferences.getLong("book" + book.filebook() + "id", 0);
        boolean downloadStatus = preferences.getBoolean("book" + book.filebook() + "status", false);

        if(!downloadStatus && downloadId > 0) {
            listenDownload(downloadId);
        }
    }

    private void managePdf() {
        String pdfHomePath = Environment.getExternalStorageDirectory() + "/digilib/";
        String pdfFilePath = pdfHomePath + book.filebook();

        File pdfFile = new File(pdfFilePath);

        File homeDir = new File(pdfHomePath);
        if (!homeDir.exists() && !homeDir.mkdir()) {
            return;
        }

        long downloadId = preferences.getLong("book" + book.filebook() + "id", 0);
        boolean downloadStatus = preferences.getBoolean("book" + book.filebook() + "status", false);

        Timber.d(downloadId + "");
        Timber.d(downloadStatus + "");

        // Check download status & file availability
        if(downloadStatus && downloadId > 0 && pdfFile.exists()) {
            openPdf(pdfFile);
        } else if(downloadStatus && downloadId > 0 && !pdfFile.exists()) {
            // File deleted, download again
            preferences.edit()
                    .remove("book" + book.filebook() + "id")
                    .remove("book" + book.filebook() + "status")
                    .apply();
            pdfFile.delete();
            downloadPdf();
        } else if(!downloadStatus && downloadId == 0) {
            pdfFile.delete();
            downloadPdf();
        } else {
            // Downloading...
        }
    }

    private void openPdf(File file) {
        Uri path = Uri.fromFile(file);
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(path, "application/pdf");
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        try {
            // Try open with pdf reader
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            // No pdf reader found, using
            Toast.makeText(this, "No application available to view PDF", Toast.LENGTH_LONG).show();
            BookReadActivity.navigate(this, file);
        }

    }

    private void downloadPdf() {
        Timber.d("Start downloading...");
        String url = Repository.END_POINT + "book/download/" + book.id() +
                "?token=" + "0218fab2e24e70085b0faa085032ecd3" + "&userid=" + "6" + "&id=" + book.id();

        DownloadManager manager = (DownloadManager) this.getSystemService(Context.DOWNLOAD_SERVICE);

        Uri uri = Uri.parse(url);
        DownloadManager.Request request = new DownloadManager.Request(uri);

        request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_MOBILE | DownloadManager.Request.NETWORK_WIFI)
                .setAllowedOverRoaming(false)
                .setTitle(book.judul())
                .setDestinationInExternalPublicDir("/digilib", book.filebook());

        long downloadId = manager.enqueue(request);
        preferences.edit()
                .putLong("book" + book.filebook() + "id", downloadId)
                .putBoolean("book" + book.filebook() + "status", false)
                .apply();

        listenDownload(downloadId);
    }

    private void listenDownload(long downloadId) {
        Uri downloadsContentUri = Uri.parse("content://downloads/my_downloads/" + downloadId);
        downloadsObserver = new DownloadsObserver(downloadId, new Handler());
        getContentResolver().registerContentObserver(downloadsContentUri, true, downloadsObserver);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    private class DownloadsObserver extends ContentObserver {
        private long downloadId = 0;
        private boolean isDownloading = false;

        public DownloadsObserver(long downloadId, Handler handler) {
            super(handler);
            this.downloadId = downloadId;
        }

        @Override
        public void onChange(boolean selfChange) {
            super.onChange(selfChange);

            DownloadManager.Query q = new DownloadManager.Query();
            q.setFilterById(downloadId);
            DownloadManager manager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
            Cursor c = manager.query(q);
            if (c.moveToFirst()) {
                int status = c.getInt(c.getColumnIndex(DownloadManager.COLUMN_STATUS));
                if (status == DownloadManager.STATUS_SUCCESSFUL) {
                    if(isDownloading) {
                        BookDetailsActivity.this.getContentResolver().unregisterContentObserver(downloadsObserver);
                        preferences.edit().putBoolean("book" + book.filebook() + "status", true).apply();
                        fab.post(() -> fab.show());
                        downloadContainer.setVisibility(View.GONE);
                        isDownloading = false;
                        managePdf();
                    }
                } else if(status == DownloadManager.STATUS_RUNNING || status == DownloadManager.STATUS_PENDING || status == DownloadManager.STATUS_PAUSED) {
                    fab.post(() -> fab.hide());

                    if(!isDownloading) {
                        downloadContainer.setVisibility(View.VISIBLE);
                        isDownloading = true;
                    }

                    if(status == DownloadManager.STATUS_RUNNING) {
                        downloadProgress.setIndeterminate(false);

                        long downloaded = c.getLong(c.getColumnIndex(DownloadManager.COLUMN_BYTES_DOWNLOADED_SO_FAR));
                        long total = c.getLong(c.getColumnIndex(DownloadManager.COLUMN_TOTAL_SIZE_BYTES));


                        downloadProgress.setProgress((int)((downloaded*100)/total));
                    } else {
                        downloadProgress.setIndeterminate(true);
                    }



                } else if(status == DownloadManager.STATUS_FAILED) {
                    BookDetailsActivity.this.getContentResolver().unregisterContentObserver(downloadsObserver);
                    preferences.edit()
                            .remove("book" + book.filebook() + "id")
                            .remove("book" + book.filebook() + "status")
                            .apply();
                    manager.remove(downloadId);
                    fab.post(() -> fab.show());
                    downloadContainer.setVisibility(View.GONE);
                }

                c.close();
            }
        }
    }
}
