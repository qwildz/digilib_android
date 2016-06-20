package com.qwildz.digitallibrary.adapters;

import android.content.ClipData;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.qwildz.digitallibrary.Album;
import com.qwildz.digitallibrary.R;
import com.qwildz.digitallibrary.models.Book;
import com.qwildz.digitallibrary.ui.AspectRatioImageView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;

/**
 * Created by Ravi Tamada on 18/05/16.
 */
public abstract class RecyclerViewAdapter<M, VH extends RecyclerViewAdapter.ViewHolder> extends RecyclerView.Adapter<VH> {

    protected Context mContext;
    protected List<M> list;
    protected ViewHolder.ViewHolderOnClickListener clickListener;

    public RecyclerViewAdapter(Context mContext, List<M> list) {
        this(mContext, list, null);
    }

    public RecyclerViewAdapter(Context mContext, List<M> list, ViewHolder.ViewHolderOnClickListener listener) {
        this.mContext = mContext;
        this.list = list;
        this.clickListener = listener;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ViewHolderOnClickListener mListener;

        public ViewHolder(View view, ViewHolderOnClickListener listener) {
            super(view);
            view.setOnClickListener(this);

            mListener = listener;
        }

        @Override
        public void onClick(View v) {
            Timber.d("Clicked" + this.getAdapterPosition());
            if(mListener != null)
                mListener.onClick(v, this.getAdapterPosition());
        }

        public interface ViewHolderOnClickListener {
            void onClick(View view, int position);
        }
    }
}
