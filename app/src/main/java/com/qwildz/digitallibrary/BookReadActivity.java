package com.qwildz.digitallibrary;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.ScrollBar;
import com.qwildz.digitallibrary.models.Book;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;

public class BookReadActivity extends AppCompatActivity {

    @BindView(R.id.pdf_view) PDFView pdfView;
    @BindView(R.id.scroll_bar) ScrollBar scrollBar;

    private static final String EXTRA_BOOK = "EXTRA_BOOK";
    private static final String STATE_PAGE = "STATE_PAGE";

    public static void navigate(Context context, File pdfLocation) {
        Intent intent = new Intent(context, BookReadActivity.class);
        intent.putExtra(EXTRA_BOOK, pdfLocation);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_read);
        ButterKnife.bind(this);

        pdfView.setScrollBar(scrollBar);

        File file = (File) getIntent().getSerializableExtra(EXTRA_BOOK);

        int page = 1;
        if(savedInstanceState != null) {
            page = savedInstanceState.getInt(STATE_PAGE, 1);
        }

        pdfView.fromFile(file)
                .defaultPage(page)
                .showMinimap(false)
                .swipeVertical(true)
                .enableSwipe(true)
                .load();
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt(STATE_PAGE, pdfView.getCurrentPage());
        super.onSaveInstanceState(savedInstanceState);
    }
}
