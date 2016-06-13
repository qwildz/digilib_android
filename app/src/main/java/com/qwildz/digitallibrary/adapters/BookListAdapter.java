package com.qwildz.digitallibrary.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.qwildz.digitallibrary.R;
import com.qwildz.digitallibrary.models.Book;
import com.qwildz.digitallibrary.ui.AspectRatioImageView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Ravi Tamada on 18/05/16.
 */
public class BookListAdapter extends RecyclerViewAdapter<Book, BookListAdapter.MyViewHolder> {

    public BookListAdapter(Context mContext, List<Book> list) {
        super(mContext, list);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.album_card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Book book = list.get(position);
        holder.title.setText(book.getJudul());
        holder.count.setVisibility(View.GONE);

        // loading album cover using Glide library
        Glide.with(mContext).load(book.getGambar()).into(holder.thumbnail);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.title)
        public TextView title;

        @BindView(R.id.count)
        public TextView count;

        @BindView(R.id.thumbnail)
        public AspectRatioImageView thumbnail;

        public MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
