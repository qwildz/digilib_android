package com.qwildz.digitallibrary.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.graphics.ColorUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.qwildz.digitallibrary.MyApplication;
import com.qwildz.digitallibrary.R;
import com.qwildz.digitallibrary.adapters.RecyclerViewAdapter;
import com.qwildz.digitallibrary.adapters.recyclerview.ListBookAdapter;
import com.qwildz.digitallibrary.adapters.recyclerview.ListVideoAdapter;
import com.qwildz.digitallibrary.injector.components.DaggerInjectorComponent;
import com.qwildz.digitallibrary.injector.components.InjectorComponent;
import com.qwildz.digitallibrary.models.Book;
import com.qwildz.digitallibrary.models.Repository;
import com.qwildz.digitallibrary.models.Video;
import com.qwildz.digitallibrary.ui.AutofitRecyclerView;
import com.qwildz.digitallibrary.ui.MarginDecoration;
import com.trello.rxlifecycle.components.support.RxFragment;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import fm.jiecao.jcvideoplayer_lib.JCFullScreenActivity;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * Created by resna on 2016-06-12.
 */
public class ListVideoFragment extends RxFragment implements RecyclerViewAdapter.ViewHolder.ViewHolderOnClickListener {

    AutofitRecyclerView recyclerView;

    private ListVideoAdapter adapter;
    private List<Video> dataList;

    @Inject
    Repository repository;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ListVideoFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static ListVideoFragment newInstance() {
        ListVideoFragment fragment = new ListVideoFragment();
        return fragment;
    }

    public static ListVideoFragment newInstance(ArrayList<Video> videos) {
        ListVideoFragment fragment = new ListVideoFragment();

        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("LIST_VIDEOS", videos);

        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MyApplication application = (MyApplication) getActivity().getApplication();
        InjectorComponent injectorComponent = DaggerInjectorComponent.builder()
                .baseComponent(application.getBaseComponent())
                .build();

        injectorComponent.inject(this);

        if(getArguments() != null) {
            this.dataList = getArguments().getParcelableArrayList("LIST_VIDEOS");
            if(this.dataList == null) {
                repository.getVideo().compose(bindToLifecycle()).subscribe(videos -> {
                    dataList.addAll(videos.videos());
                    adapter.notifyDataSetChanged();
                });
            }
        } else {
            dataList = new ArrayList<>();
            repository.getVideo().compose(bindToLifecycle()).subscribe(videos -> {
                dataList.addAll(videos.videos());
                adapter.notifyDataSetChanged();
            });
        }

        repository.getVideo().compose(bindToLifecycle()).subscribe(videos -> {
            dataList.addAll(videos.videos());
            adapter.notifyDataSetChanged();
        });

        dataList = new ArrayList<>();
        adapter = new ListVideoAdapter(getContext(), dataList, this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_video, container, false);

        // Set the adapter
        if (view instanceof AutofitRecyclerView) {
            Context context = view.getContext();
            recyclerView = (AutofitRecyclerView) view;
            recyclerView.addItemDecoration(new MarginDecoration(getResources().getDimensionPixelSize(R.dimen.item_margin)));
            recyclerView.setHasFixedSize(true);
            recyclerView.setAdapter(adapter);
        }

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onSaveInstanceState (Bundle outState)
    {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onClick(View view, int position) {
        JCFullScreenActivity.startActivity(getContext(), dataList.get(position).getFilevideo(), JCVideoPlayerStandard.class, dataList.get(position).judul());
    }
}
