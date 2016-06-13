package com.qwildz.digitallibrary.adapters.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.qwildz.digitallibrary.R;
import com.qwildz.digitallibrary.adapters.RecyclerViewAdapter;
import com.qwildz.digitallibrary.models.Book;
import com.qwildz.digitallibrary.ui.AspectRatioImageView;
import com.qwildz.digitallibrary.ui.AutofitRecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;

/**
 * Created by Ravi Tamada on 18/05/16.
 */
public class ListBookAdapter extends RecyclerViewAdapter<Book, ListBookAdapter.MyViewHolder> {

    private int columnCount = 0;
    private int columnWidth = -1;
    private int columnHeight = 0;

    public ListBookAdapter(Context mContext, List<Book> list) {
        super(mContext, list);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview_big_thumbnail, parent, false);

        if(parent instanceof AutofitRecyclerView) {
            if(columnCount != ((AutofitRecyclerView) parent).getColumnCount()) {
                columnCount = ((AutofitRecyclerView) parent).getColumnCount();
                columnWidth = -1;
            }
        }

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        if(columnWidth < 0) {
            holder.itemView.post(() -> {
                columnWidth = holder.itemView.getWidth();
                columnHeight = (int) (columnWidth * 1.2);

                setThumbnailHeight(holder.thumbnail, columnHeight);
            });
        } else {
            setThumbnailHeight(holder.thumbnail, columnHeight);
        }

        Book book = list.get(position);
        holder.title.setText(book.getJudul());
        holder.count.setVisibility(View.GONE);

        // loading album cover using Glide library
        Glide.with(mContext).load(book.getGambar()).into(holder.thumbnail);
    }

    private void setThumbnailHeight(ImageView view, int height) {
        view.getLayoutParams().height = height;
        view.requestLayout();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.title)
        public TextView title;

        @BindView(R.id.description)
        public TextView count;

        @BindView(R.id.thumbnail)
        public AspectRatioImageView thumbnail;

        public MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
