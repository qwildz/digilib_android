package com.qwildz.digitallibrary.adapters.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.qwildz.digitallibrary.R;
import com.qwildz.digitallibrary.adapters.RecyclerViewAdapter;
import com.qwildz.digitallibrary.models.Book;
import com.qwildz.digitallibrary.ui.AspectRatioImageView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Ravi Tamada on 18/05/16.
 */
public class ListBookAdapter extends RecyclerViewAdapter<Book, ListBookAdapter.MyViewHolder> {

    public ListBookAdapter(Context mContext, List<Book> list) {
        super(mContext, list);
    }

    public ListBookAdapter(Context mContext, List<Book> list, ViewHolder.ViewHolderOnClickListener listener) {
        super(mContext, list, listener);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview_big_thumbnail, parent, false);

        return new MyViewHolder(itemView, clickListener);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Book book = list.get(position);
        holder.title.setText(book.judul());

        // loading album cover using Glide library
        //Glide.with(mContext).load(book.getGambar()).into(holder.thumbnail);
        holder.thumbnail.setSrc(book.getGambar());
    }

    public class MyViewHolder extends RecyclerViewAdapter.ViewHolder {
        @BindView(R.id.title)
        public TextView title;

        @BindView(R.id.description)
        public TextView description;

        @BindView(R.id.thumbnail)
        public AspectRatioImageView thumbnail;

        public MyViewHolder(View view, ViewHolderOnClickListener listener) {
            super(view, listener);
            ButterKnife.bind(this, view);

            description.setVisibility(View.GONE);
            thumbnail.setAspectRatioEnabled(true);
            thumbnail.setAspectRatio((float) 1.2);
        }
    }
}
