package com.qwildz.digitallibrary.adapters;

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

/**
 * Created by Ravi Tamada on 18/05/16.
 */
public abstract class RecyclerViewAdapter<M, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    protected Context mContext;
    protected List<M> list;

    public RecyclerViewAdapter(Context mContext, List<M> list) {
        this.mContext = mContext;
        this.list = list;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
